package com.myfun.service.business.admindb.bean.param;

import java.util.Date;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class CityshareBorkerComplaintParam extends AbstractEncryParam implements DaoBaseParam{

	/**
	 * SEQ序列，自增序列
	 */
	private Integer complaintId;
	/**
	 * 关联的分享表ID
	 */
	private Integer sharehouseId;
	/**
	 * 投诉来源，0=房源购买方 1=房源分享方
	 */
	private Byte cinfoType;
	/**
	 * 投诉人公司
	 */
	private Integer sourceCompId;
	/**
	 * 投诉人门店
	 */
	private Integer sourceDeptId;
	/**
	 * 投诉人
	 */
	private Integer sourceUserId;
	/**
	 * 投诉人的档案ID
	 */
	private Integer sourceArchiveId;
	/**
	 * 被投诉人公司
	 */
	private Integer targetCompId;
	/**
	 * 被投诉人门店
	 */
	private Integer targetDeptId;
	/**
	 * 被投诉人
	 */
	private Integer targetUserId;
	/**
	 * 被投诉人的档案ID
	 */
	private Integer targetArchiveId;
	/**
	 * 投诉内容
	 */
	private String complainContent;
	/**
	 * 投诉类型，admin库CITYHOUSE_COMPLAINT_SETTING的主键ID
	 */
	private Byte complainType;
	/**
	 * 处理状态，0= 未处理 1=处理成功 2= 处理失败
	 */
	private Byte dealStatus;
	/**
	 * 处理类型表，YPT_ID
	 */
	private Byte dealType;
	/**
	 * 处理描述
	 */
	private String dealDesc;
	/**
	 * 处理时间
	 */
	private Date dealTime;
	/**
	 * 处理人crm用户
	 */
	private Integer dealCrmUser;
	/**
	 * 投诉时间
	 */
	private Date complainTime;
	/**
	 * CRM操作方便
	 */
	private Integer cityId;
	/**
	 * 房源类型
	 */
	private Byte caseType;
	/**
	 * 房源编号
	 */
	private String caseNo;
	/**
	 * 合作类型
	 */
	private Byte cooperationType;
	/**
	 * 房源ID
	 */
	private Integer caseId;
	/**
	 * 处理方案  1：仅下架 2仅记次数 3下架 退还所有费用 4：仅退还投诉人费用
	 */
	private Byte dealMethod;
	/**
	 * 投诉关联的语音日志ID
	 */
	private String logIds;
	public Integer getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}
	public Integer getSharehouseId() {
		return sharehouseId;
	}
	public void setSharehouseId(Integer sharehouseId) {
		this.sharehouseId = sharehouseId;
	}
	public Byte getCinfoType() {
		return cinfoType;
	}
	public void setCinfoType(Byte cinfoType) {
		this.cinfoType = cinfoType;
	}
	public Integer getSourceCompId() {
		return sourceCompId;
	}
	public void setSourceCompId(Integer sourceCompId) {
		this.sourceCompId = sourceCompId;
	}
	public Integer getSourceDeptId() {
		return sourceDeptId;
	}
	public void setSourceDeptId(Integer sourceDeptId) {
		this.sourceDeptId = sourceDeptId;
	}
	public Integer getSourceUserId() {
		return sourceUserId;
	}
	public void setSourceUserId(Integer sourceUserId) {
		this.sourceUserId = sourceUserId;
	}
	public Integer getSourceArchiveId() {
		return sourceArchiveId;
	}
	public void setSourceArchiveId(Integer sourceArchiveId) {
		this.sourceArchiveId = sourceArchiveId;
	}
	public Integer getTargetCompId() {
		return targetCompId;
	}
	public void setTargetCompId(Integer targetCompId) {
		this.targetCompId = targetCompId;
	}
	public Integer getTargetDeptId() {
		return targetDeptId;
	}
	public void setTargetDeptId(Integer targetDeptId) {
		this.targetDeptId = targetDeptId;
	}
	public Integer getTargetUserId() {
		return targetUserId;
	}
	public void setTargetUserId(Integer targetUserId) {
		this.targetUserId = targetUserId;
	}
	public Integer getTargetArchiveId() {
		return targetArchiveId;
	}
	public void setTargetArchiveId(Integer targetArchiveId) {
		this.targetArchiveId = targetArchiveId;
	}
	public String getComplainContent() {
		return complainContent;
	}
	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}
	public Byte getComplainType() {
		return complainType;
	}
	public void setComplainType(Byte complainType) {
		this.complainType = complainType;
	}
	public Byte getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(Byte dealStatus) {
		this.dealStatus = dealStatus;
	}
	public Byte getDealType() {
		return dealType;
	}
	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}
	public String getDealDesc() {
		return dealDesc;
	}
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}
	public Date getDealTime() {
		return dealTime;
	}
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	public Integer getDealCrmUser() {
		return dealCrmUser;
	}
	public void setDealCrmUser(Integer dealCrmUser) {
		this.dealCrmUser = dealCrmUser;
	}
	public Date getComplainTime() {
		return complainTime;
	}
	public void setComplainTime(Date complainTime) {
		this.complainTime = complainTime;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Byte getCaseType() {
		return caseType;
	}
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public Byte getCooperationType() {
		return cooperationType;
	}
	public void setCooperationType(Byte cooperationType) {
		this.cooperationType = cooperationType;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Byte getDealMethod() {
		return dealMethod;
	}
	public void setDealMethod(Byte dealMethod) {
		this.dealMethod = dealMethod;
	}
	public String getLogIds() {
		return logIds;
	}
	public void setLogIds(String logIds) {
		this.logIds = logIds;
	}
	
}
