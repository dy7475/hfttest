package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunDealRecord;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunDealRecordDto extends ErpFunDealRecord{
	private static final long serialVersionUID = 1L;
	
	private String dealId;
	private String deptName;
	private Integer organizationId;
	private String organizationName;
	private String compName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDealId() {
		return dealId;
	}
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
}
