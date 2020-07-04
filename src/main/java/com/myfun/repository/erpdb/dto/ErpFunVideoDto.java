package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunVideo;

public class ErpFunVideoDto extends ErpFunVideo {
	private String userName;
	private String deptName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
