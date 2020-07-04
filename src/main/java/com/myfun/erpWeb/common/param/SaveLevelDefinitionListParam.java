package com.myfun.erpWeb.common.param;

import java.util.List;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月10日
 */
public class SaveLevelDefinitionListParam implements EncryParamIfc {

	@ApiModelProperty(hidden = true, value = "城市ID，后面跨库使用")
	private Integer cityId;
	@ApiModelProperty(hidden = true, value = "erp公司ID")
	private Integer compId;
	@ApiModelProperty(hidden = true, value = "操作者用户id")
	private Integer operatorUserId;
	@ApiModelProperty("组织机构定义列表")
	private List<SaveLevelDefinitionParam> saveLevelDefinitionParamList;
	
	public Integer getCityId() {
	
		return cityId;
	}
	public void setCityId(Integer cityId) {
	
		this.cityId = cityId;
	}
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public Integer getOperatorUserId() {
	
		return operatorUserId;
	}
	public void setOperatorUserId(Integer operatorUserId) {
	
		this.operatorUserId = operatorUserId;
	}
	public List<SaveLevelDefinitionParam> getSaveLevelDefinitionParamList() {
	
		return saveLevelDefinitionParamList;
	}
	public void setSaveLevelDefinitionParamList(List<SaveLevelDefinitionParam> saveLevelDefinitionParamList) {
	
		this.saveLevelDefinitionParamList = saveLevelDefinitionParamList;
	}
	
	
}

