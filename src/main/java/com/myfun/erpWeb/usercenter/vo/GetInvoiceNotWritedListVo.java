package com.myfun.erpWeb.usercenter.vo;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminFunPaidDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetInvoiceNotWritedListVo {

	@ApiModelProperty(value = "用户充值消费记录列表")
	private List<InvoiceNotWritedVo> list;

	public List<InvoiceNotWritedVo> getList() {
		return list;
	}

	public void setList(List<InvoiceNotWritedVo> list) {
		this.list = list;
	}
}