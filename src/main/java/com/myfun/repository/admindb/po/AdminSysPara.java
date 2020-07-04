package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminSysPara implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String paramId;

    /**
     *
     * @mbggenerated
     */
    private String paramValue;

    /**
     *
     * @mbggenerated
     */
    private String paramType;

    /**
     *
     * @mbggenerated
     */
    private String paramProfiles;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getParamId() {
        return paramId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setParamId(String paramId) {
        this.paramId = paramId == null ? null : paramId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     *
     * @mbggenerated
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getParamType() {
        return paramType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getParamProfiles() {
        return paramProfiles;
    }

    /**
     *
     * @mbggenerated
     */
    public void setParamProfiles(String paramProfiles) {
        this.paramProfiles = paramProfiles == null ? null : paramProfiles.trim();
    }
}