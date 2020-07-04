package com.myfun.service.jms.bean;

/**
 * 增加提醒总经理查看条数达到上限
 * @author 张宏利
 * @since 2018年2月11日
 */
public class ViewLogTaskWarningParam {
	private Integer cityId;
	private Integer compId;
	private Integer caseType;
	private Integer casePlateType;
	private String  userName;
	private Integer caseId;
	private String  caseNo;
	private Integer caseDeptId;
	private Integer selfDeptId;
	private Integer selfUserId;
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public Integer getCasePlateType() {
		return casePlateType;
	}
	public void setCasePlateType(Integer casePlateType) {
		this.casePlateType = casePlateType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public Integer getCaseDeptId() {
		return caseDeptId;
	}
	public void setCaseDeptId(Integer caseDeptId) {
		this.caseDeptId = caseDeptId;
	}
	public Integer getSelfDeptId() {
		return selfDeptId;
	}
	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
	}
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	
	
}
