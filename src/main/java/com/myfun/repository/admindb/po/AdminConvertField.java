package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminConvertField extends AdminConvertFieldKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private String treatWay;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public String getTreatWay() {
        return treatWay;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTreatWay(String treatWay) {
        this.treatWay = treatWay == null ? null : treatWay.trim();
    }
}