package com.myfun.erpWeb.managecenter.axn.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BindHistoryListParam implements EncryParamIfc {

	@ApiModelProperty(value = "小号")
	private String bindX;

	public String getBindX() {
		return bindX;
	}

	public void setBindX(String bindX) {
		this.bindX = bindX;
	}
}
