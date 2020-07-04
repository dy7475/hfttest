package com.myfun.erpWeb.managecenter.userOpers.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class UpdatePermissionTemplateParam implements EncryParamIfc {

	@ApiModelProperty("增加的权限")
	private String addOpers;
	@ApiModelProperty("删除的权限")
	private String delOpers;
	@ApiModelProperty("NEW_SET_OPER = 1 表示这次是第一次添加， 0：编辑以往有的角色权限配置")
	private Integer isNewSetOper;

	@NotNull
	@ApiModelProperty("模板id")
	private Integer permissionTemplateId;


	public String getAddOpers() {
		return addOpers;
	}


	public void setAddOpers(String addOpers) {
		this.addOpers = addOpers;
	}


	public String getDelOpers() {
		return delOpers;
	}


	public void setDelOpers(String delOpers) {
		this.delOpers = delOpers;
	}


	public Integer getIsNewSetOper() {
		return isNewSetOper;
	}


	public void setIsNewSetOper(Integer isNewSetOper) {
		this.isNewSetOper = isNewSetOper;
	}


	public Integer getPermissionTemplateId() {
		return permissionTemplateId;
	}


	public void setPermissionTemplateId(Integer permissionTemplateId) {
		this.permissionTemplateId = permissionTemplateId;
	}

	
}
