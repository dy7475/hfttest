package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyFunCustTrack extends AgencyFunCustTrackKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short custSource;

    /**
     *
     * @mbggenerated
     */
    private Integer custId;

    /**
     *
     * @mbggenerated
     */
    private String trackType;

    /**
     *
     * @mbggenerated
     */
    private String trackContent;

    /**
     *
     * @mbggenerated
     */
    private Date trackTime;

    /**
     *
     * @mbggenerated
     */
    private Short trackSource;

    /**
     *
     * @mbggenerated
     */
    private Integer trackUid;

    /**
     *
     * @mbggenerated
     */
    private String trackUname;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Short iswarm;

    /**
     *
     * @mbggenerated
     */
    private String warmContent;

    /**
     *
     * @mbggenerated
     */
    private Date warmTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Short getCustSource() {
        return custSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustSource(Short custSource) {
        this.custSource = custSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTrackType() {
        return trackType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackType(String trackType) {
        this.trackType = trackType == null ? null : trackType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTrackContent() {
        return trackContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackContent(String trackContent) {
        this.trackContent = trackContent == null ? null : trackContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getTrackTime() {
        return trackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackTime(Date trackTime) {
        this.trackTime = trackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getTrackSource() {
        return trackSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackSource(Short trackSource) {
        this.trackSource = trackSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getTrackUid() {
        return trackUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackUid(Integer trackUid) {
        this.trackUid = trackUid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTrackUname() {
        return trackUname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackUname(String trackUname) {
        this.trackUname = trackUname == null ? null : trackUname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getIswarm() {
        return iswarm;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIswarm(Short iswarm) {
        this.iswarm = iswarm;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWarmContent() {
        return warmContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWarmContent(String warmContent) {
        this.warmContent = warmContent == null ? null : warmContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getWarmTime() {
        return warmTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWarmTime(Date warmTime) {
        this.warmTime = warmTime;
    }
}