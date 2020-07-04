package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyBuildingComp extends AgencyBuildingCompKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer crmUserId;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private Date dateLimit;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCrmUserId() {
        return crmUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCrmUserId(Integer crmUserId) {
        this.crmUserId = crmUserId;
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
    public Date getDateLimit() {
        return dateLimit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDateLimit(Date dateLimit) {
        this.dateLimit = dateLimit;
    }
}