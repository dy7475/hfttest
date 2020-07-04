package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class InsertProfitTargetListParam implements EncryParamIfc {
	@ApiModelProperty(value = "参数列表")
	private List<MgrProfiTargetParamForInsert> targetList;
	@ApiModelProperty("业绩的月份")
	private String targetDate;

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public List<MgrProfiTargetParamForInsert> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<MgrProfiTargetParamForInsert> targetList) {
		this.targetList = targetList;
	}
}
