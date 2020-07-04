package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminWeiPushRecord implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer recordId;

    /**
     *
     * @mbggenerated
    openId
     */
    private String openId;

    /**
     *
     * @mbggenerated
     */
    private Date pushTime;

    /**
     *
     * @mbggenerated
     */
    private Integer dealId;

    /**
     *
     * @mbggenerated
    1:成功 0:失败
     */
    private Byte pushStatus;

    /**
     *
     * @mbggenerated
     */
    private String pushContent;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
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
    public Integer getDealId() {
        return dealId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPushStatus() {
        return pushStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPushStatus(Byte pushStatus) {
        this.pushStatus = pushStatus;
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
}