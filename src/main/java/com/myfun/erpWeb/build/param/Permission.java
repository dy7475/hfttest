package com.myfun.erpWeb.build.param;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Permission implements Serializable{
	
	@ApiModelProperty("楼盘id")
	private Integer buildId;
	
	@ApiModelProperty("组织id")
	private Integer organizationId;
	
	@ApiModelProperty("选择的用途,多个用竖线隔开")
	private String houseUseage;
	
	@ApiModelProperty("是否有登记权限")
	private Byte addPermission;
	
	@ApiModelProperty("是否有编辑权限")
	private Byte editPermission;
	
	@ApiModelProperty("是否有查看核心信息权限")
	private Byte viewPermission;
	
	@ApiModelProperty("是否与楼盘用途相同 1=是")
	private Byte isUseageSame;

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}

	public Byte getAddPermission() {
		return addPermission;
	}

	public void setAddPermission(Byte addPermission) {
		this.addPermission = addPermission;
	}

	public Byte getEditPermission() {
		return editPermission;
	}

	public void setEditPermission(Byte editPermission) {
		this.editPermission = editPermission;
	}

	public Byte getViewPermission() {
		return viewPermission;
	}

	public void setViewPermission(Byte viewPermission) {
		this.viewPermission = viewPermission;
	}

	public Byte getIsUseageSame() {
		return isUseageSame;
	}

	public void setIsUseageSame(Byte isUseageSame) {
		this.isUseageSame = isUseageSame;
	}
	
}
