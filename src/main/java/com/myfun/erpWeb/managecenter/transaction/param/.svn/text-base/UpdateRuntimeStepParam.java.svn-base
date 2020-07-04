package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class UpdateRuntimeStepParam implements EncryParamIfc {

	@ApiModelProperty(value = "实例步骤数据", required = true)
	private List<UpdateRuntimeStepSeqParam> stepList;
	@ApiModelProperty(value = "合同ID", required = true)
	private Integer dealId;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public List<UpdateRuntimeStepSeqParam> getStepList() {
		return stepList;
	}

	public void setStepList(List<UpdateRuntimeStepSeqParam> stepList) {
		this.stepList = stepList;
	}
}
