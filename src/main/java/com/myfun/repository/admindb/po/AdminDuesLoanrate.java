package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminDuesLoanrate implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer loanrateId;

    /**
     *
     * @mbggenerated
     */
    private String loanrateDate;

    /**
     *
     * @mbggenerated
     */
    private Double basePublicRate;

    /**
     *
     * @mbggenerated
     */
    private Double baseBusiRate;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getLoanrateId() {
        return loanrateId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoanrateId(Integer loanrateId) {
        this.loanrateId = loanrateId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getLoanrateDate() {
        return loanrateDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoanrateDate(String loanrateDate) {
        this.loanrateDate = loanrateDate;
    }

    /**
     *
     * @mbggenerated
     */
    public Double getBasePublicRate() {
        return basePublicRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBasePublicRate(Double basePublicRate) {
        this.basePublicRate = basePublicRate;
    }

    /**
     *
     * @mbggenerated
     */
    public Double getBaseBusiRate() {
        return baseBusiRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBaseBusiRate(Double baseBusiRate) {
        this.baseBusiRate = baseBusiRate;
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

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }
}