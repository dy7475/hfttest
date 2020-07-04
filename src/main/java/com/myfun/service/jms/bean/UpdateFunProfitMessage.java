package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

public class UpdateFunProfitMessage extends MqMessage {

    /** 城市ID **/
    private Integer cityId;
    /** ERP的compId **/
    private Integer compId;
    /** 合同ID **/
    private Integer dealId;
    /** 业绩ID **/
    private String  pfIds;
    /** 处理类型 **/
    private Integer dealOpType;
    /** 房源Id **/
    private Integer caseId;
    /** 类型 **/
    private Byte caseType;
    /** 签约人Id **/
    private Integer signUserId;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Integer getSignUserId() {
        return signUserId;
    }

    public void setSignUserId(Integer signUserId) {
        this.signUserId = signUserId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getPfIds() {
        return pfIds;
    }

    public void setPfIds(String pfIds) {
        this.pfIds = pfIds;
    }

    public Integer getDealOpType() {
        return dealOpType;
    }

    public void setDealOpType(Integer dealOpType) {
        this.dealOpType = dealOpType;
    }
}
