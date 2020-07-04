package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfFitment implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer wxId;

    /**
     *
     * @mbggenerated
     */
    private Integer provinceId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     *
     * @mbggenerated
     */
    private Short area;

    /**
     *
     * @mbggenerated
     */
    private String price;

    /**
     *
     * @mbggenerated
     */
    private Byte wfStatus;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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

    /**
     *
     * @mbggenerated
     */
    public Integer getWxId() {
        return wxId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
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
    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Short getArea() {
        return area;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArea(Short area) {
        this.area = area;
    }

    /**
     *
     * @mbggenerated
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWfStatus() {
        return wfStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfStatus(Byte wfStatus) {
        this.wfStatus = wfStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}