package com.myfun.erpWeb.openApi.analysis.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class HouseCustNewCountDto {
	@ApiModelProperty(value = "房增统计")
	private List<DealAnalysisForWebDto> houseCount;
	@ApiModelProperty(value = "客增统计")
	private List<DealAnalysisForWebDto> custCount;

	public List<DealAnalysisForWebDto> getHouseCount() {
		return houseCount;
	}

	public void setHouseCount(List<DealAnalysisForWebDto> houseCount) {
		this.houseCount = houseCount;
	}

	public List<DealAnalysisForWebDto> getCustCount() {
		return custCount;
	}

	public void setCustCount(List<DealAnalysisForWebDto> custCount) {
		this.custCount = custCount;
	}
}
