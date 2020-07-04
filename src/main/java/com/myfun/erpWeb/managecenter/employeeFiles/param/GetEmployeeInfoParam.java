package com.myfun.erpWeb.managecenter.employeeFiles.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetEmployeeInfoParam implements EncryParamIfc {

	@ApiModelProperty(value = "userId")
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
