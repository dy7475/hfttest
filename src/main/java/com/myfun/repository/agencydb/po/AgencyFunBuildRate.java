package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class AgencyFunBuildRate extends AgencyFunBuildRateKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String buildUseage;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal commRate;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal agencyRate;

    /**
     *
     * @mbggenerated
     */
    private String rateDesc;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getBuildUseage() {
        return buildUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildUseage(String buildUseage) {
        this.buildUseage = buildUseage == null ? null : buildUseage.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getCommRate() {
        return commRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCommRate(BigDecimal commRate) {
        this.commRate = commRate;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getAgencyRate() {
        return agencyRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAgencyRate(BigDecimal agencyRate) {
        this.agencyRate = agencyRate;
    }

    /**
     *
     * @mbggenerated
     */
    public String getRateDesc() {
        return rateDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc == null ? null : rateDesc.trim();
    }
}