package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class MgrWarrantStepListVO {

	@ApiModelProperty(value = "流程步骤")
	List<ErpProcessRuntimeStepDto> list;
	@ApiModelProperty(value = "流程模板")
	Integer conditionStepId;
	@ApiModelProperty(value = "需要完成的条件步凑，以逗号分隔")
	String conditionStepIds;


	public List<ErpProcessRuntimeStepDto> getList() {
		return list;
	}

	public void setList(List<ErpProcessRuntimeStepDto> list) {
		this.list = list;
	}

	public Integer getConditionStepId() {
		return conditionStepId;
	}

	public void setConditionStepId(Integer conditionStepId) {
		this.conditionStepId = conditionStepId;
	}

	public String getConditionStepIds() {
		return conditionStepIds;
	}

	public void setConditionStepIds(String conditionStepIds) {
		this.conditionStepIds = conditionStepIds;
	}
}
