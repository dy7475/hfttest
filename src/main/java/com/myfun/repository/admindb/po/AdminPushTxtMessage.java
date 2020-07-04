package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminPushTxtMessage implements Serializable {
    /**
     *
     * @mbggenerated
    主键自增
     */
    private Integer msgId;

    /**
     *
     * @mbggenerated
    是否推送 1：是 0：否
     */
    private Byte isPush;

    /**
     *
     * @mbggenerated
    档案id
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    推送内容
     */
    private String msgContent;

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
    public Byte getIsPush() {
        return isPush;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsPush(Byte isPush) {
        this.isPush = isPush;
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
}