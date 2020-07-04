package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class UpdateUserStateParam implements EncryParamIfc {

	@ApiModelProperty(value = "目标用户的userId")
	private Integer userId;
	@ApiModelProperty(value = "帐号状态，1=正常使用2=暂停使用3=冻结")
	private Byte userStatus;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Byte getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Byte userStatus) {
		this.userStatus = userStatus;
	}
}
