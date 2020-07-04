package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunDeptFeeList;

import java.io.Serializable;

public class ErpFunDeptFeeListDto extends ErpFunDeptFeeList implements Serializable {
	private String deptIds;
	private String countTimeStr;
	private String deptFeeList;
	private String grIds;

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getCountTimeStr() {
		return countTimeStr;
	}

	public void setCountTimeStr(String countTimeStr) {
		this.countTimeStr = countTimeStr;
	}

	public String getDeptFeeList() {
		return deptFeeList;
	}

	public void setDeptFeeList(String deptFeeList) {
		this.deptFeeList = deptFeeList;
	}

	public String getGrIds() {
		return grIds;
	}

	public void setGrIds(String grIds) {
		this.grIds = grIds;
	}
}
