package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LI XIAO TONG
 * @since 2019年8月28日 上午11:44:30
 * Modified XXX Li Xiao Tong 2019年8月28日
 */
public class GetCompRoleInfoVo {

	@ApiModelProperty(value = "角色ID")
	private String roleId;
	@ApiModelProperty(value = "权限ID")
	private String operId;
	@ApiModelProperty(value = "操作名称")
	private String operName;
	public String getRoleId() {
	
		return roleId;
	}
	public void setRoleId(String roleId) {
	
		this.roleId = roleId;
	}
	public String getOperId() {
	
		return operId;
	}
	public void setOperId(String operId) {
	
		this.operId = operId;
	}
	public String getOperName() {
	
		return operName;
	}
	public void setOperName(String operName) {
	
		this.operName = operName;
	}
	
	
}

