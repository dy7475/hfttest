package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfPay implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer payId;

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
    private String tradeNo;

    /**
     *
     * @mbggenerated
     */
    private Double totalFee;

    /**
     *
     * @mbggenerated
     */
    private Byte payType;

    /**
     *
     * @mbggenerated
     */
    private Byte payStatus;

    /**
     *
     * @mbggenerated
     */
    private Byte payRefund;

    /**
     *
     * @mbggenerated
     */
    private Date payTime;

    /**
     *
     * @mbggenerated
     */
    private String transactionId;

    /**
     *
     * @mbggenerated
     */
    private Integer pushLogId;

    /**
     *
     * @mbggenerated
     */
    private Integer recomHouseId;

    /**
     *
     * @mbggenerated
     */
    private Integer bonusId;

    /**
     *
     * @mbggenerated
     */
    private Long butieMoney;

    /**
     *
     * @mbggenerated
     */
    private Long returnMoney;

    /**
     *
     * @mbggenerated
     */
    private Long minusMoney;

    /**
     *
     * @mbggenerated
     */
    private Byte redpackageStatus;

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
    public Integer getPayId() {
        return payId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPayId(Integer payId) {
        this.payId = payId;
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
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Double getTotalFee() {
        return totalFee;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPayStatus() {
        return payStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPayRefund() {
        return payRefund;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPayRefund(Byte payRefund) {
        this.payRefund = payRefund;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPushLogId() {
        return pushLogId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushLogId(Integer pushLogId) {
        this.pushLogId = pushLogId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRecomHouseId() {
        return recomHouseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRecomHouseId(Integer recomHouseId) {
        this.recomHouseId = recomHouseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBonusId() {
        return bonusId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getButieMoney() {
        return butieMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setButieMoney(Long butieMoney) {
        this.butieMoney = butieMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getReturnMoney() {
        return returnMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReturnMoney(Long returnMoney) {
        this.returnMoney = returnMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getMinusMoney() {
        return minusMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMinusMoney(Long minusMoney) {
        this.minusMoney = minusMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRedpackageStatus() {
        return redpackageStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRedpackageStatus(Byte redpackageStatus) {
        this.redpackageStatus = redpackageStatus;
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