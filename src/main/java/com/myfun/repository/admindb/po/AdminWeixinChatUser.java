package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWeixinChatUser implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer userChatId;

    /**
     *
     * @mbggenerated
     */
    private String userChatName;

    /**
     *
     * @mbggenerated
     */
    private String userChatPwd;

    /**
     *
     * @mbggenerated
     */
    private String userChatToken;

    /**
     *
     * @mbggenerated
     */
    private String userChatHost;

    /**
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getUserChatId() {
        return userChatId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserChatId(Integer userChatId) {
        this.userChatId = userChatId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserChatName() {
        return userChatName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserChatName(String userChatName) {
        this.userChatName = userChatName == null ? null : userChatName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserChatPwd() {
        return userChatPwd;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserChatPwd(String userChatPwd) {
        this.userChatPwd = userChatPwd == null ? null : userChatPwd.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserChatToken() {
        return userChatToken;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserChatToken(String userChatToken) {
        this.userChatToken = userChatToken == null ? null : userChatToken.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserChatHost() {
        return userChatHost;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserChatHost(String userChatHost) {
        this.userChatHost = userChatHost == null ? null : userChatHost.trim();
    }

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
}