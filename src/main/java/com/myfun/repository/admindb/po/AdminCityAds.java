package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminCityAds implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer adId;

    /**
     *
     * @mbggenerated
     */
    private String cityName;

    /**
     *
     * @mbggenerated
     */
    private Date adLimit;

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
    public String getCityName() {
        return cityName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAdLimit() {
        return adLimit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdLimit(Date adLimit) {
        this.adLimit = adLimit;
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
}