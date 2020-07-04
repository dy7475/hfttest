package com.myfun.erpWeb.openApi.attendance.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OutLogRecordOpenApiParam extends AbstractEncryParam {

	@ApiModelProperty(value = "大区id")
	private Integer areaId;
	
	@ApiModelProperty(value = "片区id")
	private Integer regId;
	
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	
	@ApiModelProperty(value = "分组id")
	private Integer grId;
	
	@ApiModelProperty(value = "员工id")
	private Integer userId;
	
	@ApiModelProperty(value = "考核月份")
	private String assessmentMonth;
	
	@ApiModelProperty(value = "开始时间", required = true)
	private String startTime;
	
	@ApiModelProperty(value = "结束时间", required = true)
	private String endTime;
	
	@ApiModelProperty(value = "公司编号", required = true)
	private String compNo;
	
	@ApiModelProperty(value = "城市id", required = true)
	private Integer cityId;

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

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
}