package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfRefundOrder implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer orderId;

    /**
     *
     * @mbggenerated
     */
    private Integer refundId;

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
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private String transactionId;

    /**
     *
     * @mbggenerated
     */
    private String outTradeNo;

    /**
     *
     * @mbggenerated
     */
    private Long orderMoney;

    /**
     *
     * @mbggenerated
     */
    private Byte orderStatus;

    /**
     *
     * @mbggenerated
     */
    private String refundTransactionId;

    /**
     *
     * @mbggenerated
     */
    private String refundTradeNo;

    /**
     *
     * @mbggenerated
     */
    private String remark;

    /**
     *
     * @mbggenerated
     */
    private Byte refundTimes;

    /**
     *
     * @mbggenerated
     */
    private Date actTime;

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
    public Integer getOrderId() {
        return orderId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRefundId() {
        return refundId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
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
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Long getOrderMoney() {
        return orderMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderMoney(Long orderMoney) {
        this.orderMoney = orderMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getOrderStatus() {
        return orderStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getRefundTransactionId() {
        return refundTransactionId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefundTransactionId(String refundTransactionId) {
        this.refundTransactionId = refundTransactionId == null ? null : refundTransactionId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo == null ? null : refundTradeNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRefundTimes() {
        return refundTimes;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefundTimes(Byte refundTimes) {
        this.refundTimes = refundTimes;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getActTime() {
        return actTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setActTime(Date actTime) {
        this.actTime = actTime;
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