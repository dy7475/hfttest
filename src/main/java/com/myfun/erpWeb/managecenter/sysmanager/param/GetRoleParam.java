package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2019-03-08 18:22
 */
public class GetRoleParam implements EncryParamIfc {
	@ApiModelProperty("角色id")
	private String roleId;
	@ApiModelProperty("useId")
	private Integer userId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
