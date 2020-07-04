package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyBuildActivityTmp implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer actId;

    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
     */
    private String actContent;

    /**
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     *
     * @mbggenerated
     */
    private Byte actStatus;

    /**
     *
     * @mbggenerated
     */
    private Short creatorUid;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Integer examUid;

    /**
     *
     * @mbggenerated
     */
    private Date examTime;

    /**
     *
     * @mbggenerated
     */
    private Byte examFlag;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getActId() {
        return actId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setActId(Integer actId) {
        this.actId = actId;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getActContent() {
        return actContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setActContent(String actContent) {
        this.actContent = actContent == null ? null : actContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getActStatus() {
        return actStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setActStatus(Byte actStatus) {
        this.actStatus = actStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getCreatorUid() {
        return creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorUid(Short creatorUid) {
        this.creatorUid = creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getExamUid() {
        return examUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExamUid(Integer examUid) {
        this.examUid = examUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getExamFlag() {
        return examFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExamFlag(Byte examFlag) {
        this.examFlag = examFlag;
    }
}