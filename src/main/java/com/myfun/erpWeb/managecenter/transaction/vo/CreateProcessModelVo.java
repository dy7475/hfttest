package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreateProcessModelVo {
	@ApiModelProperty("模板ID")
	private Integer modelId;

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
}
