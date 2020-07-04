package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunSms implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer smsId;

    /**
     *
     * @mbggenerated
     */
    private Integer bid;

    /**
     *
     * @mbggenerated
     */
    private Integer uaId;

    /**
     *
     * @mbggenerated
     */
    private Integer paidId;

    /**
     *
     * @mbggenerated
     */
    private String receiver;

    /**
     *
     * @mbggenerated
     */
    private String msg;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Byte flag;

    /**
     *
     * @mbggenerated
     */
    private Double totalPrice;

    /**
     *
     * @mbggenerated
     */
    private Date dealTime;

    /**
     *
     * @mbggenerated
     */
    private Integer seq;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getSmsId() {
        return smsId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSmsId(Integer smsId) {
        this.smsId = smsId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBid() {
        return bid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

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
    public Integer getPaidId() {
        return paidId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPaidId(Integer paidId) {
        this.paidId = paidId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
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
    public Byte getFlag() {
        return flag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    /**
     *
     * @mbggenerated
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}