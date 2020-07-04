package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunDealRecord;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface ErpFunDealRecordService extends BaseMapper<ErpFunDealRecord, ErpFunDealRecord>{
	
	public void writeDealRecord(GeneralParam param ,Integer dealId, String system, String updateClassic, Byte updateType,
								String trackContent, Integer type, Byte pfActual, boolean isDetailFlag, String payType);

}
