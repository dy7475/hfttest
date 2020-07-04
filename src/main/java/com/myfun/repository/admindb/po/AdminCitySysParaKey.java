package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminCitySysParaKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private String paramId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
}