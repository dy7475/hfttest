package com.myfun.erpWeb.usercenter.session.vo;

import io.swagger.annotations.ApiModelProperty;

public class AppLoginVo {

	@ApiModelProperty(value = "clientKey")
	private String clientKey;

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
}
