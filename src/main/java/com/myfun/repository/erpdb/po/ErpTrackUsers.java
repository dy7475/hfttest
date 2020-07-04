package com.myfun.repository.erpdb.po;

import java.io.Serializable;

public class ErpTrackUsers extends ErpTrackUsersKey implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String deptName;
	/**
	 * @mbggenerated
	 */
	private String userName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
}