package com.myfun.erpWeb.managecenter.transaction.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class changeWarrantParam extends InsertWarrantProcessParam {
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
}
