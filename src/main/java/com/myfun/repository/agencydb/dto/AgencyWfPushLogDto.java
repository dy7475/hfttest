package com.myfun.repository.agencydb.dto;

import java.util.Date;

import com.myfun.repository.agencydb.po.AgencyWfPushLog;

public class AgencyWfPushLogDto extends AgencyWfPushLog{

	private static final long serialVersionUID = 1L;
	private String customerName;//客户姓名
	private String customerPhone;//客户电话
	private String yjCount;//佣金金额
	private String blCount;//保留意向
	private String userName;//经纪人姓名
	private String deptName;//所属门店名称
	private String isUpload;//是否上传资料,1=已上传,0=未上传
	private String starRating;
	private String jdCount;
	private String dkCount;
	private String cjCount;
	private String fkCount;
	private String userPosition;
	private String userPhoto;
	private Integer jjrUserId;//经纪人ID
	private Integer userGrId;//经纪人分组ID
	private Integer userDeptId;//经纪人门店ID
	private Integer userRegId;//经纪人片区ID
	private Integer userAreaId;//经纪人大区ID
	private Integer userCompId;//经纪人公司ID
	private String wtTime;//委托时间
	private String wtStatus;//委托状态
	private Integer isVip; // 是否是专属委托 1：是、0：否
	private Integer wfId; // 委托表主键
	private String caseSubject; // 委托信息标题摘要
	private String caseDesc; // 委托描述

	public String getWtStatus() {
		return wtStatus;
	}
	public void setWtStatus(String wtStatus) {
		this.wtStatus = wtStatus;
	}
	public String getWtTime() {
		return wtTime;
	}
	public void setWtTime(String wtTime) {
		this.wtTime = wtTime;
	}
	public Integer getJjrUserId() {
		return jjrUserId;
	}
	public void setJjrUserId(Integer jjrUserId) {
		this.jjrUserId = jjrUserId;
	}
	public Integer getUserGrId() {
		return userGrId;
	}
	public void setUserGrId(Integer userGrId) {
		this.userGrId = userGrId;
	}
	public Integer getUserDeptId() {
		return userDeptId;
	}
	public void setUserDeptId(Integer userDeptId) {
		this.userDeptId = userDeptId;
	}
	public Integer getUserRegId() {
		return userRegId;
	}
	public void setUserRegId(Integer userRegId) {
		this.userRegId = userRegId;
	}
	public Integer getUserAreaId() {
		return userAreaId;
	}
	public void setUserAreaId(Integer userAreaId) {
		this.userAreaId = userAreaId;
	}
	public Integer getUserCompId() {
		return userCompId;
	}
	public void setUserCompId(Integer userCompId) {
		this.userCompId = userCompId;
	}
	public String getIsUpload() {
		return isUpload;
	}
	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getStarRating() {
		return starRating;
	}
	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}
	public String getJdCount() {
		return jdCount;
	}
	public void setJdCount(String jdCount) {
		this.jdCount = jdCount;
	}
	public String getDkCount() {
		return dkCount;
	}
	public void setDkCount(String dkCount) {
		this.dkCount = dkCount;
	}
	public String getCjCount() {
		return cjCount;
	}
	public void setCjCount(String cjCount) {
		this.cjCount = cjCount;
	}
	public String getFkCount() {
		return fkCount;
	}
	public void setFkCount(String fkCount) {
		this.fkCount = fkCount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getYjCount() {
		return yjCount;
	}
	public void setYjCount(String yjCount) {
		this.yjCount = yjCount;
	}
	public String getBlCount() {
		return blCount;
	}
	public void setBlCount(String blCount) {
		this.blCount = blCount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getIsVip() {
		return isVip;
	}

	public void setIsVip(Integer isVip) {
		this.isVip = isVip;
	}

	public Integer getWfId() {
		return wfId;
	}

	public void setWfId(Integer wfId) {
		this.wfId = wfId;
	}

	public String getCaseSubject() {
		return caseSubject;
	}

	public void setCaseSubject(String caseSubject) {
		this.caseSubject = caseSubject;
	}

	public String getCaseDesc() {
		return caseDesc;
	}

	public void setCaseDesc(String caseDesc) {
		this.caseDesc = caseDesc;
	}
}
