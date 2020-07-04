package com.myfun.erpWeb.deal.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NotifySignResultParam {

	@ApiModelProperty(value = "城市id", required = true)
	private Integer cityId;
	
	@ApiModelProperty(value = "合同id", required = true)
	private Integer dealId;
	
	@ApiModelProperty(value = "token", required = true)
	private String token;
	
    @ApiModelProperty(value = "0=业主 1=客户", required = true)
    private Integer ownerType;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(Integer ownerType) {
		this.ownerType = ownerType;
	}
    
}
