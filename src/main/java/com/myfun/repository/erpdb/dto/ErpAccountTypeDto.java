package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpAccountType;

public class ErpAccountTypeDto extends ErpAccountType{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

}
