package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminWeiUserInfoMapper;
import com.myfun.repository.admindb.po.AdminWeiUserInfo;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpFunContractTemplaeParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunContractTemplateService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.jms.bean.YouJiaWxPushMessage;
import com.myfun.service.push.YoujiaWXPushUtil;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.net.URLEncoder;
import java.util.*;

@Service
public class ErpFunContractTemplateServiceImpl extends AbstractService<ErpFunContractTemplae, ErpFunContractTemplae> implements ErpFunContractTemplateService{

	@Autowired
	ErpFunContractTemplaeMapper erpFunContractTemplaeMapper;
	@Autowired
	ErpFunContractIndexMapper erpFunContractIndexMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunIndexValueMapper erpFunIndexValueMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	AdminWeiUserInfoMapper adminWeiUserInfoMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpFunDealRecordMapper erpFunDealRecordMapper;
	@Autowired
	ErpFunContractMapper erpFunContractMapper;
	@Autowired
	AdminFunDeptsService adminFunDeptsService;
	@Autowired
	ErpFunContractDealMapper erpFunContractDealMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunContractTemplaeMapper;
	}


	/**
	 * 添加修改合同的模板
	 *
	 * **/
	@Transactional
	@Override
	public void addOrEditContractTemplate(Integer cityId, Integer compId, ErpFunContractTemplae erpFunContractTemplae, List<ErpFunContractIndex> paramList) {

		Integer templateId = erpFunContractTemplae.getTemplateId();
		erpFunContractTemplae.setShardCityId(cityId);
		if(null == templateId) {
			// 新增
			erpFunContractTemplae.setCompId(compId);
			erpFunContractTemplae.setCreationTime(new Date());
			erpFunContractTemplae.setTemplateStatus(new Byte(Constants_DIC.DIC_CONTRACT_TEMPLATE_STATUS_1));

			erpFunContractTemplae.setCityId(cityId);
			erpFunContractTemplaeMapper.insertSelective(erpFunContractTemplae);
			templateId = erpFunContractTemplae.getTemplateId();
		}else{
			// 编辑
			erpFunContractTemplaeMapper.updateByPrimaryKeySelective(erpFunContractTemplae);
			// 删除原有指标参数
			ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
			erpFunContractIndexExample.setShardCityId(cityId);
			erpFunContractIndexExample.createCriteria().andTemplateIdEqualTo(templateId);
			erpFunContractIndexMapper.deleteByExample(erpFunContractIndexExample);
		}

		createIndexBatch(paramList, templateId, cityId, compId);
	}

	@Transactional
	@Override
	public Integer saveContract(Integer cityId, Integer compId, ErpFunContractTemplaeParam erpFunContractTemplaeParam, Integer deptId, Integer userId, String userName) throws Exception{

		// 判断合同状态 如果一审就不能修改了
		ErpFunDeal funDealPO = new ErpFunDeal();
		funDealPO.setDealId(erpFunContractTemplaeParam.getDealId());
		funDealPO.setShardCityId(cityId);
		funDealPO = erpFunDealMapper.selectByPrimaryKey(funDealPO);

		// 判断id
		if(null == erpFunContractTemplaeParam.getContractId()) {
			ErpFunContractDealExample erpFunContractDealExample = new ErpFunContractDealExample();
			erpFunContractDealExample.setShardCityId(cityId);
			erpFunContractDealExample.createCriteria().andDealIdEqualTo(funDealPO.getDealId());
			erpFunContractDealMapper.deleteByExample(erpFunContractDealExample);
		}

		List<ErpFunIndexValue> paramList = JSON.parseArray(erpFunContractTemplaeParam.getIndexList(), ErpFunIndexValue.class);
		Integer contractId = erpFunContractTemplaeParam.getContractId();
		Byte youAuditStatus = funDealPO.getYouAduitStatus();
		String fileName = "合同";
		Integer oldContractId = funDealPO.getContractId();
		if (Constants_DIC.DIC_FUN_DEAL_FILE_TYPE_2.equals(erpFunContractTemplaeParam.getContentType())) {
			youAuditStatus = funDealPO.getYouAduitStatusProtocol();
			fileName = "协议";
			oldContractId = funDealPO.getProtocolId();
		}
		Integer gContractId = saveOrEditContract(cityId, compId, deptId, userId, contractId, erpFunContractTemplaeParam, funDealPO.getDealId(), oldContractId);
		String content = "";
		String classic = "";
		// 如果之前的不为空说明是修改
		if(null != contractId) {
			if(youAuditStatus.equals(Constants_DIC.DIC_YOU_ADUIT_STATUS_ZERO_INSTANCE.byteValue()) || youAuditStatus.equals(Constants_DIC.DIC_YOU_ADUIT_STATUS_THRID_INSTANCE.byteValue()) || youAuditStatus.equals(Constants_DIC.DIC_YOU_ADUIT_STATUS_EIGHT_INSTANCE)) {
				// 修改指标值
				for (ErpFunIndexValue erpFunIndexValue : paramList) {
					erpFunIndexValue.setShardCityId(cityId);
					erpFunIndexValueMapper.updateByPrimaryKeySelective(erpFunIndexValue);
				}
				content = " 修改了" + fileName + "指标数据";
				classic = Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_DEALEDIT;
			} else {
				throw new BusinessException("审核中或审核通过的" + fileName + "不能进行修改！");
			}
			// 否则为插入
		} else {
			for (ErpFunIndexValue erpFunIndexValue : paramList) {
				erpFunIndexValue.setContractId(gContractId);
				erpFunIndexValue.setCreationTime(new Date());
				erpFunIndexValue.setValueId(null);
				erpFunIndexValue.setIndexValueOriginal(erpFunIndexValue.getIndexValue());
				erpFunIndexValue.setShardCityId(cityId);
				erpFunIndexValueMapper.insertSelective(erpFunIndexValue);
			}
			// 关联fun_deal
			updateFunDeal(cityId, gContractId, erpFunContractTemplaeParam.getDealId(),
					erpFunContractTemplaeParam.getContentType(), erpFunContractTemplaeParam.getSubmitType());
			// 写日志
			content = " 生成了" + fileName;
			classic = Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_ADDCONTRACT;
			if (Constants_DIC.DIC_FUN_DEAL_FILE_TYPE_2.equals(erpFunContractTemplaeParam.getContentType())) {
				classic = Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_ADDCONTRACT2;
			}
		}

		if(null != erpFunContractTemplaeParam.getSubmitType() && 1 == erpFunContractTemplaeParam.getSubmitType()) {
			// 修改合同信息
			ErpFunDeal upFunDealPO = new ErpFunDeal();
			upFunDealPO.setYouAduitStatusProtocol(Constants_DIC.DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE);
			upFunDealPO.setShardCityId(cityId);
			erpFunDealMapper.updateByPrimaryKeySelective(upFunDealPO);
			// 查询对接人员
			ErpFunDepts erpFunDepts = new ErpFunDepts();
			erpFunDepts.setShardCityId(cityId);
			erpFunDepts.setDeptId(funDealPO.getDeptId());

			erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(erpFunDepts);

			List<AdminWeiUserInfo> youConnectorList = adminFunDeptsService.getYouConnectorList(erpFunDepts.getCompNo(), erpFunDepts.getDeptNo());
			if(Constants_DIC.DIC_FUN_DEAL_FILE_TYPE_2.equals(erpFunContractTemplaeParam.getContentType()) && youConnectorList.size() > 0) {
				// 短信推送
				Set<String> userMobiles = new HashSet<>();
				AdminWeiUserInfo adminWeiUserInfoPO = youConnectorList.get(0);
				userMobiles.add(adminWeiUserInfoPO.getUserMobile());

				sendSmsForYouJiaDealStatusChange(userMobiles, Constants_DIC.DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE, "", funDealPO.getSignUserDeptName(), funDealPO.getContractNo(), "");
				// 微信推送
				String weixinOpenId = adminWeiUserInfoPO.getWeixinOpenId();
				if (StringUtils.isNotBlank(weixinOpenId)) {
					YouJiaWxPushMessage youJiaWxPushMessage = new YouJiaWxPushMessage();
					String action = "noticeLawyer";
					String typeStr = Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(funDealPO.getDealType()) ? "出售合同" : "出租合同";
					String paramOne = "您有一个" + fileName + "需要审核,点击立即处理";
//					Map<String, Object> bMap = new HashMap<>();
//					bMap.put("action", action); // 取模板ID
//					bMap.put("paramOne", paramOne); // 标题
//					bMap.put("paramTwo", funDealPO.getContractNo()); // 编号
//					bMap.put("paramThree", typeStr); // 类别
//					bMap.put("paramFour", funDealPO.getSignUserDeptName()); // 签约门店
//					bMap.put("paramFive", DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss")); // 签约人员
//					bMap.put("paramSix", "等待内审"); // 审核状态
//					bMap.put("remark", "请及时处理!"); // remark
//					bMap.put("openIds", weixinOpenId);
					String path = "information";
					if (null != erpFunContractTemplaeParam.getContentType() && Constants_DIC.DIC_FUN_DEAL_FILE_TYPE_2.equals(erpFunContractTemplaeParam.getContentType())) {
						path = "sideAgreement";
					}
					String href = "http://youjia.haofang.net/Home/Contract/" + path + ".html?deal_id=" + funDealPO.getDealId();
//					bMap.put("hrefhref", URLEncoder.encode(href, "UTF-8"));

					youJiaWxPushMessage.setAction(action);
					youJiaWxPushMessage.setParamOne(paramOne);
					youJiaWxPushMessage.setParamTwo(funDealPO.getContractNo());
					youJiaWxPushMessage.setParamThree(typeStr);
					youJiaWxPushMessage.setParamFour(funDealPO.getSignUserDeptName());
					youJiaWxPushMessage.setParamFive(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
					youJiaWxPushMessage.setParamSix("等待内审");
					youJiaWxPushMessage.setRemark("请及时处理!");
					youJiaWxPushMessage.setOpenIds(weixinOpenId);
					youJiaWxPushMessage.setHrefhref(URLEncoder.encode(href, "UTF-8"));
					youJiaWxPushMessage.setDealId(funDealPO.getDealId());
					youJiaWxPushMessage.setCityId(cityId);

					YoujiaWXPushUtil.getInstance().sendMessage(youJiaWxPushMessage);
				}
			}
			// 推送内部人员
			String trackContent = erpFunUsersService.getCurrUserName(cityId, userId, deptId);
			trackContent += " 将" + fileName + "提交内部审核";
			writeFunDealRecord(erpFunContractTemplaeParam.getDealId(), compId, deptId,
					userId, userName, trackContent,
					Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_ADUIT2, new Byte("0"), null, cityId);
		}
		content = erpFunUsersService.getCurrUserName(cityId, userId, deptId) + content;
		Integer type = null != contractId ? 3 : 0;
		writeFunDealRecord(erpFunContractTemplaeParam.getDealId(), compId, deptId,
				userId, userName, content, classic, type.byteValue(), JSON.toJSONString(paramList), cityId);
		return gContractId;
	}

	private void writeFunDealRecord(Integer agreementNo , Integer compId, Integer deptId, Integer userId,
									String userName, String content, String classic, Byte type , String indexList, Integer cityId) {
		ErpFunDealRecord erpFunDealRecord = new ErpFunDealRecord();
		erpFunDealRecord.setShardCityId(cityId);
		erpFunDealRecord.setAgreementNo(agreementNo + "");
		erpFunDealRecord.setCompId(compId);
		erpFunDealRecord.setDeptId(deptId);
		erpFunDealRecord.setTrackContent(content);
		erpFunDealRecord.setUpdateClassic(classic);
		erpFunDealRecord.setUpdateDate(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		erpFunDealRecord.setUpdateType(type); // 指标
		erpFunDealRecord.setUpdateUid(userId);
		erpFunDealRecord.setUpdateUserName(userName);
		if(StringUtils.isNotBlank(indexList)) {
			List<Map<String, Object>> resList = new ArrayList<>();
			Map<String, String> pMap = new HashMap<>();
			List<ErpFunIndexValue> paramList = JSON.parseArray(indexList, ErpFunIndexValue.class);
			Set<Integer> indexValueId = new HashSet<>();
			for (ErpFunIndexValue erpFunIndexValue : paramList) {
				indexValueId.add(erpFunIndexValue.getIndexId());
			}
			List<ErpFunContractIndex> erpFunContractIndices = new ArrayList<>();
			if(indexValueId.size() > 0) {
				ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
				erpFunContractIndexExample.setShardCityId(cityId);
				erpFunContractIndexExample.createCriteria().andIndexIdIn(new ArrayList<>(indexValueId));
				erpFunContractIndices = erpFunContractIndexMapper.selectByExample(erpFunContractIndexExample);
			}
			for (ErpFunIndexValue erpFunIndexValue : paramList) {

				for (ErpFunContractIndex erpFunContractIndex : erpFunContractIndices) {
					if(erpFunIndexValue.getIndexId().equals(erpFunContractIndex.getIndexId())) {
						Map<String, Object> objMap = BeanUtil.object2Map(erpFunContractIndex);
						if(null != erpFunContractIndex) {
							objMap.put("indexName", erpFunContractIndex.getIndexName());
						}
						resList.add(objMap);
					}
				}


			}
			pMap.put("FUN_DEAL", JSON.toJSON(resList)+"");
			erpFunDealRecord.setUpdateContent(JSON.toJSONString(pMap));
		}
		ErpFunDealRecord erpFunDealRecord1 = erpFunDealRecordMapper.getLastRecordId(cityId, agreementNo, type,null);
		if(null != erpFunDealRecord1 && 3 == type.intValue()) {
			erpFunDealRecord.setFrontRecordId(erpFunDealRecord1.getRecordId());
		}
		erpFunDealRecordMapper.insertSelective(erpFunDealRecord);
	}

    private void sendSmsForYouJiaDealStatusChange(Set<String> mobiles, Byte youAduitStatus, String userName, String deptName, String dealNo, String fileName) {
        if(mobiles == null || mobiles.size() <= 0) {
            return;
        }
        String smsContent = null;
        deptName = deptName.toLowerCase().replace("you+", "优家");
        if(Constants_DIC.DIC_YOU_ADUIT_STATUS_SEVEN_INSTANCE.equals(youAduitStatus)) {// 提交审核后，需要内审时
            smsContent = "您好，"+deptName+"将编号为"+dealNo+"的"+fileName+"提交审核，请尽快审核！";
        } else if(Constants_DIC.DIC_YOU_ADUIT_STATUS_FIRST_INSTANCE.equals(youAduitStatus)) {// 内审通过后，需要律师一审
            smsContent = "您好，优家总部"+userName+"已将"+deptName+"编号为"+dealNo+"的"+fileName+"提交律师审核，请尽快审核！";
        } else if(Constants_DIC.DIC_YOU_ADUIT_STATUS_SECOND_INSTANCE.equals(youAduitStatus)) {// 一审通过后，提交合同快照后需要二审时
            smsContent = "您好，"+deptName+"将编号为"+dealNo+"的合同快照提交律师审核，请尽快审核！";
        } else {
            return;
        }
        smsContent += "退订回T";
        for (String mobile : mobiles) {
            this.sendSms(mobile, "1", smsContent);
        }
    }

    private void sendSms(String phone, String signName, String message){
        if("1".equals(signName)){
            signName = "好房优家";
        }
        final Map<String, String> paramMap = new HashMap<>();
        paramMap.put("action", "sendSms");
        paramMap.put("phone", phone);
        paramMap.put("smsSource", "sms4erp");
        paramMap.put("signName", "【"+signName.trim()+"】");
        paramMap.put("content", message);
        try{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String sendMsgUrl = AppConfig.getAdminWebUrl()+"/hftMsgCenter/sendMsg";
                        // 这里注意下，需要replace一下
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

    }


	// 关联合同
	private void updateFunDeal(Integer cityId, Integer contractId, Integer dealId, Integer conentType, Integer submitType){
		ErpFunDeal erpFunDeal = new ErpFunDeal();
		if(Constants_DIC.DIC_FUN_DEAL_FILE_TYPE_1.equals(conentType)) {
			erpFunDeal.setContractId(contractId);
		}else {
			erpFunDeal.setYouAduitStatusProtocol(new Byte("0"));
			if(null != submitType && 1 == submitType) {
				erpFunDeal.setYouAduitStatusProtocol(new Byte("7"));
				erpFunDeal.setSubAduitTime(new Date());
			}
			erpFunDeal.setProtocolId(contractId);
		}

		ErpFunDealExample erpFunDealExample = new ErpFunDealExample();
		erpFunDealExample.setShardCityId(cityId);
		erpFunDealExample.createCriteria().andDealIdEqualTo(dealId);
		erpFunDealMapper.updateByExampleSelective(erpFunDeal, erpFunDealExample);
	}

	private Integer saveOrEditContract(Integer cityId, Integer compId, Integer deptId, Integer userId,Integer contractId,
									   ErpFunContractTemplaeParam erpFunContractTemplaeParam, Integer dealId, Integer oldContractId) {
		ErpFunContract funContractPO = new ErpFunContract();
		funContractPO.setShardCityId(cityId);
		funContractPO.setSealPosition(erpFunContractTemplaeParam.getSealPosition());
		funContractPO.setLogoPosition(erpFunContractTemplaeParam.getLogoPosition());
		funContractPO.setContractContent(erpFunContractTemplaeParam.getTemplateContent());
		funContractPO.setContractSubContent(erpFunContractTemplaeParam.getContractSubContent());
		// 存在合同的 不在做内容修改
		if(null == contractId) {
			if(StringUtils.isNotBlank(erpFunContractTemplaeParam.getTemplateContent())) {
				funContractPO.setCompId(compId);
				funContractPO.setCreationTime(new Date());
				funContractPO.setCreationUid(userId);
				funContractPO.setDeptId(deptId);
				funContractPO.setLineHeight(erpFunContractTemplaeParam.getLineHeight());
				funContractPO.setTemletId(erpFunContractTemplaeParam.getTemplateId());
				funContractPO.setTemplateName(erpFunContractTemplaeParam.getTemplateName());
				erpFunContractMapper.insertSelective(funContractPO);
				contractId = funContractPO.getContractId();
//				ErpFunContractDealExample erpFunContractDealExample = new ErpFunContractDealExample();
//				erpFunContractDealExample.setShardCityId(cityId);
//				erpFunContractDealExample.createCriteria().andDealIdEqualTo(dealId);
//				erpFunContractDealMapper.deleteByExample(erpFunContractDealExample);

				// 写关联表
				ErpFunContractDeal erpFunContractDeal = new ErpFunContractDeal();
				erpFunContractDeal.setContractId(funContractPO.getContractId());
				erpFunContractDeal.setContractType(erpFunContractTemplaeParam.getContentType().byteValue());
				erpFunContractDeal.setDealId(dealId);
				erpFunContractDeal.setShardCityId(cityId);

				erpFunContractDeal.setCaseType(erpFunContractTemplaeParam.getCaseType().byteValue());
				erpFunContractDealMapper.insertSelective(erpFunContractDeal);
				return funContractPO.getContractId();
			}
		}else {
			funContractPO.setIsEdit(new Byte("1"));
			funContractPO.setContractId(contractId);
			erpFunContractMapper.updateByPrimaryKeySelective(funContractPO);

//			ErpFunContractDealExample erpFunContractDealExample = new ErpFunContractDealExample();
//
//			erpFunContractDealExample.setShardCityId(cityId);
//			erpFunContractDealExample.createCriteria().andContractTypeEqualTo(erpFunContractTemplaeParam.getContentType().byteValue()).andDealIdEqualTo(dealId);
//			List<ErpFunContractDeal> erpFunContractDeals = erpFunContractDealMapper.selectByExample(erpFunContractDealExample);
//
//
//			for (ErpFunContractDeal erpFunContractDeal : erpFunContractDeals) {
//				if(erpFunContractDeal.getContractId().equals(oldContractId)) {
//					erpFunContractDeal.setContractId(funContractPO.getContractId());
//					erpFunContractDeal.setShardCityId(cityId);
//					erpFunContractDealMapper.updateByPrimaryKeySelective(erpFunContractDeal);
//					break;
//				}
//			}
		}
		return contractId;
	}


	private void createIndexBatch(List<ErpFunContractIndex> paramList, Integer templateId, Integer cityId, Integer compId){
		// 模板指标关系
		if(paramList.size() > 0) {
			for (ErpFunContractIndex erpFunContractIndex : paramList) {
				erpFunContractIndex.setShardCityId(cityId);
				erpFunContractIndex.setCompId(compId);
				erpFunContractIndex.setTemplateId(templateId);
				erpFunContractIndex.setIndexId(null);
				erpFunContractIndexMapper.insertSelective(erpFunContractIndex);
			}
		}
	}
}
