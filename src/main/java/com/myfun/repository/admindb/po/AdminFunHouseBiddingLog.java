package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminFunHouseBiddingLog implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer biddLogId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer houseId;

    /**
     *
     * @mbggenerated
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
     */
    private String houseUseage;

    /**
     *
     * @mbggenerated
     */
    private String saleLease;

    /**
     *
     * @mbggenerated
     */
    private Date biddingSuccTime;

    /**
     *
     * @mbggenerated
     */
    private Date biddingEndTime;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal biddingPrice;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Integer fBiddId;

    /**
     *
     * @mbggenerated
     */
    private Integer logStatus;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getBiddLogId() {
        return biddLogId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBiddLogId(Integer biddLogId) {
        this.biddLogId = biddLogId;
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
    public Integer getHouseId() {
        return houseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getHouseUseage() {
        return houseUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseUseage(String houseUseage) {
        this.houseUseage = houseUseage == null ? null : houseUseage.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSaleLease() {
        return saleLease;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLease(String saleLease) {
        this.saleLease = saleLease == null ? null : saleLease.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getBiddingSuccTime() {
        return biddingSuccTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBiddingSuccTime(Date biddingSuccTime) {
        this.biddingSuccTime = biddingSuccTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getBiddingEndTime() {
        return biddingEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBiddingEndTime(Date biddingEndTime) {
        this.biddingEndTime = biddingEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getBiddingPrice() {
        return biddingPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBiddingPrice(BigDecimal biddingPrice) {
        this.biddingPrice = biddingPrice;
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
    public Integer getfBiddId() {
        return fBiddId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setfBiddId(Integer fBiddId) {
        this.fBiddId = fBiddId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getLogStatus() {
        return logStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }
}