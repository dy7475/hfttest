package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopRole implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer pid;

    /**
     *
     * @mbggenerated
     */
    private Integer fcompid;

    /**
     *
     * @mbggenerated
     */
    private Integer fcityid;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     *
     * @mbggenerated
     */
    private String remark;

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
    public Integer getPid() {
        return pid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFcompid() {
        return fcompid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFcompid(Integer fcompid) {
        this.fcompid = fcompid;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFcityid() {
        return fcityid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFcityid(Integer fcityid) {
        this.fcityid = fcityid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
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
}