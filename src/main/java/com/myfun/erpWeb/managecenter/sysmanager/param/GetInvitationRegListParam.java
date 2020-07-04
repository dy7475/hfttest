package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class GetInvitationRegListParam extends AbstractEncryParam{

	@ApiModelProperty(hidden=true)
	private Integer compId;
	@ApiModelProperty(hidden=true)
	private Integer areaId;
	@ApiModelProperty(hidden=true)
	private Integer rgId;
	@ApiModelProperty(hidden=true)
	private Integer deptId;
	@ApiModelProperty(hidden=true)
	private Integer groupId;
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getRgId() {
		return rgId;
	}
	public void setRgId(Integer rgId) {
		this.rgId = rgId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	
}
