package com.myfun.repository.erpdb.dto;

import java.util.List;
import java.util.Map;

public class AttendanceCountDto {

	private Integer areaId;
	private Integer regId;
	private Integer deptId;
	private Integer grId;
	private Integer userId;
	private String attDate;
	private List<Map<String,Object>> recordList;
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
	public String getAttDate() {
		return attDate;
	}
	public void setAttDate(String attDate) {
		this.attDate = attDate;
	}
	public List<Map<String, Object>> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<Map<String, Object>> recordList) {
		this.recordList = recordList;
	}
	
	


}
