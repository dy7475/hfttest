package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.admindb.po.AdminVoipRelation;
import com.myfun.repository.erpdb.dao.ErpFunVoipLogMapper;
import com.myfun.repository.erpdb.po.ErpFunVoipLog;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminVoipRelationService;
import com.myfun.service.business.erpdb.ErpFunVoipLogService;
import com.myfun.service.business.erpdb.bean.param.CallParam;
import com.myfun.utils.DateUtil;
import com.myfun.utils.EncryptHelper;
import com.myfun.utils.JsonHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rest.Rest;

/**
 * ip电话
 * 
 * @ClassName: ErpFunVoipLogServiceImpl
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年12月1日 下午1:40:24
 *
 */
@Service
public class ErpFunVoipLogServiceImpl extends AbstractService<ErpFunVoipLog, ErpFunVoipLog>implements ErpFunVoipLogService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ErpFunVoipLogServiceImpl.class);
	@Autowired
	private ErpFunVoipLogMapper erpFunVoipLogMapper;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminVoipRelationService adminVoipRelationService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunVoipLogMapper;
	}

	/**
	 * @see ErpFunVoipLogService#call(CallParam)
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public String call(CallParam param) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(param.getARCHIVE_ID());

		String record = "1";
		if (StringUtil.containerValue(new Byte[] { 5, 6, 7, 8 }, param.getTARGET_TYPE())) {
			record = "0";
		}

		// 获取关联账户 如果不存在则直接创建
		AdminVoipRelation adminVoipRelation = adminVoipRelationService.getVoipRelationByNullCreate(param.getCALL_PHONE());
		String result = Rest.testCallback(true, Rest.ACCOUNT_SID, Rest.AUTH_TOKEN, AppConfig.getProperty("VOIP_APP_ID"), adminVoipRelation.getClientNumber(), param.getCALLED_PHONE(), param.getCALL_PHONE(), param.getCALL_PHONE(), record);
		LOGGER.info("第三方ip电话返回结果:" + result);
		Map<String, Object> mapJson = JsonHelper.parseMap(result);
		mapJson = (Map<String, Object>) mapJson.get("resp");
		String respCode = (String) mapJson.get("respCode");
		if (respCode.equals("000000")) {

			mapJson = (Map<String, Object>) mapJson.get("callback");
			String callId = String.valueOf(mapJson.get("callId"));

			// 发送的时候往erp数据库存记录
			String callTime = DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
			Integer callLength = 0;
			String callFee = "0";
			Byte callRecordDownLoad = 0;
			ErpFunVoipLog erpFunVoipLog = param.getVoipLog();
			erpFunVoipLog.setShardConnId(param.getCONN_ID());
			erpFunVoipLog.setCallId(callId);
			erpFunVoipLog.setCallTime(callTime);
			erpFunVoipLog.setCallLength(callLength);
			erpFunVoipLog.setCallFee(new BigDecimal(callFee));
			erpFunVoipLog.setCallRecordDownload(callRecordDownLoad);
			erpFunVoipLogMapper.insertSelective(erpFunVoipLog);
			return "1";
		}
		return "-1";
	}

	@Override
	public ErpFunVoipLog getErpFunVoipLogByCallId(String shardConnId, String callId) {
		return erpFunVoipLogMapper.getErpFunVoipLogByCallId(shardConnId, callId);
	}

}
