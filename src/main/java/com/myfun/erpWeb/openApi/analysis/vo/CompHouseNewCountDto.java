package com.myfun.erpWeb.openApi.analysis.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CompHouseNewCountDto {
	@ApiModelProperty(value = "出售今日新增量")
	private Integer saleTotayCount;

	@ApiModelProperty(value = "出售昨日新增量")
	private Integer saleYesterdayCount;

	@ApiModelProperty(value = "出租今日新增量")
	private Integer leaseTotayCount;

	@ApiModelProperty(value = "出租昨日新增量")
	private Integer leaseYesterdayCount;

	public Integer getSaleTotayCount() {
		return saleTotayCount;
	}

	public void setSaleTotayCount(Integer saleTotayCount) {
		this.saleTotayCount = saleTotayCount;
	}

	public Integer getSaleYesterdayCount() {
		return saleYesterdayCount;
	}

	public void setSaleYesterdayCount(Integer saleYesterdayCount) {
		this.saleYesterdayCount = saleYesterdayCount;
	}

	public Integer getLeaseTotayCount() {
		return leaseTotayCount;
	}

	public void setLeaseTotayCount(Integer leaseTotayCount) {
		this.leaseTotayCount = leaseTotayCount;
	}

	public Integer getLeaseYesterdayCount() {
		return leaseYesterdayCount;
	}

	public void setLeaseYesterdayCount(Integer leaseYesterdayCount) {
		this.leaseYesterdayCount = leaseYesterdayCount;
	}
}
