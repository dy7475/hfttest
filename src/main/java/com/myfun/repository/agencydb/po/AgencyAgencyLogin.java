package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyAgencyLogin implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    private Date loginTime;

    /**
     *
     * @mbggenerated
     */
    private String userMobile;

    /**
     *
     * @mbggenerated
     */
    private String versionName;

    /**
     *
     * @mbggenerated
     */
    private Integer deviceType;

    /**
     *
     * @mbggenerated
     */
    private String pushToken;

    /**
     *
     * @mbggenerated
     */
    private String loginToken;

    /**
     *
     * @mbggenerated
     */
    private Integer loginStatus;

    /**
     *
     * @mbggenerated
     */
    private String simserial;

    /**
     *
     * @mbggenerated
     */
    private Integer isPush;

    /**
     *
     * @mbggenerated
     */
    private Integer distractionFree;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getPushToken() {
        return pushToken;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushToken(String pushToken) {
        this.pushToken = pushToken == null ? null : pushToken.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getLoginToken() {
        return loginToken;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken == null ? null : loginToken.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getLoginStatus() {
        return loginStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSimserial() {
        return simserial;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSimserial(String simserial) {
        this.simserial = simserial == null ? null : simserial.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getIsPush() {
        return isPush;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDistractionFree() {
        return distractionFree;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDistractionFree(Integer distractionFree) {
        this.distractionFree = distractionFree;
    }
}