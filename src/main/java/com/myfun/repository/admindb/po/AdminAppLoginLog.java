package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminAppLoginLog implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

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
    private String mobileModel;

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
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
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
    public String getMobileModel() {
        return mobileModel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMobileModel(String mobileModel) {
        this.mobileModel = mobileModel == null ? null : mobileModel.trim();
    }
}