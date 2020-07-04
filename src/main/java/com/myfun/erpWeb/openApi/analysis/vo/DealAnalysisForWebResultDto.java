package com.myfun.erpWeb.openApi.analysis.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class DealAnalysisForWebResultDto {
	@ApiModelProperty(value = "买卖成交列表")
	private List<DealAnalysisForWebDto> sale;
	@ApiModelProperty(value = "租赁成交列表")
	private List<DealAnalysisForWebDto> lease;

	public List<DealAnalysisForWebDto> getSale() {
		return sale;
	}

	public void setSale(List<DealAnalysisForWebDto> sale) {
		this.sale = sale;
	}

	public List<DealAnalysisForWebDto> getLease() {
		return lease;
	}

	public void setLease(List<DealAnalysisForWebDto> lease) {
		this.lease = lease;
	}
}
