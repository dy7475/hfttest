package com.myfun.erpWeb.usercenter.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddIssueInvoiceResultVo {

	@ApiModelProperty(value = "发票数量列表")
	private List<ApplyIssueInvoiceVo> list;

	public List<ApplyIssueInvoiceVo> getList() {
		return list;
	}

	public void setList(List<ApplyIssueInvoiceVo> list) {
		this.list = list;
	}
}