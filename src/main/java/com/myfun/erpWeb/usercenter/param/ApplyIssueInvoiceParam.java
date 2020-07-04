package com.myfun.erpWeb.usercenter.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApplyIssueInvoiceParam implements EncryParamIfc {

	@ApiModelProperty(value = "发票编号")
	@NotNull
	private Integer invoiceId;

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
}