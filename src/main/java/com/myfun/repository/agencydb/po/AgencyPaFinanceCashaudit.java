package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgencyPaFinanceCashaudit implements Serializable {
    /**
     *
     * @mbggenerated
    提现审核ID，自增
     */
    private Integer cashId;

    /**
     *
     * @mbggenerated
    金融Id
     */
    private Integer financeId;

    /**
     *
     * @mbggenerated
    返佣金额，单位:元（同PA_FINANCE中RAKEBACK_PRICE）
     */
    private BigDecimal cashPrice;

    /**
     *
     * @mbggenerated
    审核状态[0默认，1审核通过，2审核失败，3已打款]
     */
    private Byte auditStatus;

    /**
     *
     * @mbggenerated
    审核原因
     */
    private String auditReason;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    审核人CRM用户ID
     */
    private Integer auditUid;

    /**
     *
     * @mbggenerated
    CRM后台人工审核提现成功的时间
     */
    private Date cashDate;

    /**
     *
     * @mbggenerated
    0：个人提现审核记录、1：公司提现审核记录
     */
    private Byte cashType;

    /**
     *
     * @mbggenerated
    提现经纪人人的档案ID
     */
    private Integer cashArchiveId;

    /**
     *
     * @mbggenerated
    提现反馈的对方交易号
     */
    private String tradeNo;

    /**
     *
     * @mbggenerated
    提现后对方反馈的交易时间
     */
    private Date payTime;

    /**
     *
     * @mbggenerated
    提现方式 银行卡(1) 或者 微信(2) 
     */
    private Byte cashMode;

    /**
     *
     * @mbggenerated
     */
    private Integer accountId;

    /**
     *
     * @mbggenerated
    费、税（单位：元）
     */
    private BigDecimal taxesMoney;

    /**
     *
     * @mbggenerated
    税后佣金（元）
     */
    private BigDecimal rakebackPrice;

    /**
     *
     * @mbggenerated
     */
    private String des;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCashId() {
        return cashId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCashId(Integer cashId) {
        this.cashId = cashId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFinanceId() {
        return financeId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getCashPrice() {
        return cashPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCashPrice(BigDecimal cashPrice) {
        this.cashPrice = cashPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getAuditStatus() {
        return auditStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getAuditReason() {
        return auditReason;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason == null ? null : auditReason.trim();
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
    public Integer getAuditUid() {
        return auditUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAuditUid(Integer auditUid) {
        this.auditUid = auditUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCashDate() {
        return cashDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCashDate(Date cashDate) {
        this.cashDate = cashDate;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCashType() {
        return cashType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCashType(Byte cashType) {
        this.cashType = cashType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCashArchiveId() {
        return cashArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCashArchiveId(Integer cashArchiveId) {
        this.cashArchiveId = cashArchiveId;
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
    public Byte getCashMode() {
        return cashMode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCashMode(Byte cashMode) {
        this.cashMode = cashMode;
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
    public BigDecimal getTaxesMoney() {
        return taxesMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaxesMoney(BigDecimal taxesMoney) {
        this.taxesMoney = taxesMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getRakebackPrice() {
        return rakebackPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRakebackPrice(BigDecimal rakebackPrice) {
        this.rakebackPrice = rakebackPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDes() {
        return des;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
}