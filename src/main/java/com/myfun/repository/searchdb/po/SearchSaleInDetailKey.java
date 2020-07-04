package com.myfun.repository.searchdb.po;

import java.io.Serializable;

public class SearchSaleInDetailKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Byte provinceId;

    /**
     *
     * @mbggenerated
     */
    private Short cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Byte getProvinceId() {
        return provinceId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProvinceId(Byte provinceId) {
        this.provinceId = provinceId;
    }

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
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }
}