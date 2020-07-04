package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetInvoiceEnclosureListParam  extends AbstractEncryParam {
	
	@ApiModelProperty(value = "发票ID")
	private Integer invoiceId;
	
	@ApiModelProperty(value = "附件类型 1:合同附件 2:委托证明 3:纳税证明 4：营业执照")
	private Byte esType;

	
	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Byte getEsType() {
		return esType;
	}

	public void setEsType(Byte esType) {
		this.esType = esType;
	}
}