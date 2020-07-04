package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunBillCodelog;
import com.myfun.repository.erpdb.po.ErpFunBillPrint;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ErpFunBillCodelogService extends BaseMapper<ErpFunBillCodelog, ErpFunBillCodelog> {
	void updateBillCodeLogStatus(Integer cityId, Integer compId, String billCodeNo, String type);
	Integer judgeBillCodeNoRepeatByDeal(Integer cityId, Integer compId, Integer billCodeId, String billNo ,Byte billType,Integer dealId);
	Integer judgeBillCodeNoRepeat(Integer cityId, Integer compId, Integer billCodeId, String billNo ,Byte billType);

	/**
	 * 推断重置票据编号可用
	 *
	 * @param codeNo
	 * @param compId
	 * @param cityId
	 * @return
	 */
	void deduceCodeNoEmptyToRepeatUse(String oldCodeNo, String newCodeNo, Integer compId, Integer cityId);
}
