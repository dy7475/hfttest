package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetAreaListParam implements EncryParamIfc{
	
	@ApiModelProperty(value = "是否统计门店人数, 1是0否")
	private Integer countUser;

	public Integer getCountUser() {
		return countUser;
	}

	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}
}
