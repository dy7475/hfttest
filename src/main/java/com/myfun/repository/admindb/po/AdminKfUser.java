package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminKfUser implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer crmUserId;

    /**
     *
     * @mbggenerated
     */
    private String userName;

    /**
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     *
     * @mbggenerated
     */
    private String userPhoto;

    /**
     *
     * @mbggenerated
     */
    private Byte userWriteoff;

    /**
     *
     * @mbggenerated
     */
    private Date writeoffTime;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Date lastLogin;

    /**
     *
     * @mbggenerated
     */
    private String chatPwd;

    /**
     *
     * @mbggenerated
     */
    private String chatToken;

    /**
     *
     * @mbggenerated
     */
    private String chatHost;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCrmUserId() {
        return crmUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCrmUserId(Integer crmUserId) {
        this.crmUserId = crmUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserPhoto() {
        return userPhoto;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getUserWriteoff() {
        return userWriteoff;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserWriteoff(Byte userWriteoff) {
        this.userWriteoff = userWriteoff;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getWriteoffTime() {
        return writeoffTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWriteoffTime(Date writeoffTime) {
        this.writeoffTime = writeoffTime;
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

    /**
     *
     * @mbggenerated
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     *
     * @mbggenerated
     */
    public String getChatPwd() {
        return chatPwd;
    }

    /**
     *
     * @mbggenerated
     */
    public void setChatPwd(String chatPwd) {
        this.chatPwd = chatPwd == null ? null : chatPwd.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getChatToken() {
        return chatToken;
    }

    /**
     *
     * @mbggenerated
     */
    public void setChatToken(String chatToken) {
        this.chatToken = chatToken == null ? null : chatToken.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getChatHost() {
        return chatHost;
    }

    /**
     *
     * @mbggenerated
     */
    public void setChatHost(String chatHost) {
        this.chatHost = chatHost == null ? null : chatHost.trim();
    }
}