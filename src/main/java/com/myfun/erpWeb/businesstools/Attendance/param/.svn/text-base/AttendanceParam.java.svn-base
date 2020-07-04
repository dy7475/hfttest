package com.myfun.erpWeb.businesstools.Attendance.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel
public class AttendanceParam extends AbstractEncryParam {
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "部门ID")
	private Integer deptId;
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "状态 1= 正常上班 2=上班值班 3 =上班（晚） 4=下班（正常） 5= 下班（值） 6 =下班（晚）")
	private Byte workType;
	@ApiModelProperty(value = "状态 1= 迟到 2=早退 3 =旷工 4=病假 5= 事假 6 =休假")
	private Byte workStatus;
	@ApiModelProperty(value = "查询初始时间")
	private String attDate1;
	@ApiModelProperty(value = "查询结束时间")
	private String attDate2;

	private Byte workOnType;
	private Byte workOffType;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
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

	public Byte getWorkType() {
		return workType;
	}

	public void setWorkType(Byte workType) {
		this.workType = workType;
	}

	public Byte getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(Byte workStatus) {
		this.workStatus = workStatus;
	}

	public String getAttDate1() {
		return attDate1;
	}

	public void setAttDate1(String attDate1) {
		this.attDate1 = attDate1;
	}

	public String getAttDate2() {
		return attDate2;
	}

	public void setAttDate2(String attDate2) {
		this.attDate2 = attDate2;
	}

	public Byte getWorkOnType() {
		return workOnType;
	}

	public void setWorkOnType(Byte workOnType) {
		this.workOnType = workOnType;
	}

	public Byte getWorkOffType() {
		return workOffType;
	}

	public void setWorkOffType(Byte workOffType) {
		this.workOffType = workOffType;
	}
}
