package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunBillPrint;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ErpFunBillPrintService extends BaseMapper<ErpFunBillPrint, ErpFunBillPrint> {
	void deleteRelativeIdsByFinancIds(Integer cityId,Integer compId, List<String> delBillRelativeIds, Map<Integer,ErpProcessFinanc> financMap);
}
