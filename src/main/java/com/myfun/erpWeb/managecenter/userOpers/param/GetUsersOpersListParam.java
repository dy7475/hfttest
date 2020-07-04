package com.myfun.erpWeb.managecenter.userOpers.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetUsersOpersListParam implements EncryParamIfc {

	@ApiModelProperty(value = "用户userId")
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
