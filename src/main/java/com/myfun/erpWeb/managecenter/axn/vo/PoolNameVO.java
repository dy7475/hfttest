package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PoolNameVO implements Serializable{
	
	@ApiModelProperty(value = "号池key")
	private String numberPoolKey;

	@ApiModelProperty(value = "号池名称")
	private String numberPoolName;
	
	public String getNumberPoolKey() {
		return numberPoolKey;
	}

	public void setNumberPoolKey(String numberPoolKey) {
		this.numberPoolKey = numberPoolKey;
	}

	public String getNumberPoolName() {
		return numberPoolName;
	}

	public void setNumberPoolName(String numberPoolName) {
		this.numberPoolName = numberPoolName;
	}
	
}
