package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunCompJoin implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String mainCompNo;

    /**
     *
     * @mbggenerated
     */
    private String subCompNo;

    /**
     *
     * @mbggenerated
     */
    private Integer flag;

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
    public String getMainCompNo() {
        return mainCompNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMainCompNo(String mainCompNo) {
        this.mainCompNo = mainCompNo == null ? null : mainCompNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSubCompNo() {
        return subCompNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSubCompNo(String subCompNo) {
        this.subCompNo = subCompNo == null ? null : subCompNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
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
}