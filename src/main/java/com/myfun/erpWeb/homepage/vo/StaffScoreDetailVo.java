package com.myfun.erpWeb.homepage.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class StaffScoreDetailVo {
	
	@ApiModelProperty(value = "员工当前工作总积分")
	private String staffAllScore;
	
	@ApiModelProperty(value = "当前月的月均积分")
	private String currentMonthScore;
	
	@ApiModelProperty(value = "上个月的月均积分")
	private String pastMonthScore;
	
	@ApiModelProperty(value = "员工半年积分动态集")
	private List<ScoreDynamicOfHalfAYearVo> list;

	public String getStaffAllScore() {
		return staffAllScore;
	}

	public void setStaffAllScore(String staffAllScore) {
		this.staffAllScore = staffAllScore;
	}

	public String getCurrentMonthScore() {
		return currentMonthScore;
	}

	public void setCurrentMonthScore(String currentMonthScore) {
		this.currentMonthScore = currentMonthScore;
	}

	public String getPastMonthScore() {
		return pastMonthScore;
	}

	public void setPastMonthScore(String pastMonthScore) {
		this.pastMonthScore = pastMonthScore;
	}

	public List<ScoreDynamicOfHalfAYearVo> getList() {
		return list;
	}

	public void setList(List<ScoreDynamicOfHalfAYearVo> list) {
		this.list = list;
	}
}