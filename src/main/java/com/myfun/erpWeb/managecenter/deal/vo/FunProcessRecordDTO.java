package com.myfun.erpWeb.managecenter.deal.vo;

import com.myfun.repository.erpdb.po.ErpFunProcessRecord;

/**
 * @author guohao
 * @date 2019-03-19 16:59
 */
public class FunProcessRecordDTO extends ErpFunProcessRecord {
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
