package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

public class GetMgrInstallListParam extends AbstractEncryParam {

	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;

	@ApiModelProperty(value = "门店ID")
	private Integer deptId;

	@ApiModelProperty(value = "公司ID")
	private Integer compId;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}
}