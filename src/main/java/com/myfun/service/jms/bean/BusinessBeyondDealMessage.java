package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

public class BusinessBeyondDealMessage extends MqMessage {

    /** 合同ID **/
   private Integer dealId;
   /** 公司ID **/
   private Integer compId;
   /** 城市ID **/
   private Integer cityId;
   /** 是否提醒 **/
   private Boolean isTrackWarm;
   /** 提醒内容 **/
   private String warmContent;
   /** 提醒时间 **/
   private String warmTime;
   /** 片区ID **/
   private Integer regId;
   /** 大区ID **/
   private Integer areaId;
   /** admin的公司Id **/
   private Integer adminCompId;
   /** admin的门店ID **/
   private Integer adminDeptId;
   /** 公司名字 **/
   private String compName;
   /** 当前登录人的名字 **/
   private String currentOperatorName;
   /** 分成比例，但是用的地方是是否开大区这里需要确认 @TODO **/
   private String commissionReceivable;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Boolean getTrackWarm() {
        return isTrackWarm;
    }

    public void setTrackWarm(Boolean trackWarm) {
        isTrackWarm = trackWarm;
    }

    public String getWarmContent() {
        return warmContent;
    }

    public void setWarmContent(String warmContent) {
        this.warmContent = warmContent;
    }

    public String getWarmTime() {
        return warmTime;
    }

    public void setWarmTime(String warmTime) {
        this.warmTime = warmTime;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAdminCompId() {
        return adminCompId;
    }

    public void setAdminCompId(Integer adminCompId) {
        this.adminCompId = adminCompId;
    }

    public Integer getAdminDeptId() {
        return adminDeptId;
    }

    public void setAdminDeptId(Integer adminDeptId) {
        this.adminDeptId = adminDeptId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCurrentOperatorName() {
        return currentOperatorName;
    }

    public void setCurrentOperatorName(String currentOperatorName) {
        this.currentOperatorName = currentOperatorName;
    }

    public String getCommissionReceivable() {
        return commissionReceivable;
    }

    public void setCommissionReceivable(String commissionReceivable) {
        this.commissionReceivable = commissionReceivable;
    }
}
