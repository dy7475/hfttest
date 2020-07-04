package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpYouBorkerPurchase;

public class ErpYouBorkerPurchaseDto extends ErpYouBorkerPurchase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String userMobile;
	private String deptName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
