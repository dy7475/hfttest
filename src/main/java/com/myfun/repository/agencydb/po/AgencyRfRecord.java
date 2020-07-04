package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyRfRecord implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer recordId;

    /**
     *
     * @mbggenerated
     */
    private Date operateTime;

    /**
     *
     * @mbggenerated
     */
    private String operatePerson;

    /**
     *
     * @mbggenerated
     */
    private String operatingInstructions;

    /**
     *
     * @mbggenerated
     */
    private String operateType;

    /**
     *
     * @mbggenerated
     */
    private Integer applyId;

    /**
     *
     * @mbggenerated
     */
    private Byte followMethod;

    /**
     *
     * @mbggenerated
     */
    private Boolean followRemind;

    /**
     *
     * @mbggenerated
     */
    private Date remindDate;

    /**
     *
     * @mbggenerated
     */
    private String remindContent;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOperatePerson() {
        return operatePerson;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson == null ? null : operatePerson.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getOperatingInstructions() {
        return operatingInstructions;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOperatingInstructions(String operatingInstructions) {
        this.operatingInstructions = operatingInstructions == null ? null : operatingInstructions.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFollowMethod() {
        return followMethod;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFollowMethod(Byte followMethod) {
        this.followMethod = followMethod;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getFollowRemind() {
        return followRemind;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFollowRemind(Boolean followRemind) {
        this.followRemind = followRemind;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getRemindDate() {
        return remindDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }

    /**
     *
     * @mbggenerated
     */
    public String getRemindContent() {
        return remindContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRemindContent(String remindContent) {
        this.remindContent = remindContent == null ? null : remindContent.trim();
    }
}