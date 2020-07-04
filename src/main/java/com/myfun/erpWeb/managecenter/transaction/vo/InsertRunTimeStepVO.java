package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "插入实例流程步骤")
public class InsertRunTimeStepVO implements Serializable {

	@ApiModelProperty("合同ID")
	private Integer dealId;
	@ApiModelProperty("插入步骤的实例步骤ID,非步骤模板ID")
	private Integer runStepId;
	@ApiModelProperty("插入步骤的序号")
	private Integer stepSeq;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getRunStepId() {
		return runStepId;
	}

	public void setRunStepId(Integer runStepId) {
		this.runStepId = runStepId;
	}

	public Integer getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(Integer stepSeq) {
		this.stepSeq = stepSeq;
	}
}
