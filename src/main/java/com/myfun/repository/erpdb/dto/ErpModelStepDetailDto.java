package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpProcessModelStep;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpModelStepDetailDto extends ErpProcessModelStep{
	@ApiModelProperty("步骤序号")
	private String stepSeq;

	public String getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(String stepSeq) {
		this.stepSeq = stepSeq;
	}
	
}
