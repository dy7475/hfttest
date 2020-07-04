package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModelProperty;

public class ScoreCountRankDto {
	@ApiModelProperty(value = "档案ID")
	private Integer archiveId;
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	@ApiModelProperty(value = "月平均积分")
	private String monthScoreAvgCount;
	@ApiModelProperty(value = "日平均积分")
	private String dayScoreAvgCount;
	@ApiModelProperty(value = "本月积分")
	private String currentMonthScoreCount;
	@ApiModelProperty(value = "总积分")
	private String totalScoreCount;

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getCurrentMonthScoreCount() {
		return currentMonthScoreCount;
	}

	public void setCurrentMonthScoreCount(String currentMonthScoreCount) {
		this.currentMonthScoreCount = currentMonthScoreCount;
	}

	public String getTotalScoreCount() {
		return totalScoreCount;
	}

	public void setTotalScoreCount(String totalScoreCount) {
		this.totalScoreCount = totalScoreCount;
	}
}
