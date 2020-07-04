package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.erpWeb.usercenter.param.DelFunInvoiceEnclosureParam;
import com.myfun.erpWeb.usercenter.vo.ApplyIssueInvoiceVo;
import com.myfun.repository.admindb.dto.AdminFunIssueInvoiceDto;
import com.myfun.repository.admindb.po.AdminFunIssueInvoice;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunIssueInvoiceService extends BaseMapper<AdminFunIssueInvoice, Integer>{
	List<AdminFunIssueInvoiceDto> getInvoiceDetail(Integer invoiseId);
	
	List<ApplyIssueInvoiceVo> checkInvoiceCount();

	List<ApplyIssueInvoiceVo> addIssueInvoice(AddOrUpdateIssueInvoiceParam param);

	void delIssueInvoice(DelFunInvoiceEnclosureParam param);

	List<ApplyIssueInvoiceVo> editIssueInvoice(AddOrUpdateIssueInvoiceParam param);

	ApplyIssueInvoiceVo applyIssueInvoice(AddOrUpdateIssueInvoiceParam param);
}
