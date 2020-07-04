package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminExitCompApply implements Serializable {

	/**
	 * @mbggenerated 主键自增ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 档案ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 员工ID
	 */
	private Integer userId;
	/**
	 * @mbggenerated 身份证正面照图片地址
	 */
	private String ecardAddr;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 修改时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 审核状态0=未审核,1=已审核,2=审核失败
	 */
	private Integer auditStatus;
	/**
	 * @mbggenerated 审核人
	 */
	private Integer examineId;
	/**
	 * @mbggenerated 审核时间
	 */
	private Date examineTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public String getEcardAddr() {
		return ecardAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setEcardAddr(String ecardAddr) {
		this.ecardAddr = ecardAddr == null ? null : ecardAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getExamineId() {
		return examineId;
	}

	/**
	 * @mbggenerated
	 */
	public void setExamineId(Integer examineId) {
		this.examineId = examineId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getExamineTime() {
		return examineTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setExamineTime(Date examineTime) {
		this.examineTime = examineTime;
	}
}