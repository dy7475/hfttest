package com.myfun.erpWeb.managecenter.vstore.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月4日 
 */
public class GetEmployeeDynamicsListParam extends AbstractEncryParam {

	@ApiModelProperty(hidden = true, value = "城市ID")
	private Integer cityId;
	@ApiModelProperty(hidden = true, value = "城市ID")
	private Integer compId;
	@ApiModelProperty(value = "")
	private Integer areaId;
	@ApiModelProperty(value = "")
	private Integer regId;
	@ApiModelProperty(value = "")
	private Integer deptId;
	@ApiModelProperty(value = "")
	private Integer grId;
	@ApiModelProperty(value = "")
	private Integer userId;
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	@ApiModelProperty(value = "新，组织机构id")
	private Integer organizationId;
	@ApiModelProperty(hidden = true)
	private Boolean newOrganization;
	
	public Integer getCityId() {
	
		return cityId;
	}
	public void setCityId(Integer cityId) {
	
		this.cityId = cityId;
	}
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
	public Integer getUserId() {
	
		return userId;
	}
	public void setUserId(Integer userId) {
	
		this.userId = userId;
	}
	public String getStartTime() {
	
		return startTime;
	}
	public void setStartTime(String startTime) {
	
		this.startTime = startTime;
	}
	public String getEndTime() {
	
		return endTime;
	}
	public void setEndTime(String endTime) {
	
		this.endTime = endTime;
	}
	public Integer getOrganizationId() {
	
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}
	public Boolean getNewOrganization() {
	
		return newOrganization;
	}
	public void setNewOrganization(Boolean newOrganization) {
	
		this.newOrganization = newOrganization;
	}
	
	
}

