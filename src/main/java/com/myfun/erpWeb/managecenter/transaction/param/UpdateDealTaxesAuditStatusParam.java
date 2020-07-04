package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateDealTaxesAuditStatusParam implements EncryParamIfc {

	@ApiModelProperty(value = "合同id")
	private Integer dealId;
	
	@ApiModelProperty(value = "税费审核0未审核1已审核")
	private Integer taxesAuditStatus;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getTaxesAuditStatus() {
		return taxesAuditStatus;
	}

	public void setTaxesAuditStatus(Integer taxesAuditStatus) {
		this.taxesAuditStatus = taxesAuditStatus;
	}
	
}
