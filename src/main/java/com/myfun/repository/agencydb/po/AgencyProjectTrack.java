package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyProjectTrack implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer projectId;

    /**
     *
     * @mbggenerated
     */
    private String trackContent;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Integer creatorUid;

    /**
     *
     * @mbggenerated
     */
    private String creatorUname;

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
    public Integer getProjectId() {
        return projectId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
    public Integer getCreatorUid() {
        return creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCreatorUname() {
        return creatorUname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorUname(String creatorUname) {
        this.creatorUname = creatorUname == null ? null : creatorUname.trim();
    }
}