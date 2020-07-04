package com.myfun.erpWeb.businesstools.Attendance.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AttendanceOnAndOffParam implements EncryParamIfc {
	@ApiModelProperty("门店ID")
	private String deptId;
	@ApiModelProperty("片区ID")
	private Integer regId;
	@ApiModelProperty("大区ID")
	private Integer areaId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty("类型")
	private String workType;
	@ApiModelProperty(hidden = true)
	private String[] deptIds;
	@ApiModelProperty(hidden = true)
	private String attendanceModel;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String[] getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String[] deptIds) {
		this.deptIds = deptIds;
	}

	public String getAttendanceModel() {
		return attendanceModel;
	}

	public void setAttendanceModel(String attendanceModel) {
		this.attendanceModel = attendanceModel;
	}
}
