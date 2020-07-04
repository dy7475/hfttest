package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunMsgDraft implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer draftId;

    /**
     *
     * @mbggenerated
     */
    private String draftContent;

    /**
     *
     * @mbggenerated
     */
    private Date draftCreateTime;

    /**
     *
     * @mbggenerated
     */
    private String contactPhone;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Byte msgState;

    /**
     *
     * @mbggenerated
     */
    private Byte sendCount;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getDraftId() {
        return draftId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDraftContent() {
        return draftContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDraftContent(String draftContent) {
        this.draftContent = draftContent == null ? null : draftContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDraftCreateTime() {
        return draftCreateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDraftCreateTime(Date draftCreateTime) {
        this.draftCreateTime = draftCreateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
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
    public Byte getMsgState() {
        return msgState;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMsgState(Byte msgState) {
        this.msgState = msgState;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSendCount() {
        return sendCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSendCount(Byte sendCount) {
        this.sendCount = sendCount;
    }
}