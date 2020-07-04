package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class DeleteSubOrganizationParam implements EncryParamIfc {

	@ApiModelProperty(value = "被删除的部门id")
	private Integer organizationId;
	@ApiModelProperty(value = "城市ID，后面跨库使用")
	private Integer cityId;
	@ApiModelProperty(value = "城市ID，后面跨库使用")
	private Integer compId;
	@ApiModelProperty(hidden = true, value = "经纪人(操作者)ID")
	private Integer userId;
	
	
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public Integer getOrganizationId() {
	
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
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
	
	

}
