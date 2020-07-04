package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetGroupDetailInfoParam implements EncryParamIfc{

	@ApiModelProperty(value = "分组Id")
	private Integer grId;

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}
}
