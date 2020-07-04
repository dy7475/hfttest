package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModelProperty;

public class FunUserManageRangeVo {
	
	@ApiModelProperty(value = "范围类型，1=公司 2=大区 3=片区 4=门店 5=分组 6=個人")
	private Integer rangeType;
	
	@ApiModelProperty(value = "范围类型对应的Id，如:rangeType=1 则对应的rangeId为compId")
	private Integer rangeId;
	
	@ApiModelProperty(value = "范围类型名字")
	private String rangeName;

	@ApiModelProperty(value = "新组织机构层级Id,organizationId对应的层级Id")
	private Integer defId;
	@ApiModelProperty(value = "定义层级的名称")
	private String definitionName;
	@ApiModelProperty(value = "定义的层级")
	private Integer definitionLevel;
	@ApiModelProperty(value = "组织Id")
	private Integer organizationId;

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public Integer getRangeId() {
		return rangeId;
	}

	public void setRangeId(Integer rangeId) {
		this.rangeId = rangeId;
	}

	public String getRangeName() {
		return rangeName;
	}

	public void setRangeName(String rangeName) {
		this.rangeName = rangeName;
	}

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}

	public Integer getDefinitionLevel() {
		return definitionLevel;
	}

	public void setDefinitionLevel(Integer definitionLevel) {
		this.definitionLevel = definitionLevel;
	}

	public String getDefinitionName() {
		return definitionName;
	}

	public void setDefinitionName(String definitionName) {
		this.definitionName = definitionName;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
}
