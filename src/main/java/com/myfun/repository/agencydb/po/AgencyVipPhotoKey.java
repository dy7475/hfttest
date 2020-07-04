package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyVipPhotoKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer photoId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getPhotoId() {
        return photoId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
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
}