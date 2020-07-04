package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FunContractParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "财务状态ID")
	private Integer financStatusId;
	@ApiModelProperty(value = "财务状态名字")
	private String financName;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getFinancStatusId() {
		return financStatusId;
	}

	public void setFinancStatusId(Integer financStatusId) {
		this.financStatusId = financStatusId;
	}

	public String getFinancName() {
		return financName;
	}

	public void setFinancName(String financName) {
		this.financName = financName;
	}
}
