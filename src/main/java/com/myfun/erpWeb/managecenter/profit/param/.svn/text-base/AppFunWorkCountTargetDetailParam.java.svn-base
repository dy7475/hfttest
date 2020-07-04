package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class AppFunWorkCountTargetDetailParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "范围类型；1=按公司 2=按大区 3=按片区 4=按门店 5=按分组 6=按员工", required = true)
	private Byte rangeType;
	
	@ApiModelProperty(value = "范围id,rangeType对应rangeId,如2=rangeType为按大区，则rangeId就为areaId", required = true)
	private Integer rangeId;

	@ApiModelProperty(value = "角色Id", required = true)
	private String userPosition;

	//加盟商相关
	@ApiModelProperty(hidden = true)
	private boolean separationConfig;

	@ApiModelProperty(hidden = true)
	private Integer partnerId;
	@ApiModelProperty(value = "无限组织模式 部门Id")
	private Integer organizationId;

	public Byte getRangeType() {
		return rangeType;
	}

	public void setRangeType(Byte rangeType) {
		this.rangeType = rangeType;
	}

	public Integer getRangeId() {
		return rangeId;
	}

	public void setRangeId(Integer rangeId) {
		this.rangeId = rangeId;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public boolean isSeparationConfig() {
		return separationConfig;
	}

	public void setSeparationConfig(boolean separationConfig) {
		this.separationConfig = separationConfig;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
}