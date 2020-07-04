package com.myfun.erpWeb.build.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class CopyPermissionParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "楼盘id  多个用，分开")
	private String buildIds;
	
	@ApiModelProperty(value = "目标分组id  多个用，分开")
	private String targetOrganizationIds;
	
	@ApiModelProperty(value = "是否全部 1=是")
	private String isAll;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer userId;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;

	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getBuildIds() {
		return buildIds;
	}

	public void setBuildIds(String buildIds) {
		this.buildIds = buildIds;
	}

	public String getTargetOrganizationIds() {
		return targetOrganizationIds;
	}

	public void setTargetOrganizationIds(String targetOrganizationIds) {
		this.targetOrganizationIds = targetOrganizationIds;
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

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getIsAll() {
		return isAll;
	}

	public void setIsAll(String isAll) {
		this.isAll = isAll;
	}
	
}
