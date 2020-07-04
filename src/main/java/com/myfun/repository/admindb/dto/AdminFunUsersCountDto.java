package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunUsersCount;

public class AdminFunUsersCountDto extends AdminFunUsersCount{

	private static final long serialVersionUID = 1L;
	
	private Integer totalScore;

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	
}
