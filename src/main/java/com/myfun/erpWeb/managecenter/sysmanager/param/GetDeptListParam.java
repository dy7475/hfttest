package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class GetDeptListParam implements EncryParamIfc{
	
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	@ApiModelProperty(value = "片区id")
	private Integer regId;
	@ApiModelProperty(value = "是否统计门店人数, 1是0否")
	private Integer countUser;
	@ApiModelProperty(value = "是否是总部1 是 0否")
	private Byte isHeadquarters;
	
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getCountUser() {
		return countUser;
	}
	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}
	
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Byte getIsHeadQuarters() {
		return isHeadquarters;
	}
	
	public void setIsHeadquarters(Byte isHeadquarters) {
		this.isHeadquarters = isHeadquarters;
	}
}
