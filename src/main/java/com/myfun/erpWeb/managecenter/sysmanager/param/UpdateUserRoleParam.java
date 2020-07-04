package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateUserRoleParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "用户ID")
	private Integer userId;

	@ApiModelProperty(value = "邀请表zhujianID")
	private Integer inviteId;
	
	@ApiModelProperty(value = "角色ID")
	private String roleId;
	
	@ApiModelProperty(value = "职级ID，如果没有职级或者为空则不传")
	private Integer roleLevelId;

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}
}
