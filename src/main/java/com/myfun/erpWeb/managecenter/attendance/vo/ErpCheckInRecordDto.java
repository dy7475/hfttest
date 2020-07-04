package com.myfun.erpWeb.managecenter.attendance.vo;

import com.myfun.repository.erpdb.po.ErpCheckInRecord;

public class ErpCheckInRecordDto extends ErpCheckInRecord {
	private String userName;
	private String checkTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
}
