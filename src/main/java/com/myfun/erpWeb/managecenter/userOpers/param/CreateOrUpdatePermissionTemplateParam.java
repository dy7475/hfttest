package com.myfun.erpWeb.managecenter.userOpers.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreateOrUpdatePermissionTemplateParam implements EncryParamIfc {

	@ApiModelProperty(value = "权限模板id，修改权限模板名称的时候传，其他时候不传")
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
