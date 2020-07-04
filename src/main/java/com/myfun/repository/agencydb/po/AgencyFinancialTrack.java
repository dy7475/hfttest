package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyFinancialTrack implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer trackId;

    /**
     *
     * @mbggenerated
     */
    private Integer detailId;

    /**
     *
     * @mbggenerated
     */
    private String trackContent;

    /**
     *
     * @mbggenerated
     */
    private Integer trackUid;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

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
    public Integer getDetailId() {
        return detailId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
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
}