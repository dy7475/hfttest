package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunCompDel implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private String compNo;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCompNo() {
        return compNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompNo(String compNo) {
        this.compNo = compNo == null ? null : compNo.trim();
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
}