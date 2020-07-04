package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetDifinitionInfoParam implements EncryParamIfc {

	@ApiModelProperty(value = "组织机构的id")
	private Integer organizationId;
	@ApiModelProperty(hidden = true, value = "城市ID，后面跨库使用")
	private Integer cityId;
	@ApiModelProperty(hidden = true, value = "erp公司ID")
	private Integer compId;
	
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
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	
}
