package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminBulletCompAd implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer adId;

    /**
     *
     * @mbggenerated
     */
    private String compNo;

    /**
     *
     * @mbggenerated
     */
    private Integer updateUid;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private Integer adStatus;

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
    public Integer getAdId() {
        return adId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCompNo() {
        return compNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompNo(String compNo) {
        this.compNo = compNo == null ? null : compNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getUpdateUid() {
        return updateUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getAdStatus() {
        return adStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdStatus(Integer adStatus) {
        this.adStatus = adStatus;
    }
}