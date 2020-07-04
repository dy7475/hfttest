package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminSiteAdvice implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer siteId;

    /**
     *
     * @mbggenerated
     */
    private String siteCity;

    /**
     *
     * @mbggenerated
     */
    private String siteName;

    /**
     *
     * @mbggenerated
     */
    private String siteAddr;

    /**
     *
     * @mbggenerated
     */
    private String adviceInfo;

    /**
     *
     * @mbggenerated
     */
    private String siteUname;

    /**
     *
     * @mbggenerated
     */
    private String siteUpwd;

    /**
     *
     * @mbggenerated
     */
    private Date adviceDate;

    /**
     *
     * @mbggenerated
     */
    private Integer adviceArchiveId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteCity() {
        return siteCity;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteCity(String siteCity) {
        this.siteCity = siteCity == null ? null : siteCity.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteAddr() {
        return siteAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteAddr(String siteAddr) {
        this.siteAddr = siteAddr == null ? null : siteAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAdviceInfo() {
        return adviceInfo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdviceInfo(String adviceInfo) {
        this.adviceInfo = adviceInfo == null ? null : adviceInfo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteUname() {
        return siteUname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteUname(String siteUname) {
        this.siteUname = siteUname == null ? null : siteUname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteUpwd() {
        return siteUpwd;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteUpwd(String siteUpwd) {
        this.siteUpwd = siteUpwd == null ? null : siteUpwd.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAdviceDate() {
        return adviceDate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdviceDate(Date adviceDate) {
        this.adviceDate = adviceDate;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getAdviceArchiveId() {
        return adviceArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdviceArchiveId(Integer adviceArchiveId) {
        this.adviceArchiveId = adviceArchiveId;
    }
}