package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetHouseCustCountParam implements EncryParamIfc {

	@ApiModelProperty(value = "对应的用户userId")
	private Integer userId;
	@ApiModelProperty(value = "跨城后需要传")
	private Integer cityId;
	@ApiModelProperty(value = "跨城后需要前端传")
	private Integer compId;

	public Integer getUserId() {
		return userId;
	}

	public Integer getCityId() {
	
		return cityId;
	}

	public void setCityId(Integer cityId) {
	
		this.cityId = cityId;
	}

	public Integer getCompId() {
	
		return compId;
	}

	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
