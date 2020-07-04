package com.myfun.erpWeb.app.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class AppAchieveMonthStatisticsRankDetailParam extends AbstractEncryParam {

	@ApiModelProperty(value = "2=按大区3=按片区4=按门店5=按分组6按员工", required = true)
	private Integer lookType;
	@ApiModelProperty(value = "lookType对应lookTypeId,如2=lookType为按大区，则lookTypeId就为areaId", required = true)
	private Integer lookTypeId;
	@ApiModelProperty(value = "lookType为5是传对应的deptId,其他情况不传")
	private Integer deptId;
//	@ApiModelProperty(value = "2=房增3=客增4=带看5=钥匙6=房勘", required = true)
//	private Integer assessmentType;
	@ApiModelProperty(value = "月统计时间。如:2018-08-01", required = true)
	private String assessmentMonth;
	@ApiModelProperty(value = "1=出售2=出租3=求购4=求租", required = true)
	private Integer caseType;
	@ApiModelProperty(value = "开始时间。如:2018-08-01", required = false)
	private String startTime;
	@ApiModelProperty(value = "结束时间。如:2018-08-31", required = false)
	private String endTime;

	@ApiModelProperty(value = "层级主键ID   (员工:-2)")
	private Integer defId;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	@ApiModelProperty(value = "userId")
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getLookType() {
		return lookType;
	}
	public void setLookType(Integer lookType) {
		this.lookType = lookType;
	}
	public Integer getLookTypeId() {
		return lookTypeId;
	}
	public void setLookTypeId(Integer lookTypeId) {
		this.lookTypeId = lookTypeId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getAssessmentMonth() {
		return assessmentMonth;
	}
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
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
}
