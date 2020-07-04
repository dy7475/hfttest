package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ScoreDynamicOfHalfAYearVo {

	@ApiModelProperty(value = "月份")
	private Integer month;
	
	@ApiModelProperty(value = "月积分")
	private String score;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}