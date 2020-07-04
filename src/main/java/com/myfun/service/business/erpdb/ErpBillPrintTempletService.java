package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.BillPrintTempletParam;
import com.myfun.repository.erpdb.po.ErpBillPrintTemplet;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpBillPrintTempletService extends BaseMapper<ErpBillPrintTemplet, ErpBillPrintTemplet> {

	void createAndUpdateBillModel(BillPrintTempletParam param);
}
