package com.myfun.repository.reportdb.po;

import java.io.Serializable;
import java.util.Date;

public class ReportFunWageDetail1 implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Long id;
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
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Integer caseType;
	/**
	 * @mbggenerated
	 */
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	private Byte validFlag;
	/**
	 * @mbggenerated
	 */
	private String assessmentMonth;
	/**
	 * @mbggenerated 1:登记 2：楼盘资料转入 3：搜搜转入 4：公转私 5：抢转私 6：转有效
	 */
	private Byte sourceFrom;
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
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
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
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
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
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
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
	public Byte getValidFlag() {
		return validFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setValidFlag(Byte validFlag) {
		this.validFlag = validFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth == null ? null : assessmentMonth.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSourceFrom() {
		return sourceFrom;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceFrom(Byte sourceFrom) {
		this.sourceFrom = sourceFrom;
	}
}