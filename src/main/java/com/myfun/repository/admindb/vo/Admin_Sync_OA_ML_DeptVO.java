package com.myfun.repository.admindb.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
* @ClassName: Admin_Sync_OA_ML_DeptVO 
* @Description:部门异动信息
* @author tangliang1
* @date 2020年6月28日 下午3:57:21 
*
 */
public class Admin_Sync_OA_ML_DeptVO {
	
	private String type;
	private String typeCode;
	private String changeTitle;
	private String changeCode;
	private String deptCode;
	private String newMarketName;
	private String oldMarketName;
	private String orgPath;
	private String orgPathHistory;
	private Integer orgLevel;
	private String deptGradeTitle;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date changeDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date initializedTime;
	private String orgCode;
	private String orgName;
	private String parentOrgName;
	private String oldOrgName;
	
	// 失效日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date invalidDate;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getChangeTitle() {
		return changeTitle;
	}
	public void setChangeTitle(String changeTitle) {
		this.changeTitle = changeTitle;
	}
	public String getChangeCode() {
		return changeCode;
	}
	public void setChangeCode(String changeCode) {
		this.changeCode = changeCode;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getNewMarketName() {
		return newMarketName;
	}
	public void setNewMarketName(String newMarketName) {
		this.newMarketName = newMarketName;
	}
	public String getOldMarketName() {
		return oldMarketName;
	}
	public void setOldMarketName(String oldMarketName) {
		this.oldMarketName = oldMarketName;
	}
	public String getOrgPath() {
		return orgPath;
	}
	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}
	public String getOrgPathHistory() {
		return orgPathHistory;
	}
	public void setOrgPathHistory(String orgPathHistory) {
		this.orgPathHistory = orgPathHistory;
	}
	public Integer getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getDeptGradeTitle() {
		return deptGradeTitle;
	}
	public void setDeptGradeTitle(String deptGradeTitle) {
		this.deptGradeTitle = deptGradeTitle;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public Date getInitializedTime() {
		return initializedTime;
	}
	public void setInitializedTime(Date initializedTime) {
		this.initializedTime = initializedTime;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getParentOrgName() {
		return parentOrgName;
	}
	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}
	public String getOldOrgName() {
		return oldOrgName;
	}
	public void setOldOrgName(String oldOrgName) {
		this.oldOrgName = oldOrgName;
	}
	public Date getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	
}