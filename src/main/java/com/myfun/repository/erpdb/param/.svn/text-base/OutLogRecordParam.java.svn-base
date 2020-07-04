package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModelProperty;

public class OutLogRecordParam extends AbstractEncryParam implements DaoBaseParam{

	private Integer areaId;
	private Integer regId;
	private Integer deptId;
	private Integer grId;
	private Integer userId;
	private String assessmentMonth; // 考核月
	private String startTime; // 开始时间
	private String endTime; // 结束时间
	@ApiModelProperty("组织ID")
	private Integer organizationId;
	@ApiModelProperty(value = "是否新版组织架构", hidden = true)
	private boolean newOrg = false;

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
	public String getAssessmentMonth() {
		return assessmentMonth;
	}
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
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

	public boolean isNewOrg() {
		return newOrg;
	}

	public void setNewOrg(boolean newOrg) {
		this.newOrg = newOrg;
	}
}
