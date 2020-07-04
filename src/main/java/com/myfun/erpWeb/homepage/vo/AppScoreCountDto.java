package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AppScoreCountDto {
	@ApiModelProperty(value = "当前登录人日平均积分")
	private String currentUserScoreAvgCount;
	@ApiModelProperty(value = "管理范围月平均积分")
	private String monthScoreAvgCount;
	@ApiModelProperty(value = "管理范围日平均积分")
	private String dayScoreAvgCount;


	public String getCurrentUserScoreAvgCount() {
		return currentUserScoreAvgCount;
	}

	public void setCurrentUserScoreAvgCount(String currentUserScoreAvgCount) {
		this.currentUserScoreAvgCount = currentUserScoreAvgCount;
	}

	public String getMonthScoreAvgCount() {
		return monthScoreAvgCount;
	}

	public void setMonthScoreAvgCount(String monthScoreAvgCount) {
		this.monthScoreAvgCount = monthScoreAvgCount;
	}

	public String getDayScoreAvgCount() {
		return dayScoreAvgCount;
	}

	public void setDayScoreAvgCount(String dayScoreAvgCount) {
		this.dayScoreAvgCount = dayScoreAvgCount;
	}
}
