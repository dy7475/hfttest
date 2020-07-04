package com.myfun.erpWeb.managecenter.userOpers.param;


import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetTemplatePermissionInfoParam implements EncryParamIfc {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "权限模板id")
	private Integer permissionTemplateId;

	public Integer getPermissionTemplateId() {
		return permissionTemplateId;
	}

	public void setPermissionTemplateId(Integer permissionTemplateId) {
		this.permissionTemplateId = permissionTemplateId;
	}
}
