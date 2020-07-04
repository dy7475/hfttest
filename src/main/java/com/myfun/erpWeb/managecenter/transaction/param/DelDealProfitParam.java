package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class DelDealProfitParam implements EncryParamIfc{

	@ApiModelProperty(value = "合同id")
	private Integer dealId;
	
	@ApiModelProperty(value = "业绩ID")
	private Integer profitId;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getProfitId() {
		return profitId;
	}

	public void setProfitId(Integer profitId) {
		this.profitId = profitId;
	}
	
}
