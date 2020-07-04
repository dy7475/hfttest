package com.myfun.erpWeb.openApi.analysis.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CompHouseTotalDto {
	@ApiModelProperty(value = "出售总量")
	private Integer saleCount;
	@ApiModelProperty(value = "出租总量")
	private Integer leaseCount;

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public Integer getLeaseCount() {
		return leaseCount;
	}

	public void setLeaseCount(Integer leaseCount) {
		this.leaseCount = leaseCount;
	}
}
