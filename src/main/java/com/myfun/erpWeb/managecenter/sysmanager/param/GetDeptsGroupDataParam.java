package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetDeptsGroupDataParam implements EncryParamIfc {

	@ApiModelProperty("分组所在的门店Id")
	private Integer deptId;
	@ApiModelProperty("分组Id")
	private Integer grId;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
}
