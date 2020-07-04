package com.myfun.erpWeb.build.param;

import java.io.Serializable;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReceiverListParam implements EncryParamIfc {

	@ApiModelProperty("楼盘id")
	private Integer buildId;
	
	@ApiModelProperty("用途")
	private String houseUseage;

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}
	
}
