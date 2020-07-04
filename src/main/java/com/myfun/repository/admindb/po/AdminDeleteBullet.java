package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminDeleteBullet implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer delId;

    /**
     *
     * @mbggenerated
     */
    private Integer bulletId;

    /**
     *
     * @mbggenerated
     */
    private String dbId;

    /**
     *
     * @mbggenerated
     */
    private Date deleteTime;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getDelId() {
        return delId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDelId(Integer delId) {
        this.delId = delId;
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

    /**
     *
     * @mbggenerated
     */
    public String getDbId() {
        return dbId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDbId(String dbId) {
        this.dbId = dbId == null ? null : dbId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
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
}