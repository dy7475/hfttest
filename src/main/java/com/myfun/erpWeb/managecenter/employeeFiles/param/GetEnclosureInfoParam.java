package com.myfun.erpWeb.managecenter.employeeFiles.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetEnclosureInfoParam implements EncryParamIfc {

	@ApiModelProperty(value = "档案的主键Id")
	private Integer employeeDocId;

	public Integer getEmployeeDocId() {
		return employeeDocId;
	}

	public void setEmployeeDocId(Integer employeeDocId) {
		this.employeeDocId = employeeDocId;
	}
}
