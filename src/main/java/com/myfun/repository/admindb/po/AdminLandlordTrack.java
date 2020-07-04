package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminLandlordTrack implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     *
     * @mbggenerated
     */
    private String trackContent;

    /**
     *
     * @mbggenerated
     */
    private Integer trackUserId;

    /**
     *
     * @mbggenerated
     */
    private String trackUserName;

    /**
     *
     * @mbggenerated
     */
    private Date trackTime;

    /**
     *
     * @mbggenerated
     */
    private String trackType;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
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
    public Integer getTrackUserId() {
        return trackUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackUserId(Integer trackUserId) {
        this.trackUserId = trackUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTrackUserName() {
        return trackUserName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackUserName(String trackUserName) {
        this.trackUserName = trackUserName == null ? null : trackUserName.trim();
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
}