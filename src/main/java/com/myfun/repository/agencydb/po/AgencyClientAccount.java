package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class AgencyClientAccount implements Serializable {
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
    private BigDecimal amount;

    /**
     *
     * @mbggenerated
     */
    private String dealPwd;

    /**
     *
     * @mbggenerated
     */
    private String pwdProtect;

    /**
     *
     * @mbggenerated
     */
    private String protectAnswer;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDealPwd() {
        return dealPwd;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealPwd(String dealPwd) {
        this.dealPwd = dealPwd == null ? null : dealPwd.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPwdProtect() {
        return pwdProtect;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPwdProtect(String pwdProtect) {
        this.pwdProtect = pwdProtect == null ? null : pwdProtect.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getProtectAnswer() {
        return protectAnswer;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProtectAnswer(String protectAnswer) {
        this.protectAnswer = protectAnswer == null ? null : protectAnswer.trim();
    }
}