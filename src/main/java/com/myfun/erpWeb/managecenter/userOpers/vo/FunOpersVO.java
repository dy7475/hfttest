package com.myfun.erpWeb.managecenter.userOpers.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("权限对象")
public class FunOpersVO {

	@ApiModelProperty("组合权限名称")
	private String operId;
	@ApiModelProperty("组织机构定义")
	private Integer organizationDefinitionId;
	@ApiModelProperty("组织机构层级")
	private Integer definitionLevel;

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public Integer getOrganizationDefinitionId() {
		return organizationDefinitionId;
	}

	public void setOrganizationDefinitionId(Integer organizationDefinitionId) {
		this.organizationDefinitionId = organizationDefinitionId;
	}

	public Integer getDefinitionLevel() {
		return definitionLevel;
	}

	public void setDefinitionLevel(Integer definitionLevel) {
		this.definitionLevel = definitionLevel;
	}
}
