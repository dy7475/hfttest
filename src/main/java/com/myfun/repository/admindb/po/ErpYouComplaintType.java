package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class ErpYouComplaintType implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer yctId;

    /**
     *
     * @mbggenerated
     */
    private String yctName;

    /**
     *
     * @mbggenerated
     */
    private String yctDesc;

    /**
     *
     * @mbggenerated
     */
    private Byte yctOwner;

    /**
     *
     * @mbggenerated
     */
    private Byte delFlag;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getYctId() {
        return yctId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYctId(Integer yctId) {
        this.yctId = yctId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getYctName() {
        return yctName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYctName(String yctName) {
        this.yctName = yctName == null ? null : yctName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getYctDesc() {
        return yctDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYctDesc(String yctDesc) {
        this.yctDesc = yctDesc == null ? null : yctDesc.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getYctOwner() {
        return yctOwner;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYctOwner(Byte yctOwner) {
        this.yctOwner = yctOwner;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}