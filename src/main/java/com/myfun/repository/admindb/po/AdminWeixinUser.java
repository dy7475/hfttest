package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWeixinUser implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer wxId;

    /**
     *
     * @mbggenerated
     */
    private String wxUsername;

    /**
     *
     * @mbggenerated
     */
    private String wxNickname;

    /**
     *
     * @mbggenerated
     */
    private String wxPhoto;

    /**
     *
     * @mbggenerated
     */
    private Byte wxSex;

    /**
     *
     * @mbggenerated
     */
    private String wxProvince;

    /**
     *
     * @mbggenerated
     */
    private String wxCity;

    /**
     *
     * @mbggenerated
     */
    private Integer wxAddTime;

    /**
     *
     * @mbggenerated
     */
    private String wxMobile;

    /**
     *
     * @mbggenerated
     */
    private Byte wxStatus;

    /**
     *
     * @mbggenerated
     */
    private Integer wxLocateCity;

    /**
     *
     * @mbggenerated
     */
    private Byte subscribe;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public String getWxUsername() {
        return wxUsername;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxUsername(String wxUsername) {
        this.wxUsername = wxUsername == null ? null : wxUsername.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxNickname() {
        return wxNickname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname == null ? null : wxNickname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxPhoto() {
        return wxPhoto;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxPhoto(String wxPhoto) {
        this.wxPhoto = wxPhoto == null ? null : wxPhoto.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWxSex() {
        return wxSex;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxSex(Byte wxSex) {
        this.wxSex = wxSex;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxProvince() {
        return wxProvince;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxProvince(String wxProvince) {
        this.wxProvince = wxProvince == null ? null : wxProvince.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxCity() {
        return wxCity;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxCity(String wxCity) {
        this.wxCity = wxCity == null ? null : wxCity.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getWxAddTime() {
        return wxAddTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxAddTime(Integer wxAddTime) {
        this.wxAddTime = wxAddTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWxMobile() {
        return wxMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxMobile(String wxMobile) {
        this.wxMobile = wxMobile == null ? null : wxMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWxStatus() {
        return wxStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxStatus(Byte wxStatus) {
        this.wxStatus = wxStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getWxLocateCity() {
        return wxLocateCity;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWxLocateCity(Integer wxLocateCity) {
        this.wxLocateCity = wxLocateCity;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSubscribe() {
        return subscribe;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSubscribe(Byte subscribe) {
        this.subscribe = subscribe;
    }
}