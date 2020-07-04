package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminBulletReplyZan implements Serializable {
    /**
     *
     * @mbggenerated
    主键自增ID
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    城市ID
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    帖子ID
     */
    private Integer bulletId;

    /**
     *
     * @mbggenerated
    回复ID
     */
    private Integer replyId;

    /**
     *
     * @mbggenerated
    赞的时间
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
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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
    public Integer getReplyId() {
        return replyId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
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