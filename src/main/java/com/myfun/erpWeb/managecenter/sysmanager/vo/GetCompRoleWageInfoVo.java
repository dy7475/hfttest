package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LI XIAO TONG
 * @since 2019年8月28日 下午2:21:49
 * Modified XXX Li Xiao Tong 2019年8月28日
 */
public class GetCompRoleWageInfoVo {

	@ApiModelProperty(value="基本薪资") 
	private BigDecimal baseWage;
	@ApiModelProperty(value="数据绩效") 
	private BigDecimal dataWage;
	@ApiModelProperty(value="业绩绩效") 
	private BigDecimal salesWage;
	@ApiModelProperty(value="角色ID") 
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public BigDecimal getBaseWage() {
	
		return baseWage;
	}
	public void setBaseWage(BigDecimal baseWage) {
	
		this.baseWage = baseWage;
	}
	public BigDecimal getDataWage() {
	
		return dataWage;
	}
	public void setDataWage(BigDecimal dataWage) {
	
		this.dataWage = dataWage;
	}
	public BigDecimal getSalesWage() {
	
		return salesWage;
	}
	public void setSalesWage(BigDecimal salesWage) {
	
		this.salesWage = salesWage;
	}
	
	
}

