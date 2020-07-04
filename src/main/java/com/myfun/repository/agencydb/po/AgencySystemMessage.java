package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencySystemMessage implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer msgId;

    /**
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    private String photoAddr;

    /**
     *
     * @mbggenerated
     */
    private String title;

    /**
     *
     * @mbggenerated
     */
    private String msgContent;

    /**
     *
     * @mbggenerated
     */
    private Integer isRead;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Integer msgType;

    /**
     *
     * @mbggenerated
     */
    private String json;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
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

    /**
     *
     * @mbggenerated
     */
    public String getPhotoAddr() {
        return photoAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr == null ? null : photoAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
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
    public Integer getMsgType() {
        return msgType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getJson() {
        return json;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJson(String json) {
        this.json = json == null ? null : json.trim();
    }
}