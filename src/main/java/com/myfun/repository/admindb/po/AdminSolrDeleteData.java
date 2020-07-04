package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminSolrDeleteData implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * @mbggenerated
	 */
	private String tbName;
	/**
	 * @mbggenerated
	 */
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Byte syncFlag;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public String getTbName() {
		return tbName;
	}

	/**
	 * @mbggenerated
	 */
	public void setTbName(String tbName) {
		this.tbName = tbName == null ? null : tbName.trim();
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
	public Byte getSyncFlag() {
		return syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncFlag(Byte syncFlag) {
		this.syncFlag = syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
}