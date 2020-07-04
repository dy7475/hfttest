package com.myfun.repository.admindb.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
* @ClassName: UserTransferVo 
* @Description: 同步HRS人员调迁记录 
* @author tangliang1
* @date 2020年6月29日 下午4:29:00 
*
 */
public class UserTransferVo {
	
	
	// 异动类型
	private String cType;
	private String typeCode;
	//异动事件id
	private String changeId;
	private String changeTitle;
	
	private String name;
	private String certNo;
	private String oldMobile;
	private String newMobile;
	// 起效日期
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date chageDate;
	// 失效日期
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date invalidDate;
	private String oldEmpCode;
	private String newEmpCode;
	private String oldDeptId;
	private String newDeptId;
	private String oldMarket;
	private String oldMarketName;
	private String newMarket;
	private String newMarketName;
	private String oldEmpGrade;
	private String newEmpGrade;
	private Date joinDate;
	private Date leaveDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date initializedTime;
	private String oldJobName;
	private String newJobName;
	private String eStatus;
	private String oldQxType;
	private String oldQxTypeName;
	private String newQxType;
	private String newQxTypeName;
	private String orgPath;
	
	// 组织名称
	private String newOrgName;
	private String oldOrgName;
	
	public String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		this.cType = cType;
	}
	public String getChangeTitle() {
		return changeTitle;
	}
	public void setChangeTitle(String changeTitle) {
		this.changeTitle = changeTitle;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getChangeId() {
		return changeId;
	}
	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getOldMobile() {
		return oldMobile;
	}
	public void setOldMobile(String oldMobile) {
		this.oldMobile = oldMobile;
	}
	public String getNewMobile() {
		return newMobile;
	}
	public void setNewMobile(String newMobile) {
		this.newMobile = newMobile;
	}

	public Date getChageDate() {
		return chageDate;
	}
	public void setChageDate(Date chageDate) {
		this.chageDate = chageDate;
	}
	public Date getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	public String getOldEmpCode() {
		return oldEmpCode;
	}
	public void setOldEmpCode(String oldEmpCode) {
		this.oldEmpCode = oldEmpCode;
	}
	public String getNewEmpCode() {
		return newEmpCode;
	}
	public void setNewEmpCode(String newEmpCode) {
		this.newEmpCode = newEmpCode;
	}
	public String getOldDeptId() {
		return oldDeptId;
	}
	public void setOldDeptId(String oldDeptId) {
		this.oldDeptId = oldDeptId;
	}
	public String getNewDeptId() {
		return newDeptId;
	}
	public void setNewDeptId(String newDeptId) {
		this.newDeptId = newDeptId;
	}
	public String getOldMarket() {
		return oldMarket;
	}
	public void setOldMarket(String oldMarket) {
		this.oldMarket = oldMarket;
	}
	public String getOldMarketName() {
		return oldMarketName;
	}
	public void setOldMarketName(String oldMarketName) {
		this.oldMarketName = oldMarketName;
	}
	public String getNewMarket() {
		return newMarket;
	}
	public void setNewMarket(String newMarket) {
		this.newMarket = newMarket;
	}
	public String getNewMarketName() {
		return newMarketName;
	}
	public void setNewMarketName(String newMarketName) {
		this.newMarketName = newMarketName;
	}
	public String getOldEmpGrade() {
		return oldEmpGrade;
	}
	public void setOldEmpGrade(String oldEmpGrade) {
		this.oldEmpGrade = oldEmpGrade;
	}
	public String getNewEmpGrade() {
		return newEmpGrade;
	}
	public void setNewEmpGrade(String newEmpGrade) {
		this.newEmpGrade = newEmpGrade;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public Date getInitializedTime() {
		return initializedTime;
	}
	public void setInitializedTime(Date initializedTime) {
		this.initializedTime = initializedTime;
	}
	public String getOldJobName() {
		return oldJobName;
	}
	public void setOldJobName(String oldJobName) {
		this.oldJobName = oldJobName;
	}
	public String getNewJobName() {
		return newJobName;
	}
	public void setNewJobName(String newJobName) {
		this.newJobName = newJobName;
	}
	public String geteStatus() {
		return eStatus;
	}
	public void seteStatus(String eStatus) {
		this.eStatus = eStatus;
	}
	public String getOldQxType() {
		return oldQxType;
	}
	public void setOldQxType(String oldQxType) {
		this.oldQxType = oldQxType;
	}
	public String getOldQxTypeName() {
		return oldQxTypeName;
	}
	public void setOldQxTypeName(String oldQxTypeName) {
		this.oldQxTypeName = oldQxTypeName;
	}
	public String getNewQxType() {
		return newQxType;
	}
	public void setNewQxType(String newQxType) {
		this.newQxType = newQxType;
	}
	public String getNewQxTypeName() {
		return newQxTypeName;
	}
	public void setNewQxTypeName(String newQxTypeName) {
		this.newQxTypeName = newQxTypeName;
	}
	public String getOrgPath() {
		return orgPath;
	}
	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}
	public String getNewOrgName() {
		return newOrgName;
	}
	public void setNewOrgName(String newOrgName) {
		this.newOrgName = newOrgName;
	}
	public String getOldOrgName() {
		return oldOrgName;
	}
	public void setOldOrgName(String oldOrgName) {
		this.oldOrgName = oldOrgName;
	}
	
	
}