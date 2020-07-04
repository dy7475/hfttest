package com.myfun.erpWeb.build.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BuildPermissionVO implements Serializable {
	
	@ApiModelProperty("主键id")
	private Integer bpId;
	
	@ApiModelProperty("楼盘id")
	private Integer buildId;
	
	@ApiModelProperty("楼盘名")
	private String buildName;
	
	@ApiModelProperty("推广名")
	private String promotionName;
	
	@ApiModelProperty("组织id")
	private Integer organizationId;
	
	@ApiModelProperty("选择的用途")
	private String houseUseage;
	
	@ApiModelProperty("楼盘的用途")
	private String buildingUseage;
	
	@ApiModelProperty("是否有登记权限")
	private Byte addPermission;
	
	@ApiModelProperty("是否有编辑权限")
	private Byte editPermission;
	
	@ApiModelProperty("是否有查看核心信息权限")
	private Byte viewPermission;
	
	@ApiModelProperty("是否与楼盘用途相同 1=是")
	private Byte isUseageSame;
	
	@ApiModelProperty("区域名")
	private String regName;

	public Integer getBpId() {
		return bpId;
	}

	public void setBpId(Integer bpId) {
		this.bpId = bpId;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
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
	
	public String getBuildingUseage() {
		return buildingUseage;
	}

	public void setBuildingUseage(String buildingUseage) {
		this.buildingUseage = buildingUseage;
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

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}
}
