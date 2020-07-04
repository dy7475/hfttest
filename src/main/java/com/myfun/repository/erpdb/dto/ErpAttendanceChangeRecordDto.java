package com.myfun.repository.erpdb.dto;

import java.util.Date;

public class ErpAttendanceChangeRecordDto {
	
	 /**
    *
    * @mbggenerated
   考勤修改记录ID,主键
    */
   private Integer recordId;

   /**
    *
    * @mbggenerated
   考勤记录ID
    */
   private Integer attendanceId;

   /**
    *
    * @mbggenerated
   公司ID
    */
   private Integer compId;

   /**
    *
    * @mbggenerated
   上班还是下班 0上班 1下班
    */
   private String workType;

   /**
    *
    * @mbggenerated
   具体上班类型（1.4正常2.5值班3.6晚班）
    */
   private String workDetailType;

   /**
    *
    * @mbggenerated
   考勤所属人的ID
    */
   private Integer sourceUserId;

   /**
    *
    * @mbggenerated
   考勤所属人门店ID
    */
   private Integer sourceDeptId;

   /**
    *
    * @mbggenerated
   考勤所属人姓名
    */
   private String sourceUserName;

   /**
    *
    * @mbggenerated
   考勤修改人ID
    */
   private Integer changeUserId;

   /**
    *
    * @mbggenerated
   考勤修改人姓名
    */
   private String changeUserName;

   /**
    *
    * @mbggenerated
   考勤状态变更
    */
   private String changeState;

   /**
    *
    * @mbggenerated
   修改原因
    */
   private String changeReason;

   /**
    *
    * @mbggenerated
   考勤原始时间
    */
   private Date sourceCreateTime;

   /**
    *
    * @mbggenerated
   创建时间
    */
   private Date createTime;

	public Integer getRecordId() {
		return recordId;
	}
	
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	
	public Integer getAttendanceId() {
		return attendanceId;
	}
	
	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}
	
	public Integer getCompId() {
		return compId;
	}
	
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	
	public String getWorkType() {
		return workType;
	}
	
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	public String getWorkDetailType() {
		return workDetailType;
	}
	
	public void setWorkDetailType(String workDetailType) {
		this.workDetailType = workDetailType;
	}
	
	public Integer getSourceUserId() {
		return sourceUserId;
	}
	
	public void setSourceUserId(Integer sourceUserId) {
		this.sourceUserId = sourceUserId;
	}
	
	public Integer getSourceDeptId() {
		return sourceDeptId;
	}
	
	public void setSourceDeptId(Integer sourceDeptId) {
		this.sourceDeptId = sourceDeptId;
	}
	
	public String getSourceUserName() {
		return sourceUserName;
	}
	
	public void setSourceUserName(String sourceUserName) {
		this.sourceUserName = sourceUserName;
	}
	
	public Integer getChangeUserId() {
		return changeUserId;
	}
	
	public void setChangeUserId(Integer changeUserId) {
		this.changeUserId = changeUserId;
	}
	
	public String getChangeUserName() {
		return changeUserName;
	}
	
	public void setChangeUserName(String changeUserName) {
		this.changeUserName = changeUserName;
	}
	
	public String getChangeState() {
		return changeState;
	}
	
	public void setChangeState(String changeState) {
		this.changeState = changeState;
	}
	
	public String getChangeReason() {
		return changeReason;
	}
	
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	
	public Date getSourceCreateTime() {
		return sourceCreateTime;
	}
	
	public void setSourceCreateTime(Date sourceCreateTime) {
		this.sourceCreateTime = sourceCreateTime;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
   
   

}
