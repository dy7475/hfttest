package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunLease;

public class ErpFunLeaseParam extends ErpFunLease{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer manageUserId;

	public Integer getManageUserId() {
		return manageUserId;
	}
	public void setManageUserId(Integer manageUserId) {
		this.manageUserId = manageUserId;
	}
}
