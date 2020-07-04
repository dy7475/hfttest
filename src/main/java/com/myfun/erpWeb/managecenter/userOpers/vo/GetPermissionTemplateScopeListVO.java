package com.myfun.erpWeb.managecenter.userOpers.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetPermissionTemplateScopeListVO {

	@ApiModelProperty(value = "权限模板应用范围列表")
	private List<GetPermissionTemplateScopeVO> scopelist;

	public List<GetPermissionTemplateScopeVO> getScopelist() {
		return scopelist;
	}

	public void setScopelist(List<GetPermissionTemplateScopeVO> scopelist) {
		this.scopelist = scopelist;
	}
}
