package com.myfun.erpWeb.managecenter.userOpers.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PermissionTemplateVO {

	@ApiModelProperty(value = "权限模板id")
	private Integer permissionTemplateId;
	
	@ApiModelProperty(value = "权限模板名")
	private String permissionTemplateName;

	public Integer getPermissionTemplateId() {
		return permissionTemplateId;
	}

	public void setPermissionTemplateId(Integer permissionTemplateId) {
		this.permissionTemplateId = permissionTemplateId;
	}

	public String getPermissionTemplateName() {
		return permissionTemplateName;
	}

	public void setPermissionTemplateName(String permissionTemplateName) {
		this.permissionTemplateName = permissionTemplateName;
	}
}