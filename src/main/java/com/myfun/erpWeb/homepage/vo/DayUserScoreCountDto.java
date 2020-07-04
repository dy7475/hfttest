package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModelProperty;

public class DayUserScoreCountDto {
	@ApiModelProperty(value = "今日总量")
	private Integer count ;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
