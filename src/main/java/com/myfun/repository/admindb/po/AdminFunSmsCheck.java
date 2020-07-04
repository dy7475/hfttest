package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunSmsCheck implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String custMobile;

    /**
     *
     * @mbggenerated
     */
    private String custCkcode;

    /**
     *
     * @mbggenerated
     */
    private Short checkStatus;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCustMobile() {
        return custMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile == null ? null : custMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCustCkcode() {
        return custCkcode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustCkcode(String custCkcode) {
        this.custCkcode = custCkcode == null ? null : custCkcode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Short getCheckStatus() {
        return checkStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}