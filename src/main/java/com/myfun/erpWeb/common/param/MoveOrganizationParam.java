package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MoveOrganizationParam implements EncryParamIfc {

	@ApiModelProperty(hidden = true, value = "城市ID，后面跨库使用")
	private Integer cityId;
	@ApiModelProperty(hidden = true, value = "erp公司ID")
	private Integer compId;
	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	@ApiModelProperty(value = "老pid")
	private Integer oldPid;
	@ApiModelProperty(value = "新pid")
	private Integer newPid=0;
	@ApiModelProperty(hidden = true, value = "经纪人(申请者)ID")
	private Integer userId;
	@ApiModelProperty(hidden = true, value = "处理状态（0申请中/1覆盖/2拒绝/3已处理）")
	private Integer dealFlag;
	
	
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
	public Integer getOrganizationId() {
	
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}
	public Integer getOldPid() {
	
		return oldPid;
	}
	public void setOldPid(Integer oldPid) {
	
		this.oldPid = oldPid;
	}
	public Integer getNewPid() {
	
		return newPid;
	}
	public void setNewPid(Integer newPid) {
	
		this.newPid = newPid;
	}
	public Integer getUserId() {
	
		return userId;
	}
	public void setUserId(Integer userId) {
	
		this.userId = userId;
	}
	public Integer getDealFlag() {
	
		return dealFlag;
	}
	public void setDealFlag(Integer dealFlag) {
	
		this.dealFlag = dealFlag;
	}

	
}
