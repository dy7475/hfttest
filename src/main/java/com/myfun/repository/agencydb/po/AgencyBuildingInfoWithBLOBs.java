package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyBuildingInfoWithBLOBs extends AgencyBuildingInfo implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String agencyIntro;

    /**
     *
     * @mbggenerated
     */
    private String agencyAtt;

    /**
     *
     * @mbggenerated
     */
    private String agencyKnow;

    /**
     *
     * @mbggenerated
     */
    private String buildAgencydetail;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getAgencyIntro() {
        return agencyIntro;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAgencyIntro(String agencyIntro) {
        this.agencyIntro = agencyIntro == null ? null : agencyIntro.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAgencyAtt() {
        return agencyAtt;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAgencyAtt(String agencyAtt) {
        this.agencyAtt = agencyAtt == null ? null : agencyAtt.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAgencyKnow() {
        return agencyKnow;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAgencyKnow(String agencyKnow) {
        this.agencyKnow = agencyKnow == null ? null : agencyKnow.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBuildAgencydetail() {
        return buildAgencydetail;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBuildAgencydetail(String buildAgencydetail) {
        this.buildAgencydetail = buildAgencydetail == null ? null : buildAgencydetail.trim();
    }
}