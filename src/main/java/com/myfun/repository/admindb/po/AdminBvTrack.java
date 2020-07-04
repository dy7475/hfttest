package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminBvTrack implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer trackId;

    /**
     *
     * @mbggenerated
     */
    private Integer bvId;

    /**
     *
     * @mbggenerated
     */
    private String trackDesc;

    /**
     *
     * @mbggenerated
     */
    private String trackContent;

    /**
     *
     * @mbggenerated
     */
    private Integer trackUser;

    /**
     *
     * @mbggenerated
     */
    private Date trackTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getTrackId() {
        return trackId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBvId() {
        return bvId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvId(Integer bvId) {
        this.bvId = bvId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTrackDesc() {
        return trackDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackDesc(String trackDesc) {
        this.trackDesc = trackDesc == null ? null : trackDesc.trim();
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
    public Integer getTrackUser() {
        return trackUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackUser(Integer trackUser) {
        this.trackUser = trackUser;
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
}