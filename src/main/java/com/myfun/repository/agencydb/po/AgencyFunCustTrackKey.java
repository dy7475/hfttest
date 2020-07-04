package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyFunCustTrackKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer trackId;

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
    public Integer getTrackId() {
        return trackId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }
}