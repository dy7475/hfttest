package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

/**
 * @author guohao
 * @date 2019-03-16 11:04
 */
public class UpdateRoleManageParam implements EncryParamIfc {
	private String roleId;
	private Integer manageLevel;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Integer getManageLevel() {
		return manageLevel;
	}

	public void setManageLevel(Integer manageLevel) {
		this.manageLevel = manageLevel;
	}
}
