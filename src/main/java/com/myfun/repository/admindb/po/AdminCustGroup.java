package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminCustGroup implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer cgId;

    /**
     *
     * @mbggenerated
     */
    private Integer custId;

    /**
     *
     * @mbggenerated
     */
    private String guid;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Byte validFlag;

    /**
     *
     * @mbggenerated
     */
    private Date dueTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCgId() {
        return cgId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCgId(Integer cgId) {
        this.cgId = cgId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getGuid() {
        return guid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
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

    /**
     *
     * @mbggenerated
     */
    public Byte getValidFlag() {
        return validFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setValidFlag(Byte validFlag) {
        this.validFlag = validFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDueTime() {
        return dueTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }
}