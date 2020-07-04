package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBillCodelogService;
import com.myfun.service.business.erpdb.ErpFunBillPrintService;
import org.apache.commons.lang.StringUtils;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
public class ErpFunBillCodelogServiceImpl extends AbstractService<ErpFunBillCodelog, ErpFunBillCodelog> implements ErpFunBillCodelogService {

	@Autowired
	ErpFunBillCodelogMapper erpFunBillCodelogMapper;
	@Autowired
	ErpFunBillCodeMapper erpFunBillCodeMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunBillMapper erpFunBillMapper;

	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunBillCodelogMapper;
	}

	/**
	 * 更新票据编号
	 * @param type 1：增加使用  2：作废，考虑配置
	 * @author lcb
	 * @date 2018/7/14
	 * @return
	 */
	@Transactional
	@Override
	public void updateBillCodeLogStatus(Integer cityId, Integer compId, String codeNo, String type) {
		List<ErpFunBillCodelog> codeLogList =erpFunBillCodelogMapper.getFunBillCodelogByCodeNo(cityId,compId,codeNo);
		if (codeLogList.isEmpty()) {
			return;
		}
		ErpFunBillCodelog funBillCodelogPO = codeLogList.get(0);
		funBillCodelogPO.setShardCityId(cityId);
		ErpFunBillCode funBillCodePO = erpFunBillCodeMapper.getFunBillCodeByCodeId(cityId,funBillCodelogPO.getCodeId());
		if ("0".equals(funBillCodePO.getStatus())) {
			return;
		}
		if ("1".equals(type)) {
			funBillCodelogPO.setUseStatus((byte) 1);
			erpFunBillCodelogMapper.updateByPrimaryKeySelective(funBillCodelogPO);
			Integer usedCount = funBillCodePO.getUsedCount();
			usedCount = usedCount + 1;
			funBillCodePO.setUsedCount(usedCount);
			erpFunBillCodeMapper.updateByPrimaryId(cityId,usedCount,funBillCodePO.getCodeId());
		} else if ("2".equals(type)) {
			// 判断参数 是否作废启用
			// 获取系统参数
			String paramVal = erpSysParaMapper.getParamValue(cityId,compId,"INVALID_BILLNO_CAN_USE_AGAIN");
			if (StringUtils.isBlank(paramVal) || "0".equals(paramVal)) {
				return;
			} else {
				int count = erpFunBillMapper.countFunBill(cityId,compId,codeNo);
				if (count==0) {
					funBillCodelogPO.setUseStatus((byte) 0);
					erpFunBillCodelogMapper.updateByPrimaryKeySelective(funBillCodelogPO);
//					erpFunBillCodelogMapper.updateByPrimaryId(cityId,funBillCodelogPO.getCodelogId(),0);
					Integer usedCount = funBillCodePO.getUsedCount();
					if (usedCount > 0) {
						usedCount = usedCount - 1;
					}
					funBillCodePO.setUsedCount(usedCount);
					erpFunBillCodeMapper.updateByPrimaryId(cityId,usedCount,funBillCodePO.getCodeId());
				}
			}
		}
	}

	@Override
	public Integer judgeBillCodeNoRepeatByDeal(Integer cityId, Integer compId, Integer billCodeId, String billNo, Byte billType, Integer dealId) {
		//诚意金、合同票据号分开判重 1是0否
		String earbestDealBillRepeat = erpSysParaMapper.getParamValue(cityId, compId, "EARBEST_DEAL_BILL_REPEAT");/*.selectParamValueByCompIdAndParamId(cityId, compId, "EARBEST_DEAL_BILL_REPEAT");*/
		//作废的合同,诚意金票据可以重新使用 1是0否
		String invalidBillNoCanUseAgain = erpSysParaMapper.getParamValue(cityId, compId,"INVALID_BILLNO_CAN_USE_AGAIN");/*erpSysParaMapper.selectParamValueByCompIdAndParamId(cityId, compId, "INVALID_BILLNO_CAN_USE_AGAIN");*/

		ErpFunBillExample example = new ErpFunBillExample();
		example.setShardCityId(cityId);
		ErpFunBillExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId).andBillNoEqualTo(billNo).andDealIdNotEqualTo(dealId);
		if(StringUtils.isNotBlank(earbestDealBillRepeat) && "1".equals(earbestDealBillRepeat)) {
			if (0 == billType.intValue()) {
				criteria.andBillTypeEqualTo(billType);
			} else {
				criteria.andBillTypeNotEqualTo((byte) 0);
			}
		}

		if(StringUtils.isNotBlank(invalidBillNoCanUseAgain) && "1".equals(invalidBillNoCanUseAgain)) {
			criteria.andBillStatusNotEqualTo((byte) 2);
		}

		return erpFunBillMapper.countByExample(example);
	}

	@Override
	public Integer judgeBillCodeNoRepeat(Integer cityId, Integer compId, Integer billCodeId, String billNo ,Byte billType) {
		//诚意金、合同票据号分开判重 1是0否
		String earbestDealBillRepeat = erpSysParaMapper.getParamValue(cityId, compId, "EARBEST_DEAL_BILL_REPEAT");/*.selectParamValueByCompIdAndParamId(cityId, compId, "EARBEST_DEAL_BILL_REPEAT");*/
		//作废的合同,诚意金票据可以重新使用 1是0否
		String invalidBillNoCanUseAgain = erpSysParaMapper.getParamValue(cityId, compId,"INVALID_BILLNO_CAN_USE_AGAIN");/*erpSysParaMapper.selectParamValueByCompIdAndParamId(cityId, compId, "INVALID_BILLNO_CAN_USE_AGAIN");*/

		ErpFunBillExample example = new ErpFunBillExample();
		example.setShardCityId(cityId);
		ErpFunBillExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId).andBillNoEqualTo(billNo);
		if(StringUtils.isNotBlank(earbestDealBillRepeat) && "1".equals(earbestDealBillRepeat)) {
			if (0 == billType.intValue()) {
				criteria.andBillTypeEqualTo(billType);
			} else {
				criteria.andBillTypeNotEqualTo((byte) 0);
			}
		}

		if(StringUtils.isNotBlank(invalidBillNoCanUseAgain) && "1".equals(invalidBillNoCanUseAgain)) {
			criteria.andBillStatusNotEqualTo((byte) 2);
		}

		return erpFunBillMapper.countByExample(example);
	}
	@Override
	public void deduceCodeNoEmptyToRepeatUse(String oldCodeNo,String newCodeNo,Integer compId,Integer cityId) {
		if (Objects.isNull(compId)||Objects.isNull(cityId)) {
			return;
		}
		int  flag = 0;
		int oldCodeId = -1;
		if (StringUtil.isNotBlank(oldCodeNo)) {
			List<ErpFunBillCodelog> record = erpFunBillCodelogMapper.getFunBillCodelogByCodeNo(cityId, compId, oldCodeNo);
			if (!record.isEmpty()) {
				ErpFunBillCodelog billCodelog = record.get(0);

				billCodelog.setUseStatus((byte)0);
				billCodelog.setShardCityId(cityId);
				int count = erpFunBillCodelogMapper.updateByPrimaryKeySelective(billCodelog);
				if (count > 0) {
					flag++;
					oldCodeId = billCodelog.getCodeId();
				}
			}
		}

		int newCodeId = -1;
		if (StringUtil.isNotBlank(newCodeNo)) {
			List<ErpFunBillCodelog> record = erpFunBillCodelogMapper.getFunBillCodelogByCodeNo(cityId, compId, newCodeNo);
			if (!record.isEmpty()) {
				ErpFunBillCodelog billCodelog = record.get(0);
				billCodelog.setUseStatus((byte)1);
				billCodelog.setShardCityId(cityId);
				int count = erpFunBillCodelogMapper.updateByPrimaryKeySelective(billCodelog);
				if (count > 0) {
					flag--;
					newCodeId = billCodelog.getCodeId();
				}
			}
		}

		if (oldCodeId != -1 && oldCodeId == newCodeId) {
			//同一号段
			//刚好平
		} else  {
			//不是同一号段
			if (oldCodeId > 0) {
				erpFunBillCodeMapper.addCountByCodeId(cityId, compId, oldCodeId);
			}
			if (newCodeId > 0) {
				erpFunBillCodeMapper.subCountByCodeId(cityId,compId, newCodeId);
			}
		}
	}
}
