package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class DeleteRegionDataParam implements EncryParamIfc {
	@ApiModelProperty("删除的片区Id")
	private Integer regId;

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}
}
