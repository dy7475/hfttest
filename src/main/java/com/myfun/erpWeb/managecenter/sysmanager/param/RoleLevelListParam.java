package com.myfun.erpWeb.managecenter.sysmanager.param;

import java.util.List;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RoleLevelListParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "修改和创建职级信息集合")
	private List<RoleLevelParam> roleLevelList;

	public List<RoleLevelParam> getRoleLevelList() {
		return roleLevelList;
	}

	public void setRoleLevelList(List<RoleLevelParam> roleLevelList) {
		this.roleLevelList = roleLevelList;
	}
}
