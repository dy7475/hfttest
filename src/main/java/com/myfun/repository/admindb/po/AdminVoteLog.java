package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminVoteLog implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer logId;

    /**
     *
     * @mbggenerated
     */
    private Integer voteId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Integer bulletId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getVoteId() {
        return voteId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
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
    public Integer getBulletId() {
        return bulletId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBulletId(Integer bulletId) {
        this.bulletId = bulletId;
    }
}