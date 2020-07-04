package com.myfun.erpWeb.build.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BuildPermissionListParam extends AbstractEncryParam {

	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "楼盘id")
	private Integer buildId;

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
	
}
