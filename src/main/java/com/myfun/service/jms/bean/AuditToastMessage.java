package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

public class AuditToastMessage extends MqMessage {

    /** 城市Id **/
    private Integer cityId;
    /** 审核记录Id **/
    private Integer auditId;
    /** 审核排序 **/
    private Integer auditSeq;
    /** 审核状态 **/
    private Integer auditStatus;


    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    public Integer getAuditSeq() {
        return auditSeq;
    }

    public void setAuditSeq(Integer auditSeq) {
        this.auditSeq = auditSeq;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }
}
