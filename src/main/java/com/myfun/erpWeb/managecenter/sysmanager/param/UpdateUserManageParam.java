package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

/**
 * @author guohao
 * @date 2019-03-16 17:49
 */
public class UpdateUserManageParam implements EncryParamIfc {
	private Integer rangeType;
	private Integer userId;
	private String rangeIds;
	private String roleId;

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRangeIds() {
		return rangeIds;
	}

	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
