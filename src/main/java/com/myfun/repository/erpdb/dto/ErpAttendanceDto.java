package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpAttendance;

public class ErpAttendanceDto extends ErpAttendance{
	private String userName;
	private String updateUserName;
	private Integer offWork;
	private Integer onWork;

	public Integer getOffWork() {
		return offWork;
	}

	public void setOffWork(Integer offWork) {
		this.offWork = offWork;
	}

	public Integer getOnWork() {
		return onWork;
	}

	public void setOnWork(Integer onWork) {
		this.onWork = onWork;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
}
