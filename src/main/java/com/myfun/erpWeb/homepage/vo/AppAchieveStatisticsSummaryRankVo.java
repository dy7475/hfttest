package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModelProperty;

public class AppAchieveStatisticsSummaryRankVo {

	@ApiModelProperty(value = "业务类型")
	private String typeName;
	@ApiModelProperty(value = "今日总量")
	private Integer todayTotal;
	@ApiModelProperty(value = "本周总量")
	private Integer weekTotal;
	@ApiModelProperty(value = "本月总量")
	private Integer monthTotal;
	@ApiModelProperty(value = "今日目标量")
	private Integer todayTarget;
	@ApiModelProperty(value = "本周目标量")
	private Integer weekTarget;
	@ApiModelProperty(value = "本月目标量")
	private Integer monthTarget;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getTodayTotal() {
		return todayTotal;
	}
	public void setTodayTotal(Integer todayTotal) {
		this.todayTotal = todayTotal;
	}
	public Integer getWeekTotal() {
		return weekTotal;
	}
	public void setWeekTotal(Integer weekTotal) {
		this.weekTotal = weekTotal;
	}
	public Integer getMonthTotal() {
		return monthTotal;
	}
	public void setMonthTotal(Integer monthTotal) {
		this.monthTotal = monthTotal;
	}
	public Integer getTodayTarget() {
		return todayTarget;
	}
	public void setTodayTarget(Integer todayTarget) {
		this.todayTarget = todayTarget;
	}
	public Integer getWeekTarget() {
		return weekTarget;
	}
	public void setWeekTarget(Integer weekTarget) {
		this.weekTarget = weekTarget;
	}
	public Integer getMonthTarget() {
		return monthTarget;
	}
	public void setMonthTarget(Integer monthTarget) {
		this.monthTarget = monthTarget;
	}
}
