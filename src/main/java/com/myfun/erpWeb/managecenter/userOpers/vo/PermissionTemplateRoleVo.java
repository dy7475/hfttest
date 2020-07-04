package com.myfun.erpWeb.managecenter.userOpers.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunOpersDto;

import io.swagger.annotations.ApiModelProperty;

public class PermissionTemplateRoleVo {
	@ApiModelProperty("权限列表")
	private List<ErpFunOpersDto> operIds;

	public List<ErpFunOpersDto> getOperIds() {
		return operIds;
	}

	public void setOperIds(List<ErpFunOpersDto> operIds) {
		this.operIds = operIds;
	}
	
}
