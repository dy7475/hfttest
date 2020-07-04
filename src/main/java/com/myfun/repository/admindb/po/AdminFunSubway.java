package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunSubway implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer swId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private String swName;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private Byte isopen;

    /**
     *
     * @mbggenerated
     */
    private Byte fstatus;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getSwId() {
        return swId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSwId(Integer swId) {
        this.swId = swId;
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
    public String getSwName() {
        return swName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSwName(String swName) {
        this.swName = swName == null ? null : swName.trim();
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

    /**
     *
     * @mbggenerated
     */
    public Byte getIsopen() {
        return isopen;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsopen(Byte isopen) {
        this.isopen = isopen;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFstatus() {
        return fstatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFstatus(Byte fstatus) {
        this.fstatus = fstatus;
    }
}