package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetDeptGroupListParam implements EncryParamIfc {

	@ApiModelProperty(value = "门店Id")
	private Integer deptId;
	@ApiModelProperty(value = "是否统计门店人数, 1是0否")
	private Integer countUser;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getCountUser() {
		return countUser;
	}
	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}
}
