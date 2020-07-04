package com.myfun.erpWeb.managecenter.constract.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class InsertIntoDealInfoVo {

	@ApiModelProperty("合同dealId")
	private Integer dealId;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
}