package com.myfun.erpWeb.build.param;

import java.io.Serializable;
import java.util.List;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class UpdatePermissionParam implements EncryParamIfc {

	List<UpdatePermission> permissionList;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer userId;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;

	public List<UpdatePermission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<UpdatePermission> permissionList) {
		this.permissionList = permissionList;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	
}
