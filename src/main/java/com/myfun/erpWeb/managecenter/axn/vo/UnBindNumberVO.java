package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UnBindNumberVO implements Serializable{

	@ApiModelProperty(value = "小号")
	private String bindX;

	public String getBindX() {
		return bindX;
	}

	public void setBindX(String bindX) {
		this.bindX = bindX;
	}
}
