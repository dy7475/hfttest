package com.myfun.erpWeb.managecenter.sysmanager.param;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetAuditDetailParam {

	@ApiModelProperty("公司id")
	private Integer compId;
	
	@ApiModelProperty("审核id")
	@NotNull
	private Integer auditId;
	
	@ApiModelProperty("类型")
	private Integer caseType;
	
	@ApiModelProperty("id集合")
	private List<Integer> caseIdList;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getAuditId() {
		return auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	public Integer getCaseType() {
		return caseType;
	}

	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	public List<Integer> getCaseIdList() {
		return caseIdList;
	}

	public void setCaseIdList(List<Integer> caseIdList) {
		this.caseIdList = caseIdList;
	}
}