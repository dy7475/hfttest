package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AppFunWorkCountTargetParam implements EncryParamIfc {

	@ApiModelProperty(value = "主键id")
	private Integer id;
	@ApiModelProperty(value = "大区Id")
	private Integer areaId;
	@ApiModelProperty(value = "片区Id")
	private Integer regId;
	@ApiModelProperty(value = "门店Id")
	private Integer deptId;
	@ApiModelProperty(value = "分组Id")
	private Integer grId;
	@ApiModelProperty(value = "userId")
	private Integer userId;
	@ApiModelProperty(value = "角色Id")
	private String userPosition;
	@ApiModelProperty(value = "日目标")
	private AppFunWorkCountTargetSubParam dayTargetList;
	@ApiModelProperty(value = "周目标")
	private AppFunWorkCountTargetSubParam weekTargetList;
	@ApiModelProperty(value = "月目标")
	private AppFunWorkCountTargetSubParam monthTargetList;
	@ApiModelProperty(hidden = true)
	private boolean separationConfig;
	@ApiModelProperty(hidden = true)
	private boolean isNewOrganizationType;
	@ApiModelProperty(value = "加盟id，直营-1，总部0，加盟商id>0",hidden = true)
	private Integer partnerId;
	@ApiModelProperty(hidden = true)
	private List<Integer> partnerIds;

	@ApiModelProperty(value = "无限组织模式 部门Id")
	private Integer organizationId;
	@ApiModelProperty(value = "无限组织模式path",hidden = true)
	private String organizationPath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public AppFunWorkCountTargetSubParam getDayTargetList() {
		return dayTargetList;
	}

	public void setDayTargetList(AppFunWorkCountTargetSubParam dayTargetList) {
		this.dayTargetList = dayTargetList;
	}

	public AppFunWorkCountTargetSubParam getWeekTargetList() {
		return weekTargetList;
	}

	public void setWeekTargetList(AppFunWorkCountTargetSubParam weekTargetList) {
		this.weekTargetList = weekTargetList;
	}

	public AppFunWorkCountTargetSubParam getMonthTargetList() {
		return monthTargetList;
	}

	public void setMonthTargetList(AppFunWorkCountTargetSubParam monthTargetList) {
		this.monthTargetList = monthTargetList;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public List<Integer> getPartnerIds() {
		return partnerIds;
	}

	public void setPartnerIds(List<Integer> partnerIds) {
		this.partnerIds = partnerIds;
	}

	public boolean isSeparationConfig() {
		return separationConfig;
	}

	public void setSeparationConfig(boolean separationConfig) {
		this.separationConfig = separationConfig;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public boolean isNewOrganizationType() {
		return isNewOrganizationType;
	}

	public void setNewOrganizationType(boolean newOrganizationType) {
		isNewOrganizationType = newOrganizationType;
	}

	public String getOrganizationPath() {
		return organizationPath;
	}

	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}
}
