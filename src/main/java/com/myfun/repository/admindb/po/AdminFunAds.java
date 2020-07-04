package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunAds implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer adId;

    /**
     *
     * @mbggenerated
     */
    private String adType;

    /**
     *
     * @mbggenerated
     */
    private String adName;

    /**
     *
     * @mbggenerated
     */
    private String adAddr;

    /**
     *
     * @mbggenerated
     */
    private String adLink;

    /**
     *
     * @mbggenerated
     */
    private String adMd5;

    /**
     *
     * @mbggenerated
     */
    private Byte adDefault;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getAdId() {
        return adId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getAdType() {
        return adType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdType(String adType) {
        this.adType = adType == null ? null : adType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAdName() {
        return adName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAdAddr() {
        return adAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdAddr(String adAddr) {
        this.adAddr = adAddr == null ? null : adAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAdLink() {
        return adLink;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdLink(String adLink) {
        this.adLink = adLink == null ? null : adLink.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAdMd5() {
        return adMd5;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdMd5(String adMd5) {
        this.adMd5 = adMd5 == null ? null : adMd5.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getAdDefault() {
        return adDefault;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAdDefault(Byte adDefault) {
        this.adDefault = adDefault;
    }
}