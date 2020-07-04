package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;

public class ErpProfitMessageFormParam implements EncryParamIfc {

	protected Integer pageOffset; // 1 第几页
	protected Integer pageRows; // 50 一页多少条
	private String assessmentMonth; //	考核月（自然月）
	private Integer compId;
	private Integer deptId;
	private Integer userId;
	private Integer areaId;
	private Integer regId;
	private Integer grId;
	private Integer checkType; // 1=个人，2=管理
	private Integer profitType; //业绩类型 0=个人业绩，1=公司业绩
	private Integer validFlag; // 异常状态 0=正常 1=异常
	private String ids;
	private Integer dealId;
	private Integer assessmentId;
	private String profitIds;

	public String getProfitIds() {
		return profitIds;
	}

	public void setProfitIds(String profitIds) {
		this.profitIds = profitIds;
	}

	public Integer getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Integer getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageRows() {
		return pageRows;
	}

	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}

	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public Integer getProfitType() {
		return profitType;
	}

	public void setProfitType(Integer profitType) {
		this.profitType = profitType;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}


	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
