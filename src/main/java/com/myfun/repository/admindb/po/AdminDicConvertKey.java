package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminDicConvertKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer siteId;

    /**
     *
     * @mbggenerated
     */
    private Byte userType;

    /**
     *
     * @mbggenerated
     */
    private Byte saleLease;

    /**
     *
     * @mbggenerated
     */
    private Byte houseUseage;

    /**
     *
     * @mbggenerated
     */
    private Byte urlType;

    /**
     *
     * @mbggenerated
     */
    private String ourField;

    /**
     *
     * @mbggenerated
     */
    private String ourValue;

    /**
     *
     * @mbggenerated
     */
    private String theirValue;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleLease() {
        return saleLease;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLease(Byte saleLease) {
        this.saleLease = saleLease;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getHouseUseage() {
        return houseUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseUseage(Byte houseUseage) {
        this.houseUseage = houseUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getUrlType() {
        return urlType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUrlType(Byte urlType) {
        this.urlType = urlType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOurField() {
        return ourField;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOurField(String ourField) {
        this.ourField = ourField == null ? null : ourField.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getOurValue() {
        return ourValue;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOurValue(String ourValue) {
        this.ourValue = ourValue == null ? null : ourValue.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTheirValue() {
        return theirValue;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTheirValue(String theirValue) {
        this.theirValue = theirValue == null ? null : theirValue.trim();
    }
}