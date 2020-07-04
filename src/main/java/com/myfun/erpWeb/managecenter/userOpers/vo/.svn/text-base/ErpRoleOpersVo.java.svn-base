package com.myfun.erpWeb.managecenter.userOpers.vo;

import java.util.List;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.po.ErpFunOpers;

import io.swagger.annotations.ApiModelProperty;

public class ErpRoleOpersVo {

	@ApiModelProperty(value ="角色应该有的模板权限,全部的模板权限")
	private List<ErpFunOpersDto> modelOpersList;
	@ApiModelProperty(value ="所选员工的权限,给用户配权限，而且公司模板有的权限配置")
	private List<ErpFunOpersDto> checkedRoleOpersList;
	@ApiModelProperty(value = "登陆取用户拥有的所有权限,本人的权限列表")
	private List<ErpFunOpers> loginUserOpersList;
	@ApiModelProperty("1代表本次操作时新的权限配置，必须把本次要修改的权限全部提交上来")
	private String newSetOper;
	@ApiModelProperty("房基地权限模板id")
	private Integer permissionTemplateId;
	@ApiModelProperty("房基地权限模板名称")
	private String permissionTemplateName;

	public String getNewSetOper() {
		return newSetOper;
	}

	public void setNewSetOper(String newSetOper) {
		this.newSetOper = newSetOper;
	}

	public List<ErpFunOpersDto> getModelOpersList() {
		return modelOpersList;
	}
	public void setModelOpersList(List<ErpFunOpersDto> modelOpersList) {
		this.modelOpersList = modelOpersList;
	}
	public List<ErpFunOpersDto> getCheckedRoleOpersList() {
		return checkedRoleOpersList;
	}
	public void setCheckedRoleOpersList(List<ErpFunOpersDto> checkedRoleOpersList) {
		this.checkedRoleOpersList = checkedRoleOpersList;
	}
	public List<ErpFunOpers> getLoginUserOpersList() {
		return loginUserOpersList;
	}
	public void setLoginUserOpersList(List<ErpFunOpers> loginUserOpersList) {
		this.loginUserOpersList = loginUserOpersList;
	}

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
