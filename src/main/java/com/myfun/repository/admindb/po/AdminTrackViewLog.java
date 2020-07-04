package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminTrackViewLog implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Integer provinceId;
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
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private Date trackTime;
	/**
	 * @mbggenerated
	 */
	private String fromTable;
	/**
	 * @mbggenerated
	 */
	private String targetType;
	/**
	 * @mbggenerated
	 */
	private Integer fid;
	/**
	 * @mbggenerated
	 */
	private Integer fcityId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

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
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * @mbggenerated
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
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
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackTime(Date trackTime) {
		this.trackTime = trackTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getFromTable() {
		return fromTable;
	}

	/**
	 * @mbggenerated
	 */
	public void setFromTable(String fromTable) {
		this.fromTable = fromTable == null ? null : fromTable.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTargetType() {
		return targetType;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetType(String targetType) {
		this.targetType = targetType == null ? null : targetType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFid() {
		return fid;
	}

	/**
	 * @mbggenerated
	 */
	public void setFid(Integer fid) {
		this.fid = fid;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFcityId() {
		return fcityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setFcityId(Integer fcityId) {
		this.fcityId = fcityId;
	}
}