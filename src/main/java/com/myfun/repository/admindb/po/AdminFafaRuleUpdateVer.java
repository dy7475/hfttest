package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFafaRuleUpdateVer implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String ruleName;

    /**
     *
     * @mbggenerated
     */
    private Integer ruleVer;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer siteId;

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
    public String getRuleName() {
        return ruleName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRuleVer() {
        return ruleVer;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRuleVer(Integer ruleVer) {
        this.ruleVer = ruleVer;
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