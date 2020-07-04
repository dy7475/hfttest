package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDealRecordService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErpFunDealRecordServiceImpl extends AbstractService<ErpFunDealRecord, ErpFunDealRecord> implements ErpFunDealRecordService{
	@Autowired ErpFunDealRecordMapper erpFunDealRecordMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
	ErpFunDealTaxesRecordMapper erpFunDealTaxesRecordMapper;
	@Autowired
	ErpFunDealTaxesMapper erpFunDealTaxesMapper;

	@PostConstruct
	@Override
	public void setBaseMapper() {
		this.baseMapper = erpFunDealRecordMapper;
	}
	/**
	 * 写日志
	 */
	@Override
	public void writeDealRecord(GeneralParam param, Integer dealId, String system, String updateClassic, Byte updateType,
								String trackContent, Integer type, Byte pfActual, boolean isDetailFlag, String payType) {
		String updateContent = buildUpdateContent(param.getCityId(), param.getCompId(), dealId, updateType, pfActual, payType);
		if (updateContent.length() <= 0) {
			throw new BusinessException("生成合同修改记录内容失败");
		}
		ErpFunDealRecord insertModel = new ErpFunDealRecord();
		if (0 != type) {
			if (isDetailFlag) {
				ErpFunDealRecord erpFunDealRecord = erpFunDealRecordMapper.getLastRecordId(param.getCityId(), dealId, updateType, pfActual);
				if (erpFunDealRecord != null) {
					insertModel.setFrontRecordId(erpFunDealRecord.getRecordId());
				}
			}
			insertModel.setUpdateContent(updateContent);
		}
		insertModel.setUpdateClassic(updateClassic);
		insertModel.setCompId(param.getCompId());
		insertModel.setAgreementNo(dealId + "");// 虽然字段名是AGREEMENT_NO 实际上存的是DEAL_ID  原因是  这个表是旧表  所以没有修改字段名  仍然实现原来的字段名
		insertModel.setUpdateDate(DateTimeHelper.getTimeNow());
		if (null != system) {
			insertModel.setUpdateUid(999);
			insertModel.setUpdateUserName("系统");
		} else {
			insertModel.setUpdateUid(param.getUserId());
			insertModel.setUpdateUserName(param.getUserName());
		}
		insertModel.setDeptId(param.getDeptId());
		insertModel.setTrackContent(trackContent);
		insertModel.setUpdateType(updateType);
		insertModel.setPfActual(pfActual);
		insertModel.setShardCityId(param.getCityId());
		erpFunDealRecordMapper.insertSelective(insertModel);
	}
	
	/**
	 * 构建写日志内容
	 *
	 * @param cityId
	 * @param dealId
	 * @param compId
	 * @param updateType
	 * @param pfActual
	 * @param payType
	 * @return
	 */
	private String buildUpdateContent(Integer cityId, Integer compId, Integer dealId, Byte updateType, Byte pfActual, String payType) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		ErpFunDeal deal = new ErpFunDeal();
		deal.setShardCityId(cityId);
		deal.setDealId(dealId);
		ErpFunDeal funDeal = erpFunDealMapper.selectByPrimaryKey(deal);
		if (updateType == 0) {
			Map<String, String> dealMap = BeanUtil.objToMap(funDeal);
			dealMap.put("updateTime",DateTimeHelper.formatDateTimetoString(funDeal.getUpdateTime()));
			paramMap.put("FUN_DEAL",dealMap);
		}
		List<Map<String, String>> mapList = new ArrayList<>();
		if (updateType == 1) {
			ErpProcessFinancExample processFinancExample = new ErpProcessFinancExample();
			processFinancExample.setShardCityId(cityId);
			ErpProcessFinancExample.Criteria financExampleCriteria = processFinancExample.createCriteria();
			processFinancExample.setOrderByClause("PF_ID");
			financExampleCriteria.andDealIdEqualTo(dealId).andCompIdEqualTo(compId);
			if (pfActual != null) {
				financExampleCriteria.andPfActualEqualTo(pfActual);
			}
			List<ErpProcessFinanc> financList = erpProcessFinancMapper.selectByExample(processFinancExample);
			for (ErpProcessFinanc financ : financList) {
				Map<String, String> financMap = BeanUtil.objToMap(financ);
				financMap.put("pfTime",DateTimeHelper.formatDateTimetoString(financ.getPfTime()));
				mapList.add(financMap);
			}
			paramMap.put("PROCESS_FINANC", mapList);
		} else if (updateType == 2) {
			ErpFunProfitExample funProfitExample = new ErpFunProfitExample();
			funProfitExample.setShardCityId(cityId);
			funProfitExample.createCriteria().andDealIdEqualTo(dealId).andCompIdEqualTo(compId);
			List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(funProfitExample);
			for (ErpFunProfit profit : profitList) {
				mapList.add(BeanUtil.objToMap(profit));
			}
			paramMap.put("FUN_PROFIT", mapList);
			paramMap.put("FINANC_NAME", funDeal.getFinancName());
		} else if (updateType == 4 || updateType == 5) {// 4=买方税费 5=卖方税费（税费日志详细比较）
			ErpFunDealTaxesRecordExample funDealTaxesRecordExample = new ErpFunDealTaxesRecordExample();
			funDealTaxesRecordExample.setShardCityId(cityId);

			ErpFunDealTaxesRecordExample.Criteria funDealTaxesRecordExampleCriteria = funDealTaxesRecordExample.createCriteria();
			if (payType != null) {
				funDealTaxesRecordExampleCriteria.andFeeTypeEqualTo(StringUtil.parseByte(payType));
			}
			funDealTaxesRecordExampleCriteria.andCompIdEqualTo(compId).andDealIdEqualTo(dealId);
			List<ErpFunDealTaxesRecord> dealTaxesRecords = erpFunDealTaxesRecordMapper.selectByExample(funDealTaxesRecordExample);
			paramMap.put("FUN_TAXES_RECORD", dealTaxesRecords);
			ErpFunDealTaxesExample dealTaxesExample = new ErpFunDealTaxesExample();
			dealTaxesExample.setShardCityId(cityId);
			ErpFunDealTaxesExample.Criteria exampleCriteria = dealTaxesExample.createCriteria();
			if (payType != null) {
				exampleCriteria.andPayTypeEqualTo(StringUtil.parseByte(payType));
			}
			exampleCriteria.andDealIdEqualTo(dealId).andCheckFlagEqualTo((byte) 1);
			List<ErpFunDealTaxes> taxes = erpFunDealTaxesMapper.selectByExample(dealTaxesExample);
			paramMap.put("FUN_TAXES", taxes);
		}
		return JSON.toJSONString(paramMap);
	}


}
