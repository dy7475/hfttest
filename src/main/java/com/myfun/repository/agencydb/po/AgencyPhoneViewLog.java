package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyPhoneViewLog implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer viewId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private String caseType;

    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Integer viewUser;

    /**
     *
     * @mbggenerated
     */
    private Date viewTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getViewId() {
        return viewId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setViewId(Integer viewId) {
        this.viewId = viewId;
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
    public Integer getViewUser() {
        return viewUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setViewUser(Integer viewUser) {
        this.viewUser = viewUser;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getViewTime() {
        return viewTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }
}