package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyFunDeptsDistri extends AgencyFunDeptsDistriKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short devloperCityId;

    /**
     *
     * @mbggenerated
     */
    private Integer devloperId;

    /**
     *
     * @mbggenerated
     */
    private Byte distriType;

    /**
     *
     * @mbggenerated
     */
    private Integer currDeptid;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Short getDevloperCityId() {
        return devloperCityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDevloperCityId(Short devloperCityId) {
        this.devloperCityId = devloperCityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDevloperId() {
        return devloperId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDevloperId(Integer devloperId) {
        this.devloperId = devloperId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDistriType() {
        return distriType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDistriType(Byte distriType) {
        this.distriType = distriType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCurrDeptid() {
        return currDeptid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCurrDeptid(Integer currDeptid) {
        this.currDeptid = currDeptid;
    }
}