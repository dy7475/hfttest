package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminBan implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer banId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private String banUserName;

    /**
     *
     * @mbggenerated
     */
    private String cause;

    /**
     *
     * @mbggenerated
     */
    private String msg;

    /**
     *
     * @mbggenerated
     */
    private Date beginTime;

    /**
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getBanId() {
        return banId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBanId(Integer banId) {
        this.banId = banId;
    }

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
    public Short getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBanUserName() {
        return banUserName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBanUserName(String banUserName) {
        this.banUserName = banUserName == null ? null : banUserName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCause() {
        return cause;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getType() {
        return type;
    }

    /**
     *
     * @mbggenerated
     */
    public void setType(Byte type) {
        this.type = type;
    }
}