package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyRfAssessment implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer assessmentId;

    /**
     *
     * @mbggenerated
     */
    private String assessmentName;

    /**
     *
     * @mbggenerated
     */
    private String assessmentMobile;

    /**
     *
     * @mbggenerated
     */
    private String assessmentAddress;

    /**
     *
     * @mbggenerated
     */
    private String assessmentPersonname;

    /**
     *
     * @mbggenerated
     */
    private Boolean assessmentStatus;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getAssessmentId() {
        return assessmentId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAssessmentId(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getAssessmentName() {
        return assessmentName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName == null ? null : assessmentName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAssessmentMobile() {
        return assessmentMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAssessmentMobile(String assessmentMobile) {
        this.assessmentMobile = assessmentMobile == null ? null : assessmentMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAssessmentAddress() {
        return assessmentAddress;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAssessmentAddress(String assessmentAddress) {
        this.assessmentAddress = assessmentAddress == null ? null : assessmentAddress.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAssessmentPersonname() {
        return assessmentPersonname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAssessmentPersonname(String assessmentPersonname) {
        this.assessmentPersonname = assessmentPersonname == null ? null : assessmentPersonname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getAssessmentStatus() {
        return assessmentStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAssessmentStatus(Boolean assessmentStatus) {
        this.assessmentStatus = assessmentStatus;
    }
}