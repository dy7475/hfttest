package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminCrmGift implements Serializable {
    /**
     *
     * @mbggenerated
    主键ID
     */
    private Integer crmgiftId;

    /**
     *
     * @mbggenerated
    ADMIN库部门ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    赠送月份
     */
    private Integer giftMonth;

    /**
     *
     * @mbggenerated
    赠送好房币
     */
    private Integer cionAmount;

    /**
     *
     * @mbggenerated
    赠送培训券
     */
    private Integer quanAmount;

    /**
     *
     * @mbggenerated
    申请人
     */
    private Integer reqUid;

    /**
     *
     * @mbggenerated
    申请时间
     */
    private Date reqTime;

    /**
     *
     * @mbggenerated
    赠送原因
     */
    private String reason;

    /**
     *
     * @mbggenerated
    1=通过，0=未通过，-1=未审核 审核结果
     */
    private Integer giftResult;

    /**
     *
     * @mbggenerated
    1金融签单赠送，0直供赠送 赠送方式
     */
    private Byte giftMode;

    /**
     *
     * @mbggenerated
    审核人
     */
    private Integer giftUser;

    /**
     *
     * @mbggenerated
    审核时间
     */
    private Date giftTime;

    /**
     *
     * @mbggenerated
    1 合同赠送和金融签单赠送记录，0 老记录 内容类型
     */
    private Byte recordType;

    /**
     *
     * @mbggenerated
    培训券编号
     */
    private String qrCode;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCrmgiftId() {
        return crmgiftId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCrmgiftId(Integer crmgiftId) {
        this.crmgiftId = crmgiftId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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
    public Integer getGiftMonth() {
        return giftMonth;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGiftMonth(Integer giftMonth) {
        this.giftMonth = giftMonth;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCionAmount() {
        return cionAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCionAmount(Integer cionAmount) {
        this.cionAmount = cionAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getQuanAmount() {
        return quanAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setQuanAmount(Integer quanAmount) {
        this.quanAmount = quanAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getReqUid() {
        return reqUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReqUid(Integer reqUid) {
        this.reqUid = reqUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getReqTime() {
        return reqTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getGiftResult() {
        return giftResult;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGiftResult(Integer giftResult) {
        this.giftResult = giftResult;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getGiftMode() {
        return giftMode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGiftMode(Byte giftMode) {
        this.giftMode = giftMode;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getGiftUser() {
        return giftUser;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGiftUser(Integer giftUser) {
        this.giftUser = giftUser;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getGiftTime() {
        return giftTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGiftTime(Date giftTime) {
        this.giftTime = giftTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRecordType() {
        return recordType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRecordType(Byte recordType) {
        this.recordType = recordType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}