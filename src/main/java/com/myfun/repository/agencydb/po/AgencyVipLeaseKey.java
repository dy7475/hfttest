package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyVipLeaseKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer leaseId;

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
    public Integer getLeaseId() {
        return leaseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }
}