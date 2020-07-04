package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfRefund implements Serializable {
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
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Double refundMoney;

    /**
     *
     * @mbggenerated
     */
    private Byte refundType;

    /**
     *
     * @mbggenerated
     */
    private Byte refundStatus;

    /**
     *
     * @mbggenerated
     */
    private Integer operator;

    /**
     *
     * @mbggenerated
     */
    private String remark;

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
    public Double getRefundMoney() {
        return refundMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefundMoney(Double refundMoney) {
        this.refundMoney = refundMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRefundType() {
        return refundType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefundType(Byte refundType) {
        this.refundType = refundType;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRefundStatus() {
        return refundStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRefundStatus(Byte refundStatus) {
        this.refundStatus = refundStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getOperator() {
        return operator;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOperator(Integer operator) {
        this.operator = operator;
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