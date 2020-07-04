package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunMsg implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer msgId;

    /**
     *
     * @mbggenerated
     */
    private String msgContent;

    /**
     *
     * @mbggenerated
     */
    private Short msglistId;

    /**
     *
     * @mbggenerated
     */
    private Short msgLength;

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
    public Short getMsglistId() {
        return msglistId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsglistId(Short msglistId) {
        this.msglistId = msglistId;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getMsgLength() {
        return msgLength;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsgLength(Short msgLength) {
        this.msgLength = msgLength;
    }
}