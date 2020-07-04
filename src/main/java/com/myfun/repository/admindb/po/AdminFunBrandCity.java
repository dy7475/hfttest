package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunBrandCity extends AdminFunBrandCityKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short seqNo;

    /**
     *
     * @mbggenerated
     */
    private Short onlineFlag;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private Integer brandId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Short getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeqNo(Short seqNo) {
        this.seqNo = seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getOnlineFlag() {
        return onlineFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOnlineFlag(Short onlineFlag) {
        this.onlineFlag = onlineFlag;
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
    public Integer getBrandId() {
        return brandId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}