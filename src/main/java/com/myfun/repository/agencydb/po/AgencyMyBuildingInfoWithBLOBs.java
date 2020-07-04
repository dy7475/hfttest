package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyMyBuildingInfoWithBLOBs extends AgencyMyBuildingInfo implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String cooperationRules;

    /**
     *
     * @mbggenerated
     */
    private String sellingPoints;

    /**
     *
     * @mbggenerated
     */
    private String support;

    /**
     *
     * @mbggenerated
     */
    private String talkSkills;

    /**
     *
     * @mbggenerated
     */
    private String targetCustomer;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getCooperationRules() {
        return cooperationRules;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCooperationRules(String cooperationRules) {
        this.cooperationRules = cooperationRules == null ? null : cooperationRules.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSellingPoints() {
        return sellingPoints;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSellingPoints(String sellingPoints) {
        this.sellingPoints = sellingPoints == null ? null : sellingPoints.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSupport() {
        return support;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSupport(String support) {
        this.support = support == null ? null : support.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTalkSkills() {
        return talkSkills;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTalkSkills(String talkSkills) {
        this.talkSkills = talkSkills == null ? null : talkSkills.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTargetCustomer() {
        return targetCustomer;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTargetCustomer(String targetCustomer) {
        this.targetCustomer = targetCustomer == null ? null : targetCustomer.trim();
    }
}