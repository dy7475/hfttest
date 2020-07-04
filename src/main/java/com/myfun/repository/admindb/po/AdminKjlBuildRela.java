package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminKjlBuildRela implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer kjlCityId;

    /**
     *
     * @mbggenerated
     */
    private String kjlBuildName;

    /**
     *
     * @mbggenerated
     */
    private String cityName;

    /**
     *
     * @mbggenerated
     */
    private Integer myCityId;

    /**
     *
     * @mbggenerated
     */
    private Integer myBuildId;

    /**
     *
     * @mbggenerated
     */
    private String myBuildName;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getKjlCityId() {
        return kjlCityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setKjlCityId(Integer kjlCityId) {
        this.kjlCityId = kjlCityId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getKjlBuildName() {
        return kjlBuildName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setKjlBuildName(String kjlBuildName) {
        this.kjlBuildName = kjlBuildName == null ? null : kjlBuildName.trim();
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
    public Integer getMyCityId() {
        return myCityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMyCityId(Integer myCityId) {
        this.myCityId = myCityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getMyBuildId() {
        return myBuildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMyBuildId(Integer myBuildId) {
        this.myBuildId = myBuildId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMyBuildName() {
        return myBuildName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMyBuildName(String myBuildName) {
        this.myBuildName = myBuildName == null ? null : myBuildName.trim();
    }
}