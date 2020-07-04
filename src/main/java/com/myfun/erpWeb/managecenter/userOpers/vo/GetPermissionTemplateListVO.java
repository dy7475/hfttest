package com.myfun.erpWeb.managecenter.userOpers.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetPermissionTemplateListVO {

	@ApiModelProperty(value = "权限模板列表")
	List<PermissionTemplateVO> list;

	public List<PermissionTemplateVO> getList() {
		return list;
	}

	public void setList(List<PermissionTemplateVO> list) {
		this.list = list;
	}
}