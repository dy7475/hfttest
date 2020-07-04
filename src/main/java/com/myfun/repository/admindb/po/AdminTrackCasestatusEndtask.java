package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminTrackCasestatusEndtask implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	private Byte trackType;
	/**
	 * @mbggenerated
	 */
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private Date targetEndTime;
	/**
	 * @mbggenerated
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private Byte result;
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
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getTrackType() {
		return trackType;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackType(Byte trackType) {
		this.trackType = trackType;
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
	public Date getTargetEndTime() {
		return targetEndTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetEndTime(Date targetEndTime) {
		this.targetEndTime = targetEndTime;
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
	public Byte getResult() {
		return result;
	}

	/**
	 * @mbggenerated
	 */
	public void setResult(Byte result) {
		this.result = result;
	}
}