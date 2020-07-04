package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunAssessmentStatistics;

import java.io.Serializable;
import java.util.List;

public class ErpFunAssessmentStatisticsDto extends ErpFunAssessmentStatistics implements Serializable {

	private List<ErpFunAssessmentStatistics> userAssessMentDetailList;

	public List<ErpFunAssessmentStatistics> getUserAssessMentDetailList() {
		return userAssessMentDetailList;
	}

	public void setUserAssessMentDetailList(List<ErpFunAssessmentStatistics> userAssessMentDetailList) {
		this.userAssessMentDetailList = userAssessMentDetailList;
	}
}
