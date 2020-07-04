package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppDealProfitListParam implements EncryParamIfc {

	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	
	@ApiModelProperty(value = "业绩类型 0=个人业绩，1=公司业绩")
	private Byte profitType;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Byte getProfitType() {
		return profitType;
	}

	public void setProfitType(Byte profitType) {
		this.profitType = profitType;
	}
	
}
