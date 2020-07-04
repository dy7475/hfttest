package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminSosoPhones implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer spId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    private String phone;

    /**
     *
     * @mbggenerated
     */
    private String owner;

    /**
     *
     * @mbggenerated
     */
    private Byte sex;

    /**
     *
     * @mbggenerated
     */
    private Byte callFlag;

    /**
     *
     * @mbggenerated
     */
    private Integer crmUser;

    /**
     *
     * @mbggenerated
     */
    private Date callTime;

    /**
     *
     * @mbggenerated
     */
    private Byte phoneSource;

    /**
     *
     * @mbggenerated
     */
    private Date inTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getSpId() {
        return spId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSpId(Integer spId) {
        this.spId = spId;
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
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getOwner() {
        return owner;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSex() {
        return sex;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCallFlag() {
        return callFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCallFlag(Byte callFlag) {
        this.callFlag = callFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCrmUser() {
        return crmUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCrmUser(Integer crmUser) {
        this.crmUser = crmUser;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCallTime() {
        return callTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPhoneSource() {
        return phoneSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhoneSource(Byte phoneSource) {
        this.phoneSource = phoneSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }
}