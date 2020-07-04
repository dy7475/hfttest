package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyBorkerComplaint implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer bcId;

    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private String caseType;

    /**
     *
     * @mbggenerated
     */
    private Integer clientId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private String userName;

    /**
     *
     * @mbggenerated
     */
    private String userMobile;

    /**
     *
     * @mbggenerated
     */
    private Byte bcType;

    /**
     *
     * @mbggenerated
     */
    private String bcDesc;

    /**
     *
     * @mbggenerated
     */
    private Date bcTime;

    /**
     *
     * @mbggenerated
     */
    private Byte dealStatus;

    /**
     *
     * @mbggenerated
     */
    private String dealDesc;

    /**
     *
     * @mbggenerated
     */
    private Integer dealUser;

    /**
     *
     * @mbggenerated
     */
    private Date dealTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getBcId() {
        return bcId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBcId(Integer bcId) {
        this.bcId = bcId;
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
    public String getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getBcType() {
        return bcType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBcType(Byte bcType) {
        this.bcType = bcType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBcDesc() {
        return bcDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBcDesc(String bcDesc) {
        this.bcDesc = bcDesc == null ? null : bcDesc.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getBcTime() {
        return bcTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBcTime(Date bcTime) {
        this.bcTime = bcTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDealStatus() {
        return dealStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealStatus(Byte dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDealDesc() {
        return dealDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc == null ? null : dealDesc.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDealUser() {
        return dealUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealUser(Integer dealUser) {
        this.dealUser = dealUser;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}