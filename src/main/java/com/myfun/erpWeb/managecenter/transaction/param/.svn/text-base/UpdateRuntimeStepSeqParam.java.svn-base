package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateRuntimeStepSeqParam implements EncryParamIfc {

	@ApiModelProperty(value = "实例步骤ID", required = true)
	private Integer runStepId;

	@ApiModelProperty(value = "实例步骤ID", required = true)
	private Integer stepSeq;
	@ApiModelProperty(value = "执行状态 1:未处理 2:待处理 3:已处理 4跳过", hidden = true)
	private Byte runstepStatus;

	public Byte getRunstepStatus() {
		return runstepStatus;
	}

	public void setRunstepStatus(Byte runstepStatus) {
		this.runstepStatus = runstepStatus;
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
