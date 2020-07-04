package com.myfun.erpWeb.deal.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FaceVerifyParam implements EncryParamIfc {
	
	@NotNull
    @ApiModelProperty(value = "0=业主 1=客户", required = true)
    private Integer ownerType;
	
	@ApiModelProperty(value = "合同id", required = true)
	private Integer dealId;

	public Integer getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	
}
