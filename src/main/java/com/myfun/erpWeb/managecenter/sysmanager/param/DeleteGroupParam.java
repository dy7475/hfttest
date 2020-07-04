package com.myfun.erpWeb.managecenter.sysmanager.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.AbstractEncryParam;

public class DeleteGroupParam extends AbstractEncryParam {
	
	private Integer grId;
	private Integer deptId;
	private Integer selfUserId;
	private Integer compId;
	private Integer cityId;
	public Integer getGrId() {
		return grId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
}
