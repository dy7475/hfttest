package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetRegionListParam implements EncryParamIfc {

	@ApiModelProperty(value = "是否统计门店人数, 1是0否")
	private Integer countUser;
	@ApiModelProperty(value = "大区id")
	private Integer areaId;
	public Integer getCountUser() {
		return countUser;
	}
	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
}
