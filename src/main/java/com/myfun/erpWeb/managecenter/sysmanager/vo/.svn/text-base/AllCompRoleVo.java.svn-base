package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpCompRoles;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AllCompRoleVo {

	@ApiModelProperty(value = "公司角色信息集")
	private List<ErpCompRoles> erpCompRolesList;
	
	@ApiModelProperty(value = "公司角色职级对应信息集")
	private List<ErpCompRoleLevelsVO> compRoleLevelList;

	public List<ErpCompRoles> getErpCompRolesList() {
		return erpCompRolesList;
	}

	public void setErpCompRolesList(List<ErpCompRoles> erpCompRolesList) {
		this.erpCompRolesList = erpCompRolesList;
	}

	public List<ErpCompRoleLevelsVO> getCompRoleLevelList() {
		return compRoleLevelList;
	}

	public void setCompRoleLevelList(List<ErpCompRoleLevelsVO> compRoleLevelList) {
		this.compRoleLevelList = compRoleLevelList;
	}
}
