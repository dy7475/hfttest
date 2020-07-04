package com.myfun.erpWeb.managecenter.userOpers.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.po.ErpFunOpers;

import io.swagger.annotations.ApiModelProperty;

public class UsersOpersListVo {

	@ApiModelProperty(value = "高于模板的权限")
	private List<ErpFunOpersDto> higherThanModelOpersList;
	@ApiModelProperty(value = "角色应该有的模板权限")
	private List<ErpFunOpersDto> modelOpersList;
	@ApiModelProperty(value = "所选员工的权限")
	private List<ErpFunOpersDto> checkedUserOpersList;
	@ApiModelProperty(value = "登陆取用户拥有的所有权限")
	private List<ErpFunOpers> loginUserOpersList;
	@ApiModelProperty(value = "所选角色模板权限(包含基础权限和高级权限)")
	private List<ErpFunOpersDto> defaultOpersList;
	public List<ErpFunOpersDto> getHigherThanModelOpersList() {
		return higherThanModelOpersList;
	}
	public void setHigherThanModelOpersList(List<ErpFunOpersDto> higherThanModelOpersList) {
		this.higherThanModelOpersList = higherThanModelOpersList;
	}
	public List<ErpFunOpersDto> getModelOpersList() {
		return modelOpersList;
	}
	public void setModelOpersList(List<ErpFunOpersDto> modelOpersList) {
		this.modelOpersList = modelOpersList;
	}
	public List<ErpFunOpersDto> getCheckedUserOpersList() {
		return checkedUserOpersList;
	}
	public void setCheckedUserOpersList(List<ErpFunOpersDto> checkedUserOpersList) {
		this.checkedUserOpersList = checkedUserOpersList;
	}
	public List<ErpFunOpers> getLoginUserOpersList() {
		return loginUserOpersList;
	}
	public void setLoginUserOpersList(List<ErpFunOpers> loginUserOpersList) {
		this.loginUserOpersList = loginUserOpersList;
	}
	public List<ErpFunOpersDto> getDefaultOpersList() {
		return defaultOpersList;
	}
	public void setDefaultOpersList(List<ErpFunOpersDto> defaultOpersList) {
		this.defaultOpersList = defaultOpersList;
	}
}
