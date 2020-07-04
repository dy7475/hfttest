package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfSmsMsg implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer msgId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     *
     * @mbggenerated
     */
    private String smsMsg;

    /**
     *
     * @mbggenerated
     */
    private Byte wfStatus;

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
    public Integer getMsgId() {
        return msgId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
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
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSmsMsg() {
        return smsMsg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSmsMsg(String smsMsg) {
        this.smsMsg = smsMsg == null ? null : smsMsg.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWfStatus() {
        return wfStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfStatus(Byte wfStatus) {
        this.wfStatus = wfStatus;
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