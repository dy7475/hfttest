package com.myfun.service.business.admindb.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminFunVoicetransInfoMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminVoipPaidMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.admindb.po.AdminFunVoicetransInfo;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.admindb.po.AdminVoipPaid;
import com.myfun.repository.erpdb.dao.ErpFunVoipLogMapper;
import com.myfun.repository.erpdb.po.ErpFunVoipLog;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminVoipPaidService;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rest.EncryptUtil;

/**
 * ip电话操作
 * 
 * @ClassName: AdminVoipPaidServiceImpl
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月30日 下午8:52:21
 *
 */
@Service
public class AdminVoipPaidServiceImpl extends AbstractService<AdminVoipPaid, Integer>implements AdminVoipPaidService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminVoipPaidServiceImpl.class);
	@Autowired
	private AdminVoipPaidMapper adminVoipPaidMapper;
	@Autowired
	private ErpFunVoipLogMapper erpFunVoipLogMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private AdminFunVoicetransInfoMapper adminFunVoicetransInfoMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminVoipPaidMapper;
	}

	/**
	 * @see AdminVoipPaidService#voipCallBack(String, String, Integer, Byte,
	 *      Byte, String, Date, Date)
	 */
	@Transactional
	@Override
	public void voipCallBack(String connId, String callId, Integer length, Byte reason, Byte subreason, String recordurl, Date startTime, Date stopTime) {
		if (StringUtil.isNotEmpty(recordurl)) {
			recordurl = recordurl.replace(AppConfig.getProperty("s"), "") + "?sig=" + EncryptUtil.getSig(callId);
		}
		// 查询日志表
		// ErpFunVoipLog erpFunVoipLog = new ErpFunVoipLog();
		// erpFunVoipLog.setShardConnId(connId);
		// erpFunVoipLog.setCallId(callId);
		ErpFunVoipLog erpFunVoipLog = erpFunVoipLogMapper.getErpFunVoipLogByCallId(connId, callId);

		// 查询用户信息
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(erpFunVoipLog.getArchiveId());

		double callPrice = 0.0;
		Integer paidId = 0;

		if (!Const.VoipConst.CALL_VOIP_NOT_FREE.contains(erpFunVoipLog.getTargetType())) {
			// 查询资金账户
			AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(adminFunArchive.getUaId());

			// 查询扣除好房币情况
			AdminSysPara voipPhoneCostLimit = adminSysParaMapper.selectByPrimaryKey("VOIP_PHONE_COST_LIMIT");

			// 打电话价格
			int minute = (int) Math.ceil(length / 60.0);
			callPrice = StringUtil.parseDouble(voipPhoneCostLimit.getParamValue(), 0.11) * minute;

			// 更新资金账户余额
			AdminFunUserAccount upUserAccount = new AdminFunUserAccount();
			upUserAccount.setUaId(adminFunArchive.getUaId());
			upUserAccount.setHaofangAmount(adminFunUserAccount.getHaofangAmount().subtract(new BigDecimal(callPrice)));
			upUserAccount.setHaofangBuy(adminFunUserAccount.getHaofangBuy().subtract(new BigDecimal(callPrice)));
			adminFunUserAccountMapper.updateByPrimaryKeySelective(upUserAccount);

			// 创建ip电话拨打消费记录
			BigDecimal amountAfter = adminFunUserAccount.getHaofangBuy().subtract(BigDecimal.valueOf(callPrice));

			AdminVoipPaid adminVoipPaid = new AdminVoipPaid();
			adminVoipPaid.setUaId(adminFunArchive.getUaId());
			adminVoipPaid.setArchiveId(adminFunArchive.getArchiveId());
			adminVoipPaid.setCityId(adminFunArchive.getCityId());
			adminVoipPaid.setPaidCatigory("PAY");
			adminVoipPaid.setPaidType(erpFunVoipLog.getTargetType());
			adminVoipPaid.setCalledPhone(erpFunVoipLog.getCalledPhone());
			adminVoipPaid.setCallPhone(erpFunVoipLog.getCallPhone());
			adminVoipPaid.setCallingLength(length);
			adminVoipPaid.setCallId(callId);
			adminVoipPaid.setStartTime(startTime);
			adminVoipPaid.setStopTime(stopTime);
			adminVoipPaid.setAmount(BigDecimal.valueOf(callPrice));
			adminVoipPaid.setPadiTime(new Date());
			adminVoipPaid.setAmountBefore(adminFunUserAccount.getHaofangBuy());
			adminVoipPaid.setAmountAfter(amountAfter);
			adminVoipPaid.setPaidSource(erpFunVoipLog.getLogSource());
			adminVoipPaidMapper.insertSelective(adminVoipPaid);
			paidId = adminVoipPaid.getPaidId();
		}

		// 修改erp库记录
		ErpFunVoipLog upVoipLog = new ErpFunVoipLog();
		upVoipLog.setPaidId(paidId);
		upVoipLog.setCallLength(length);
		upVoipLog.setCallFee(BigDecimal.valueOf(callPrice));
		upVoipLog.setCutReason(reason);
		upVoipLog.setReasonDesc(subreason);
		upVoipLog.setCallRecord(recordurl);
		upVoipLog.setStartTime(startTime);
		upVoipLog.setStopTime(stopTime);
		upVoipLog.setVoipId(erpFunVoipLog.getVoipId());
		upVoipLog.setShardArchiveId(adminFunArchive.getArchiveId());
		erpFunVoipLogMapper.updateByPrimaryKeySelective(upVoipLog);

		// 插入同步语音表
		if (erpFunVoipLog.getTargetType() != null && (erpFunVoipLog.getTargetType() < 5 || erpFunVoipLog.getTargetType() > 8)) {
			AdminFunVoicetransInfo adminFunVoicetransInfo = new AdminFunVoicetransInfo();
			adminFunVoicetransInfo.setConnId(connId);
			adminFunVoicetransInfo.setCityId((int) adminFunArchive.getCityId());
			adminFunVoicetransInfo.setVoipId(erpFunVoipLog.getVoipId());
			adminFunVoicetransInfo.setCallId(callId);
			adminFunVoicetransInfo.setDownStatus((byte) 0);
			adminFunVoicetransInfo.setStopTime(stopTime);
			adminFunVoicetransInfo.setVoiceUrl(recordurl);
			adminFunVoicetransInfoMapper.insertSelective(adminFunVoicetransInfo);
		}
	}
	
//	public static void main(String[] args) {
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("log_id", 4884350);
//		param.put("step", "3");//拨打电话申请房勘
//		param.put("call", "18780176004");
//		param.put("called", "18190490911");
//		param.put("voip_id", "9819");
//		param.put("archive_id", 571207);
//		param.put("from", "voipcallback");
//		System.out.println(HttpUtil.post("http://didi.haofang.net/B/Business/Order/update_step.html", param));
//	}
	
}
