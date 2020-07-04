package com.myfun.erpWeb.usercenter.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetInvoiceHasWritedListParam extends AbstractEncryParam {

	@ApiModelProperty(value = "1=需要开发票的消费记录 2=已经开了发票的历史记录表")
	private Integer invoiceType;

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}
}