package com.myfun.erpWeb.build.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OrganizePermissionListParam extends AbstractEncryParam {

	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;
	
	@ApiModelProperty(value = "行政区id")
	private Integer buildRegion;
	
	@ApiModelProperty(value = "用途")
	private Integer houseUseage;
	
	@ApiModelProperty(value = "1=有权限 0=无权限", required = true)
	private Integer hasPermission;

	
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public Integer getBuildRegion() {
		return buildRegion;
	}

	public void setBuildRegion(Integer buildRegion) {
		this.buildRegion = buildRegion;
	}

	public Integer getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(Integer houseUseage) {
		this.houseUseage = houseUseage;
	}

	public Integer getHasPermission() {
		return hasPermission;
	}

	public void setHasPermission(Integer hasPermission) {
		this.hasPermission = hasPermission;
	}
	
}
