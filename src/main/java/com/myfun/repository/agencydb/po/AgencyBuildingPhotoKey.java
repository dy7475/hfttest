package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyBuildingPhotoKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
     */
    private Integer photoId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Short getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

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
}