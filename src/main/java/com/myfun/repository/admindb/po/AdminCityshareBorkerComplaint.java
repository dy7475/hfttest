package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminCityshareBorkerComplaint implements Serializable {

	/**
	 * @mbggenerated SEQ序列，自增序列
	 */
	private Integer complaintId;
	/**
	 * @mbggenerated 关联的分享表ID
	 */
	private Integer sharehouseId;
	/**
	 * @mbggenerated 投诉来源，0=房源购买方 1=房源分享方
	 */
	private Byte cinfoType;
	/**
	 * @mbggenerated 投诉人公司
	 */
	private Integer sourceCompId;
	/**
	 * @mbggenerated 投诉人门店
	 */
	private Integer sourceDeptId;
	/**
	 * @mbggenerated 投诉人
	 */
	private Integer sourceUserId;
	/**
	 * @mbggenerated 投诉人的档案ID
	 */
	private Integer sourceArchiveId;
	/**
	 * @mbggenerated 被投诉人公司
	 */
	private Integer targetCompId;
	/**
	 * @mbggenerated 被投诉人门店
	 */
	private Integer targetDeptId;
	/**
	 * @mbggenerated 被投诉人
	 */
	private Integer targetUserId;
	/**
	 * @mbggenerated 被投诉人的档案ID
	 */
	private Integer targetArchiveId;
	/**
	 * @mbggenerated 投诉内容
	 */
	private String complainContent;
	/**
	 * @mbggenerated 投诉类型，admin库CITYHOUSE_COMPLAINT_SETTING的主键ID
	 */
	private Byte complainType;
	/**
	 * @mbggenerated 处理状态，0= 未处理 1=处理成功 2= 处理失败
	 */
	private Byte dealStatus;
	/**
	 * @mbggenerated 处理类型表，YPT_ID
	 */
	private Byte dealType;
	/**
	 * @mbggenerated 处理描述
	 */
	private String dealDesc;
	/**
	 * @mbggenerated 处理时间
	 */
	private Date dealTime;
	/**
	 * @mbggenerated 处理人crm用户
	 */
	private Integer dealCrmUser;
	/**
	 * @mbggenerated 投诉时间
	 */
	private Date complainTime;
	/**
	 * @mbggenerated CRM操作方便
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 房源类型
	 */
	private Byte caseType;
	/**
	 * @mbggenerated 房源编号
	 */
	private String caseNo;
	/**
	 * @mbggenerated 合作类型
	 */
	private Byte cooperationType;
	/**
	 * @mbggenerated 房源ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated 处理方案  1：仅下架 2仅记次数 3下架 退还所有费用 4：仅退还投诉人费用
	 */
	private Byte dealMethod;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getComplaintId() {
		return complaintId;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSharehouseId() {
		return sharehouseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSharehouseId(Integer sharehouseId) {
		this.sharehouseId = sharehouseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCinfoType() {
		return cinfoType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCinfoType(Byte cinfoType) {
		this.cinfoType = cinfoType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSourceCompId() {
		return sourceCompId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceCompId(Integer sourceCompId) {
		this.sourceCompId = sourceCompId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSourceDeptId() {
		return sourceDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceDeptId(Integer sourceDeptId) {
		this.sourceDeptId = sourceDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSourceUserId() {
		return sourceUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceUserId(Integer sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSourceArchiveId() {
		return sourceArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceArchiveId(Integer sourceArchiveId) {
		this.sourceArchiveId = sourceArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetCompId() {
		return targetCompId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetCompId(Integer targetCompId) {
		this.targetCompId = targetCompId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetDeptId() {
		return targetDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetDeptId(Integer targetDeptId) {
		this.targetDeptId = targetDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetUserId() {
		return targetUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetUserId(Integer targetUserId) {
		this.targetUserId = targetUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetArchiveId() {
		return targetArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetArchiveId(Integer targetArchiveId) {
		this.targetArchiveId = targetArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public String getComplainContent() {
		return complainContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent == null ? null : complainContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getComplainType() {
		return complainType;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplainType(Byte complainType) {
		this.complainType = complainType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDealStatus() {
		return dealStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealStatus(Byte dealStatus) {
		this.dealStatus = dealStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDealType() {
		return dealType;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}

	/**
	 * @mbggenerated
	 */
	public String getDealDesc() {
		return dealDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc == null ? null : dealDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getDealTime() {
		return dealTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealCrmUser() {
		return dealCrmUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealCrmUser(Integer dealCrmUser) {
		this.dealCrmUser = dealCrmUser;
	}

	/**
	 * @mbggenerated
	 */
	public Date getComplainTime() {
		return complainTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplainTime(Date complainTime) {
		this.complainTime = complainTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo == null ? null : caseNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCooperationType() {
		return cooperationType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCooperationType(Byte cooperationType) {
		this.cooperationType = cooperationType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getDealMethod() {
		return dealMethod;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealMethod(Byte dealMethod) {
		this.dealMethod = dealMethod;
	}
}