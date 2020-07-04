package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.erpdb.po.ErpFunKeyOperationLog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunKeyOperationLogDto extends ErpFunKeyOperationLog {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "房源类型")
	private Integer caseType;
	
	@ApiModelProperty(value = "房源id")
	private Integer caseId;
	
	@ApiModelProperty(value = "房源概要信息")
	private String caseSummaryInfo;

	public Integer getCaseType() {
		return caseType;
	}

	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getCaseSummaryInfo() {
		return caseSummaryInfo;
	}

	public void setCaseSummaryInfo(String caseSummaryInfo) {
		this.caseSummaryInfo = caseSummaryInfo;
	}
}
