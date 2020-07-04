package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class CreateProcessModelParam implements EncryParamIfc {
	@ApiModelProperty("流程名称")
	private String proName;
	@ApiModelProperty("流程ID,逗号分隔")
	private String stepIds;

	public String getStepIds() {
		return stepIds;
	}

	public void setStepIds(String stepIds) {
		this.stepIds = stepIds;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
}
