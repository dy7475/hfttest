package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminArchiveTodayRecord implements Serializable {
    /**
     *
     * @mbggenerated
    主键ID
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    ARCHIVE_ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    1 = 小区专家 2 =房源置顶
     */
    private Integer biddingType;

    /**
     *
     * @mbggenerated
    创建时间
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
    public Integer getBiddingType() {
        return biddingType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBiddingType(Integer biddingType) {
        this.biddingType = biddingType;
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