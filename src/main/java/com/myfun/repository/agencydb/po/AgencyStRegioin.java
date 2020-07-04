package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyStRegioin implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer regionCode;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getRegionCode() {
        return regionCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    /**
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }
}