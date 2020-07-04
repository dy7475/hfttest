package com.myfun.erpWeb.managecenter.financialStatements.vo;

import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel(description = "业绩提成报表")
public class PercentProfitListVo implements Serializable {
	@ApiModelProperty("业绩类别列表")
	private List<ErpFunPerformanceType> dynamicColumn;
	@ApiModelProperty(" 业绩列表")
	private List<Map<String, String>> profitList;
	private String extra;

	public List<ErpFunPerformanceType> getDynamicColumn() {
		return dynamicColumn;
	}

	public void setDynamicColumn(List<ErpFunPerformanceType> dynamicColumn) {
		this.dynamicColumn = dynamicColumn;
	}

	public List<Map<String, String>> getProfitList() {
		return profitList;
	}

	public void setProfitList(List<Map<String, String>> profitList) {
		this.profitList = profitList;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
}
