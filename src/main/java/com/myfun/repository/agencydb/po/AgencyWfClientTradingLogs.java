package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfClientTradingLogs implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer tradingLogId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer wxId;

    /**
     *
     * @mbggenerated
     */
    private String wxNickname;

    /**
     *
     * @mbggenerated
     */
    private String wxUsername;

    /**
     *
     * @mbggenerated
     */
    private String wxMobile;

    /**
     *
     * @mbggenerated
     */
    private String tradingType;

    /**
     *
     * @mbggenerated
     */
    private Double amount;

    /**
     *
     * @mbggenerated
     */
    private String digest;

    /**
     *
     * @mbggenerated
     */
    private String extParam;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getTradingLogId() {
        return tradingLogId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTradingLogId(Integer tradingLogId) {
        this.tradingLogId = tradingLogId;
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
    public String getWxNickname() {
        return wxNickname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname == null ? null : wxNickname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxUsername() {
        return wxUsername;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxUsername(String wxUsername) {
        this.wxUsername = wxUsername == null ? null : wxUsername.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxMobile() {
        return wxMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxMobile(String wxMobile) {
        this.wxMobile = wxMobile == null ? null : wxMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTradingType() {
        return tradingType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTradingType(String tradingType) {
        this.tradingType = tradingType == null ? null : tradingType.trim();
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
    public String getDigest() {
        return digest;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getExtParam() {
        return extParam;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExtParam(String extParam) {
        this.extParam = extParam == null ? null : extParam.trim();
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
}