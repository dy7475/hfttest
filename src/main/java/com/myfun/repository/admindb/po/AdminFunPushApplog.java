package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunPushApplog implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer pushId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer pushSosoid;

    /**
     *
     * @mbggenerated
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    private Date pushTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getPushId() {
        return pushId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushId(Integer pushId) {
        this.pushId = pushId;
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
    public Integer getPushSosoid() {
        return pushSosoid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushSosoid(Integer pushSosoid) {
        this.pushSosoid = pushSosoid;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}