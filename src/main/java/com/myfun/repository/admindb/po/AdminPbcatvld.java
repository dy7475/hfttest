package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminPbcatvld implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String pbvName;

    /**
     *
     * @mbggenerated
     */
    private String pbvVald;

    /**
     *
     * @mbggenerated
     */
    private Short pbvType;

    /**
     *
     * @mbggenerated
     */
    private Integer pbvCntr;

    /**
     *
     * @mbggenerated
     */
    private String pbvMsg;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getPbvName() {
        return pbvName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPbvName(String pbvName) {
        this.pbvName = pbvName == null ? null : pbvName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPbvVald() {
        return pbvVald;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPbvVald(String pbvVald) {
        this.pbvVald = pbvVald == null ? null : pbvVald.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Short getPbvType() {
        return pbvType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPbvType(Short pbvType) {
        this.pbvType = pbvType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPbvCntr() {
        return pbvCntr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPbvCntr(Integer pbvCntr) {
        this.pbvCntr = pbvCntr;
    }

    /**
     *
     * @mbggenerated
     */
    public String getPbvMsg() {
        return pbvMsg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPbvMsg(String pbvMsg) {
        this.pbvMsg = pbvMsg == null ? null : pbvMsg.trim();
    }
}