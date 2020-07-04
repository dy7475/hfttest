package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunAttendanceGroup;
import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.DaoBaseParam;

import java.math.BigDecimal;
import java.util.Date;

public class ErpFunAttendanceGroupParam extends ErpFunAttendanceGroup implements EncryParamIfc {


	// 判断是否修改过人员信息-主要是这里更新量比较大，如果不编辑人员的话 不重复修改人员关系
	private Integer isUpdateUser;
	private String groupBizList;
	private String attendanceFestivalList;
	private String attendanceScheduleList;
	private String needDelUserIds;

	public String getNeedDelUserIds() {
		return needDelUserIds;
	}

	public void setNeedDelUserIds(String needDelUserIds) {
		this.needDelUserIds = needDelUserIds;
	}

	public Integer getIsUpdateUser() {
		return isUpdateUser;
	}

	public void setIsUpdateUser(Integer isUpdateUser) {
		this.isUpdateUser = isUpdateUser;
	}

	public String getGroupBizList() {
		return groupBizList;
	}

	public void setGroupBizList(String groupBizList) {
		this.groupBizList = groupBizList;
	}

	public String getAttendanceFestivalList() {
		return attendanceFestivalList;
	}

	public void setAttendanceFestivalList(String attendanceFestivalList) {
		this.attendanceFestivalList = attendanceFestivalList;
	}

	public String getAttendanceScheduleList() {
		return attendanceScheduleList;
	}

	public void setAttendanceScheduleList(String attendanceScheduleList) {
		this.attendanceScheduleList = attendanceScheduleList;
	}
}
