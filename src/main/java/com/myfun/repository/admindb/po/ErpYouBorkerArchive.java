package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpYouBorkerArchive implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal youAmount;

    /**
     *
     * @mbggenerated
     */
    private Integer complainCount;

    /**
     *
     * @mbggenerated
     */
    private Integer complainSuccessCount;

    /**
     *
     * @mbggenerated
     */
    private Date limitEndTime;

    /**
     *
     * @mbggenerated
     */
    private Date limitStartTime;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Byte limitFlag;

    /**
     *
     * @mbggenerated
     */
    private Byte youjiaUserProtocol;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getYouAmount() {
        return youAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouAmount(BigDecimal youAmount) {
        this.youAmount = youAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getComplainCount() {
        return complainCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplainCount(Integer complainCount) {
        this.complainCount = complainCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getComplainSuccessCount() {
        return complainSuccessCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplainSuccessCount(Integer complainSuccessCount) {
        this.complainSuccessCount = complainSuccessCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLimitEndTime() {
        return limitEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLimitEndTime(Date limitEndTime) {
        this.limitEndTime = limitEndTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLimitStartTime() {
        return limitStartTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLimitStartTime(Date limitStartTime) {
        this.limitStartTime = limitStartTime;
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
    public Byte getLimitFlag() {
        return limitFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLimitFlag(Byte limitFlag) {
        this.limitFlag = limitFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getYoujiaUserProtocol() {
        return youjiaUserProtocol;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYoujiaUserProtocol(Byte youjiaUserProtocol) {
        this.youjiaUserProtocol = youjiaUserProtocol;
    }
}