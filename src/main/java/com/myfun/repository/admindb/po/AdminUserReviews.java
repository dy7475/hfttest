package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminUserReviews implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer reviewId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private String reviewContent;

    /**
     *
     * @mbggenerated
     */
    private Date reviewTime;

    /**
     *
     * @mbggenerated
     */
    private String userMobile;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getReviewId() {
        return reviewId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
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
    public String getReviewContent() {
        return reviewContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent == null ? null : reviewContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }
}