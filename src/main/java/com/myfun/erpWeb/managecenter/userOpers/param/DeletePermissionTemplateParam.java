package com.myfun.erpWeb.managecenter.userOpers.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DeletePermissionTemplateParam implements EncryParamIfc {

	@ApiModelProperty(value = "需要删除的权限模板的id")
	@NotNull
	private Integer permissionTemplateId;

	public Integer getPermissionTemplateId() {
		return permissionTemplateId;
	}

	public void setPermissionTemplateId(Integer permissionTemplateId) {
		this.permissionTemplateId = permissionTemplateId;
	}
}