package com.myfun.erpWeb.build.param;

import java.util.List;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreatePermissionParam implements EncryParamIfc {

	@ApiModelProperty("列表")
	private List<Permission> permissionList;
	
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;
	
	@ApiModelProperty(hidden = true)
	private Integer userId;

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
