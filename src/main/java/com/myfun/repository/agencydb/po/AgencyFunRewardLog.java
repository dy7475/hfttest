package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgencyFunRewardLog implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer logId;

    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private Short bCityId;

    /**
     *
     * @mbggenerated
     */
    private Integer custId;

    /**
     *
     * @mbggenerated
     */
    private Integer buildId;

    /**
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal rewards;

    /**
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

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
    public Short getbCityId() {
        return bCityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbCityId(Short bCityId) {
        this.bCityId = bCityId;
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
    public BigDecimal getRewards() {
        return rewards;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRewards(BigDecimal rewards) {
        this.rewards = rewards;
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
}