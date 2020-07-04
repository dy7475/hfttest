package com.myfun.erpWeb.managecenter.constract.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ContractNoAvailableVo {
	@ApiModelProperty("返回值：1=合同号重复，2=合同号段规则外 ，3=可以使用，4=合同号段已用完")
	private Integer result;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
}
