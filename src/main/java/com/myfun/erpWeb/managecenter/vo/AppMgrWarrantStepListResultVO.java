package com.myfun.erpWeb.managecenter.vo;

import java.io.Serializable;
import java.util.List;

import com.myfun.erpWeb.managecenter.transaction.vo.ErpProcessRuntimeStepDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppMgrWarrantStepListResultVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("流程列表")
	List<ErpProcessRuntimeStepDto> stepList;
	@ApiModelProperty(value = "需要完成的条件步凑，以逗号分隔")
	String conditionStepIds;
	public List<ErpProcessRuntimeStepDto> getStepList() {
		return stepList;
	}

	public void setStepList(List<ErpProcessRuntimeStepDto> stepList) {
		this.stepList = stepList;
	}

	public String getConditionStepIds() {
		return conditionStepIds;
	}

	public void setConditionStepIds(String conditionStepIds) {
		this.conditionStepIds = conditionStepIds;
	}
}
