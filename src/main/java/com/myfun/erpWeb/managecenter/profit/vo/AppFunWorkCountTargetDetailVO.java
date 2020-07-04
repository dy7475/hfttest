package com.myfun.erpWeb.managecenter.profit.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppFunWorkCountTargetDetailVO {
	
	@ApiModelProperty(value = "日目标量")
	private AppFunWorkCountTargetSubVo dayDetail;
	
	@ApiModelProperty(value = "周目标量")
	private AppFunWorkCountTargetSubVo weekDetail;
	
	@ApiModelProperty(value = "月目标量")
	private AppFunWorkCountTargetSubVo monthDetail;

	public AppFunWorkCountTargetSubVo getDayDetail() {
		return dayDetail;
	}

	public void setDayDetail(AppFunWorkCountTargetSubVo dayDetail) {
		this.dayDetail = dayDetail;
	}

	public AppFunWorkCountTargetSubVo getWeekDetail() {
		return weekDetail;
	}

	public void setWeekDetail(AppFunWorkCountTargetSubVo weekDetail) {
		this.weekDetail = weekDetail;
	}

	public AppFunWorkCountTargetSubVo getMonthDetail() {
		return monthDetail;
	}

	public void setMonthDetail(AppFunWorkCountTargetSubVo monthDetail) {
		this.monthDetail = monthDetail;
	}
}