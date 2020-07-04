package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminLeaveMessage implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer msgId;

    /**
     *
     * @mbggenerated
     */
    private Integer msgType;

    /**
     *
     * @mbggenerated
     */
    private String sendArchiveId;

    /**
     *
     * @mbggenerated
     */
    private String receiveArchiveId;

    /**
     *
     * @mbggenerated
     */
    private Integer sendUserType;

    /**
     *
     * @mbggenerated
     */
    private Integer receiveUserType;

    /**
     *
     * @mbggenerated
     */
    private String msgContent;

    /**
     *
     * @mbggenerated
     */
    private String voicePath;

    /**
     *
     * @mbggenerated
     */
    private Integer sendIsRead;

    /**
     *
     * @mbggenerated
     */
    private Integer receiveIsRead;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

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
    public Integer getSendUserType() {
        return sendUserType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSendUserType(Integer sendUserType) {
        this.sendUserType = sendUserType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getReceiveUserType() {
        return receiveUserType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReceiveUserType(Integer receiveUserType) {
        this.receiveUserType = receiveUserType;
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
    public String getVoicePath() {
        return voicePath;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath == null ? null : voicePath.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSendIsRead() {
        return sendIsRead;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSendIsRead(Integer sendIsRead) {
        this.sendIsRead = sendIsRead;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getReceiveIsRead() {
        return receiveIsRead;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReceiveIsRead(Integer receiveIsRead) {
        this.receiveIsRead = receiveIsRead;
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
}