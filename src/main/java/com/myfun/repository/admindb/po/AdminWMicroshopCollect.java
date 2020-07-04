package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopCollect implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     *
     * @mbggenerated
     */
    private Integer fcityid;

    /**
     *
     * @mbggenerated
     */
    private String caseType;

    /**
     *
     * @mbggenerated
     */
    private Integer fcompid;

    /**
     *
     * @mbggenerated
     */
    private String fcreatetime;

    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private String weixinid;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
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
    public String getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
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
    public String getFcreatetime() {
        return fcreatetime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFcreatetime(String fcreatetime) {
        this.fcreatetime = fcreatetime == null ? null : fcreatetime.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWeixinid() {
        return weixinid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid == null ? null : weixinid.trim();
    }
}