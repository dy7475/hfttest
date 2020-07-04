package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月5日
 */
public class SaveLevelDefinitionParam implements EncryParamIfc {

	@ApiModelProperty(value = "组织定义层级的名字")
	private String definitionName;
//	@ApiModelProperty(value = "组织定义的层级")
//	private Integer definitionLevel;
	@ApiModelProperty(value = "定义层级的id；新增时为空，否则为编辑和删除")
	private Integer definitionId;
	@ApiModelProperty(value = "（关闭）删除=1、（开启）编辑=2，配合definitionId使用")
	private Integer updateType;
	
	
	public Integer getDefinitionId() {
	
		return definitionId;
	}
	public void setDefinitionId(Integer definitionId) {
	
		this.definitionId = definitionId;
	}
	public Integer getUpdateType() {
	
		return updateType;
	}
	public void setUpdateType(Integer updateType) {
	
		this.updateType = updateType;
	}
	public String getDefinitionName() {
	
		return definitionName;
	}
	public void setDefinitionName(String definitionName) {
	
		this.definitionName = definitionName;
	}
	
	
}

