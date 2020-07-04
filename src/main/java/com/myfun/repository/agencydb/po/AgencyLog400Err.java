package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyLog400Err implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer logId;

    /**
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private String logDesc;

    /**
     *
     * @mbggenerated
     */
    private Byte dealFlag;

    /**
     *
     * @mbggenerated
     */
    private Date errTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getType() {
        return type;
    }

    /**
     *
     * @mbggenerated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getLogDesc() {
        return logDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc == null ? null : logDesc.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDealFlag() {
        return dealFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealFlag(Byte dealFlag) {
        this.dealFlag = dealFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getErrTime() {
        return errTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setErrTime(Date errTime) {
        this.errTime = errTime;
    }
}