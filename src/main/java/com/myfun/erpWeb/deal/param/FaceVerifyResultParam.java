package com.myfun.erpWeb.deal.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FaceVerifyResultParam implements EncryParamIfc {

	@NotNull
    @ApiModelProperty(value = "唯一字符串", required = true)
	private String orderNo;
	
	@NotNull
    @ApiModelProperty(value = "合同id", required = true)
	private Integer dealId;
    
    @NotNull
    @ApiModelProperty(value = "0=业主 1=客户", required = true)
    private Integer ownerType;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}
    
}
