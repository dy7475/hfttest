package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgencyFunAgencyAccount implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer uaId;

    /**
     *
     * @mbggenerated
     */
    private Integer accountId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Byte uaType;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal agencyAmount;

    /**
     *
     * @mbggenerated
     */
    private Date signTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getUaId() {
        return uaId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUaId(Integer uaId) {
        this.uaId = uaId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
    public Byte getUaType() {
        return uaType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUaType(Byte uaType) {
        this.uaType = uaType;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getAgencyAmount() {
        return agencyAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAgencyAmount(BigDecimal agencyAmount) {
        this.agencyAmount = agencyAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }
}