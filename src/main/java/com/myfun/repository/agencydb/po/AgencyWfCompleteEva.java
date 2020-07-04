package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfCompleteEva implements Serializable {

	/**
	 * @mbggenerated ID
	 */
	private Integer pushLogId;
	/**
	 * @mbggenerated ΢
	 */
	private Integer wxId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Byte evaStar;
	/**
	 * @mbggenerated
	 */
	private String evaTag;
	/**
	 * @mbggenerated
	 */
	private String evaContent;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	private Byte isVertify;
	/**
	 * @mbggenerated
	 */
	private Date vertifyTime;
	/**
	 * @mbggenerated
	 */
	private Integer operatorId;
	/**
	 * @mbggenerated
	 */
	private Integer showStatus;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getPushLogId() {
		return pushLogId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPushLogId(Integer pushLogId) {
		this.pushLogId = pushLogId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWxId() {
		return wxId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWxId(Integer wxId) {
		this.wxId = wxId;
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
	public Byte getEvaStar() {
		return evaStar;
	}

	/**
	 * @mbggenerated
	 */
	public void setEvaStar(Byte evaStar) {
		this.evaStar = evaStar;
	}

	/**
	 * @mbggenerated
	 */
	public String getEvaTag() {
		return evaTag;
	}

	/**
	 * @mbggenerated
	 */
	public void setEvaTag(String evaTag) {
		this.evaTag = evaTag == null ? null : evaTag.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getEvaContent() {
		return evaContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setEvaContent(String evaContent) {
		this.evaContent = evaContent == null ? null : evaContent.trim();
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
	public Byte getIsVertify() {
		return isVertify;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsVertify(Byte isVertify) {
		this.isVertify = isVertify;
	}

	/**
	 * @mbggenerated
	 */
	public Date getVertifyTime() {
		return vertifyTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setVertifyTime(Date vertifyTime) {
		this.vertifyTime = vertifyTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getOperatorId() {
		return operatorId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getShowStatus() {
		return showStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}
}