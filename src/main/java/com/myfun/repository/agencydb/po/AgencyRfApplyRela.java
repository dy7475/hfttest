package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyRfApplyRela implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer applyId;

    /**
     *
     * @mbggenerated
     */
    private Integer dataId;

    /**
     *
     * @mbggenerated
     */
    private String status;

    /**
     *
     * @mbggenerated
     */
    private String memo;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDataId() {
        return dataId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}