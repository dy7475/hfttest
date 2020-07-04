package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyClient400 implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

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
    private Short cityId;

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
    private String userId;

    /**
     *
     * @mbggenerated
     */
    private String bigCode;

    /**
     *
     * @mbggenerated
     */
    private Integer extCode;

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
    private Byte isUsed;

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
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBigCode() {
        return bigCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBigCode(String bigCode) {
        this.bigCode = bigCode == null ? null : bigCode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getExtCode() {
        return extCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExtCode(Integer extCode) {
        this.extCode = extCode;
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

    /**
     *
     * @mbggenerated
     */
    public Byte getIsUsed() {
        return isUsed;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsUsed(Byte isUsed) {
        this.isUsed = isUsed;
    }
}