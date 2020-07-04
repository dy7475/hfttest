package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminTemplateBuildingInfo implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String cityName;

    /**
     *
     * @mbggenerated
     */
    private String buildName;

    /**
     *
     * @mbggenerated
     */
    private Integer buildId;

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
    public String getBuildName() {
        return buildName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildName(String buildName) {
        this.buildName = buildName == null ? null : buildName.trim();
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