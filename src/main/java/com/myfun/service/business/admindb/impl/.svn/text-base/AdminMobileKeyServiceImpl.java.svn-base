package com.myfun.service.business.admindb.impl;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.AdminMobileKeyLoginMapper;
import com.myfun.repository.admindb.dao.AdminMobileKeyMapper;
import com.myfun.repository.admindb.dao.AdminSubscriptionSendLogMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminMobileKey;
import com.myfun.repository.admindb.po.AdminMobileKeyExample;
import com.myfun.repository.admindb.po.AdminSubscriptionSendLog;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class AdminMobileKeyServiceImpl extends AbstractService<AdminMobileKey, Integer> implements AdminMobileKeyService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminMobileKeyServiceImpl.class);
	
	@Autowired AdminMobileKeyMapper adminMobileKeyMapper;
	@Autowired AdminMobileKeyLoginMapper adminMobileKeyLoginMapper;
	@Autowired AdminSysParaService adminSysParaService;
	@Autowired AdminSubscriptionSendLogMapper adminSubscriptionSendLogMapper;
	@Autowired AdminSysParaMapper adminSysParaMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminMobileKeyMapper;
	}

	@Override
	public void addWrongTime(Integer keyId,Integer wrongTime) {
		adminMobileKeyMapper.updateWrongTime(keyId,wrongTime);
	}

	@Override
	public void changeStatus(Integer keyId) {
		adminMobileKeyMapper.updateStatus(keyId);
	}

	/**
	 * 创建一个验证码并插入短信记录
	 * @author 张宏利
	 * @since 2017年6月12日
	 * @param userMobile
	 * @param ipAddr
	 * @param content 支持一个%s用于放置验证码
	 * @return
	 */
	@Override
	public String creatMobileKeyAndInsert(String userMobile, String ipAddr, String content) {
		String code = StringUtil.getCode6();
		content = String.format(content, code);
		AdminMobileKey mobileKey = new AdminMobileKey();
		mobileKey.setMobile(userMobile);
		mobileKey.setKey(code);
		mobileKey.setIpAddr(ipAddr);
		mobileKey.setContent(content);
		adminMobileKeyMapper.insertSelective(mobileKey);
		return code;
	}
	
	/**
	 * 发送通知类短信
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @param phone 手机号
	 * @param signName 签名 1=好房优家
	 * @param message 消息内容
	 * @throws Exception
	 */
	@Override
	public void sendNoticeSms(String phone, String signName, String message){
		if("1".equals(signName)){
			signName = "好房优家";
		}
		final Map<String, String> paramMap = new HashMap<>();
		paramMap.put("action", "sendSmsBatch");
		paramMap.put("phone", phone);
		paramMap.put("smsSource", "sms4erp");
		paramMap.put("content", message);
		if(StringUtils.isNotBlank(signName)) {
			paramMap.put("signName", "【"+signName.trim()+"】");
		}
		try{
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						// 这里注意下，需要replace一下
						String sendMsgUrl = AppConfig.getProperty("SEND_MSG_PATH").replace("ReloadXML", "sendMsg");
						String result = HttpUtil.post(sendMsgUrl, paramMap);
						System.out.println("sendSms result="+result);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}catch(Exception e){
			e.printStackTrace();
		}
		AdminSubscriptionSendLog adminSubscriptionSendLog = new AdminSubscriptionSendLog();
		adminSubscriptionSendLog.setCreateTime(new Date());
		adminSubscriptionSendLog.setUserMobile(phone);
		adminSubscriptionSendLog.setMessage(message);
		adminSubscriptionSendLog.setResult("true");
		adminSubscriptionSendLog.setSendOrReceive((byte) 0);
		adminSubscriptionSendLog.setSendUser(999);
		adminSubscriptionSendLog.setUserName("");
		adminSubscriptionSendLogMapper.insertSelective(adminSubscriptionSendLog);
	}

	@Override
	public boolean validateSmsCode(String smsCode, String mobile) {
		String timeStr = adminSysParaService.getSysParamToString("MOBILE_KEY_INVALID_TIME");
		String countStr = adminSysParaService.getSysParamToString("MOBILE_KEY_INVALID_COUNT");
		int invalidTime = 30;// 默认30分钟有效期
		int invalidCount = 3;// 错误次数
		if(timeStr != null){
			invalidTime = StringUtil.paseInteger(timeStr, 30);// 默认30分钟有效期
		}
		if(countStr != null){
			invalidCount = StringUtil.paseInteger(countStr, 3);// 错误次数
		}
		AdminMobileKeyExample example = new AdminMobileKeyExample();
		example.createCriteria().andMobileEqualTo(mobile)
		.andWebIsNull().andStatusEqualTo(1).andWrongTimeLessThan((byte) invalidCount)
		.andCreateTimeGreaterThanOrEqualTo(getInvalidTime(invalidTime));
		example.setOrderByClause("CREATE_TIME DESC");
		List<AdminMobileKey> mobileKeyList = adminMobileKeyMapper.selectByExample(example);
		boolean returnCheck = false;
		if (Constants_DIC.TEST_MOBILE_KEY_USER_REGISTER_PWD.equals(smsCode)) {
			returnCheck = true;
		}
		if (mobileKeyList != null && mobileKeyList.size() > 0) {
			AdminMobileKey mobileKeyPO = mobileKeyList.get(0);
			if (mobileKeyPO != null) {
				if (smsCode.equals(mobileKeyPO.getKey())) {
					returnCheck = true;
				}
				AdminMobileKey mobileKeyUpdate = new AdminMobileKey();
				mobileKeyUpdate.setKeyId(mobileKeyPO.getKeyId());
				if (returnCheck) {
					mobileKeyUpdate.setResend(2);
					mobileKeyUpdate.setStatus(-1);
				} else {
					mobileKeyUpdate.setResend(2);
					mobileKeyUpdate.setWrongTime((byte) (mobileKeyPO.getWrongTime() + 1));
					if (mobileKeyPO.getWrongTime() >= invalidCount) {
						mobileKeyUpdate.setStatus(-1);
					}
				}
				adminMobileKeyMapper.updateByPrimaryKeySelective(mobileKeyUpdate);
			}
		}
		return returnCheck;
	}

	/**
	 * @tag 判断当前天该电话是否采用过拨打电话认证
	 * @author 邓永洪
	 * @since 2018/5/19
	 */
	@Override
	public boolean checkMobileDialToday(String mobile) {
		boolean returnCheck = false;
		List<AdminMobileKey> mobileKeyList = adminMobileKeyMapper.getCheckMobileDialToday(mobile);
		if (mobileKeyList.size() > 0) {
			returnCheck = true;
		}
		return returnCheck;
	}

	private Date getInvalidTime(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, -minute);
		return calendar.getTime();
	}

	/**
	 * @tag 优家门店合同状态改变时短信提醒审核人员
	 * @author 邓永洪
	 * @since 2018/7/13
	 */
	@Override
	public void sendSmsForYouJiaDealStatusChange(Set<String> mobiles, Byte youAduitStatus, String userName, String deptName, String dealNo, String fileName) {
		if (mobiles == null || mobiles.size() <= 0) {
			return;
		}
		String key = "";

		deptName = deptName.toLowerCase().replace("you+", "优家");
		if (Const.DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE == youAduitStatus) {// 提交审核后，需要内审时
			key = "DX1531210957190";
		} else if (Const.DIC_YOU_ADUIT_STATUS_FIRST_INSTANCE == youAduitStatus) {// 内审通过后，需要律师一审
			key = "DX1531210978115";
		} else if (Const.DIC_YOU_ADUIT_STATUS_SECOND_INSTANCE == youAduitStatus) {// 一审通过后，提交合同快照后需要二审时
			key = "DX1531211003018";
		} else {
			return;
		}
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap.put("deptName", deptName);
		jsonMap.put("dealNo", dealNo);
		jsonMap.put("fileName", fileName);
		jsonMap.put("userName", userName);
		for (String mobile : mobiles) {
			this.sendSms(key, mobile, jsonMap);
		}
	}

	/**
	 * @tag 发送短信 调统一的接口
	 * @author 邓永洪
	 * @since 2018/7/13
	 */
	private void sendSms(String key, String mobile, Map<String, String> jsonMap) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("key", key);
		paramMap.put("phone", mobile);
		paramMap.put("reqProject", "1");
		paramMap.put("paramJson", jsonMap);
		//HttpUtil.postJson("http://admin.myfun7.com/adminWeb/hftMsgCenter/sendMsgNew", paramMap);
		HttpUtil.postJson(AppConfig.getAdminWebUrl()+"/hftMsgCenter/sendMsgNew", paramMap);
	}

	public static void main(String[] args) {
//		Map<String, String> paramMap = new HashMap<>();
//		paramMap.put("smsSource", "aliyu");
//		paramMap.put("phone", "15228861532");
//		paramMap.put("signName", "好房通");
//		paramMap.put("smsModel", "SMS_96825020");
//		paramMap.put("reqProject", "1");
//		Map<String, String> jsonMap = new HashMap<>();
//		jsonMap.put("code", "123456");
//		jsonMap.put("product", "好房通");
//		paramMap.put("paramJson", JSON.toJSONString(jsonMap));
//		String s = HttpUtil.post("http://admin.myfun7.com/adminWeb/hftMsgCenter/sendMsgNew", paramMap);
//		System.out.println(s);
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("phone", "15228861532");
		paramMap.put("key", "DX1509499624122");
		paramMap.put("reqProject", "3");
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap.put("code", "123456");
		paramMap.put("paramJson", jsonMap);
		String result = HttpUtil.postJson("http://admin.myfun7.com/adminWeb/hftMsgCenter/sendMsgNew", paramMap);
		System.out.println(result);
	}

}
