package com.myfun.erpWeb.build.param;

import java.io.Serializable;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class DeletePermissionParam implements EncryParamIfc {
	
	@ApiModelProperty("主键id,多个用逗号隔开")
	private String bpIds;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer userId;

	@ApiModelProperty(hidden = true)
	private Integer compId;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getBpIds() {
		return bpIds;
	}

	public void setBpIds(String bpIds) {
		this.bpIds = bpIds;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
