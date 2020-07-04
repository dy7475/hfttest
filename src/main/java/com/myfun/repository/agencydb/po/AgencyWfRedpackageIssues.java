package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfRedpackageIssues implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer issueId;

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
    private Integer wxId;

    /**
     *
     * @mbggenerated
     */
    private String wxOpenId;

    /**
     *
     * @mbggenerated
     */
    private Double amount;

    /**
     *
     * @mbggenerated
     */
    private Integer quantity;

    /**
     *
     * @mbggenerated
     */
    private Double surplusAmount;

    /**
     *
     * @mbggenerated
     */
    private Double surplusQuantity;

    /**
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     *
     * @mbggenerated
     */
    private String sequence;

    /**
     *
     * @mbggenerated
     */
    private String butieSequence;

    /**
     *
     * @mbggenerated
     */
    private Double butieRate;

    /**
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Integer lockVersion;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getIssueId() {
        return issueId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
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
    public Integer getWxId() {
        return wxId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxOpenId() {
        return wxOpenId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId == null ? null : wxOpenId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Double getAmount() {
        return amount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     *
     * @mbggenerated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @mbggenerated
     */
    public Double getSurplusAmount() {
        return surplusAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSurplusAmount(Double surplusAmount) {
        this.surplusAmount = surplusAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public Double getSurplusQuantity() {
        return surplusQuantity;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSurplusQuantity(Double surplusQuantity) {
        this.surplusQuantity = surplusQuantity;
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
    public String getSequence() {
        return sequence;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getButieSequence() {
        return butieSequence;
    }

    /**
     *
     * @mbggenerated
     */
    public void setButieSequence(String butieSequence) {
        this.butieSequence = butieSequence == null ? null : butieSequence.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Double getButieRate() {
        return butieRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setButieRate(Double butieRate) {
        this.butieRate = butieRate;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getLockVersion() {
        return lockVersion;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLockVersion(Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}