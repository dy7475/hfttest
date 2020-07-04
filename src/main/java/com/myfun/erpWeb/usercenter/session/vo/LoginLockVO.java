package com.myfun.erpWeb.usercenter.session.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class LoginLockVO {

	@ApiModelProperty(value = "lockLoginEndTime")
	private Date lockLoginEndTime;

	public Date getLockLoginEndTime() {
		return lockLoginEndTime;
	}

	public void setLockLoginEndTime(Date lockLoginEndTime) {
		this.lockLoginEndTime = lockLoginEndTime;
	}
}
