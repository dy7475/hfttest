package com.myfun.erpWeb.managecenter.constract.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetDealTrackParam extends AbstractEncryParam {

	@ApiModelProperty(value = "合同id", required = true)
	@NotNull
	private Integer dealId;
	
	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
}