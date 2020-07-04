package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminMsgPush implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

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
    private Integer isPush;

    /**
     *
     * @mbggenerated
     */
    private String pushTitle;

    /**
     *
     * @mbggenerated
     */
    private String pushContent;

    /**
     *
     * @mbggenerated
     */
    private String pushJson;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Date pushTime;

    /**
     *
     * @mbggenerated
     */
    private String receiveArchiveId;

    /**
     *
     * @mbggenerated
     */
    private String sendArchiveId;

    /**
     *
     * @mbggenerated
     */
    private Integer pushLevel;

    /**
     *
     * @mbggenerated
     */
    private Byte userType;

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
    public String getPushTitle() {
        return pushTitle;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle == null ? null : pushTitle.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPushContent() {
        return pushContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushContent(String pushContent) {
        this.pushContent = pushContent == null ? null : pushContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPushJson() {
        return pushJson;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushJson(String pushJson) {
        this.pushJson = pushJson == null ? null : pushJson.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getPushTime() {
        return pushTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getReceiveArchiveId() {
        return receiveArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReceiveArchiveId(String receiveArchiveId) {
        this.receiveArchiveId = receiveArchiveId == null ? null : receiveArchiveId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSendArchiveId() {
        return sendArchiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSendArchiveId(String sendArchiveId) {
        this.sendArchiveId = sendArchiveId == null ? null : sendArchiveId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPushLevel() {
        return pushLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushLevel(Integer pushLevel) {
        this.pushLevel = pushLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }
}