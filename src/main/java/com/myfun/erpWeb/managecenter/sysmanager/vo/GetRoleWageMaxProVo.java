package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LI XIAO TONG
 * @since 2019年8月28日 下午8:54:18
 * Modified XXX Li Xiao Tong 2019年8月28日
 */
public class GetRoleWageMaxProVo {

	@ApiModelProperty(value = "角色ID")
	private String roleId;
	@ApiModelProperty(value = "薪资的计算方式 1.阶梯计算 2.通提计算")
	private String wageCountType;
	@ApiModelProperty(value = "提成比例")
	private Integer pro;
	public String getRoleId() {
	
		return roleId;
	}
	public void setRoleId(String roleId) {
	
		this.roleId = roleId;
	}
	public String getWageCountType() {
	
		return wageCountType;
	}
	public void setWageCountType(String wageCountType) {
	
		this.wageCountType = wageCountType;
	}
	public Integer getPro() {
	
		return pro;
	}
	public void setPro(Integer pro) {
	
		this.pro = pro;
	}
	
	
}

