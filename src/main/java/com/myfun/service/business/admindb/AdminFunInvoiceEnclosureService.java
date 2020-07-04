package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosure;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunInvoiceEnclosureService extends BaseMapper<AdminFunInvoiceEnclosure, Integer>{
	public void conectInvoiceId(Integer invoiceId, String esList,AddOrUpdateIssueInvoiceParam param);
}
