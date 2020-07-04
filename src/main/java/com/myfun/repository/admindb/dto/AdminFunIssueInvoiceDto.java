package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunIssueInvoice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdminFunIssueInvoiceDto extends AdminFunIssueInvoice{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "支付类型")
	private String paidType;

	public String getPaidType() {
		return paidType;
	}

	public void setPaidType(String paidType) {
		this.paidType = paidType;
	}
}