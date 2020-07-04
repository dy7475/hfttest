package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminDenyInfo implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String denyObj;

    /**
     *
     * @mbggenerated
     */
    private Date denyTime;

    /**
     *
     * @mbggenerated
     */
    private String denyResion;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getDenyObj() {
        return denyObj;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDenyObj(String denyObj) {
        this.denyObj = denyObj == null ? null : denyObj.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDenyTime() {
        return denyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDenyTime(Date denyTime) {
        this.denyTime = denyTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDenyResion() {
        return denyResion;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDenyResion(String denyResion) {
        this.denyResion = denyResion == null ? null : denyResion.trim();
    }
}