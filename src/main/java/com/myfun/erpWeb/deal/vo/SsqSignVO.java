package com.myfun.erpWeb.deal.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SsqSignVO implements Serializable{

	@ApiModelProperty("签字的url")
	private String signUrl;

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}
	
}
