package com.myfun.erpWeb.app.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class AppAchieveStatisticsCountTotalParam implements EncryParamIfc{

	@ApiModelProperty(value = "2=按大区3=按片区4=按门店5=按分组6按员工", required = true)
	private Integer lookType;
	@ApiModelProperty(value = "lookType对应lookTypeId,如2=lookType为按大区，则lookTypeId就为areaId", required = true)
	private Integer lookTypeId;
	@ApiModelProperty(value = "lookType为5是传对应的deptId")
	private Integer deptId;
	@ApiModelProperty(value = "月统计时间。如:2018-08-01", required = true)
	private String assessmentMonth;
	@ApiModelProperty(value = "开始时间。如:2018-08-01", required = false)
	private String startTime;
	@ApiModelProperty(value = "结束时间。如:2018-08-31", required = false)
	private String endTime;

	@ApiModelProperty(value = "层级主键ID   (员工:-2)")
	private Integer defId;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	@ApiModelProperty(value = "经纪人id")
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
