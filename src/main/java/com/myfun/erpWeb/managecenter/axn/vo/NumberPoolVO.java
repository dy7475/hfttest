package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NumberPoolVO implements Serializable{
	
	@ApiModelProperty(value = "号池名称")
	private String numberPoolName;
	
	@ApiModelProperty(value = "号池key")
	private String numberPoolKey;
	
	@ApiModelProperty(value = "组织id")
	private Integer orgId;
	
	@ApiModelProperty(value = "号码数量")
	private Integer phoneNum;
	
	@ApiModelProperty(value = "已绑定")
	private Integer isBind;
	
	@ApiModelProperty(value = "未绑定")
	private Integer unBind;
	
	@ApiModelProperty(value = "绑定率")
	private Integer unRate;

	public String getNumberPoolName() {
		return numberPoolName;
	}

	public void setNumberPoolName(String numberPoolName) {
		this.numberPoolName = numberPoolName;
	}

	public String getNumberPoolKey() {
		return numberPoolKey;
	}

	public void setNumberPoolKey(String numberPoolKey) {
		this.numberPoolKey = numberPoolKey;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getIsBind() {
		return isBind;
	}

	public void setIsBind(Integer isBind) {
		this.isBind = isBind;
	}

	public Integer getUnBind() {
		return unBind;
	}

	public void setUnBind(Integer unBind) {
		this.unBind = unBind;
	}

	public Integer getUnRate() {
		return unRate;
	}

	public void setUnRate(Integer unRate) {
		this.unRate = unRate;
	}
	
}
