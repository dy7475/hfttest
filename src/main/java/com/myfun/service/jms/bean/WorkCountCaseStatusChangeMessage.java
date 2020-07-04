package com.myfun.service.jms.bean;




import com.extension.framework.mq.context.MqMessage;

import java.util.Date;

/**
 * @title 工作量消息-状态修改类 包含 修改, 转有效, 状态变更，成交，速销房，注销，取消暂缓，预定，转盘
 * @author lcb
 * @time 2019/9/23 0023
 *
 **/
public class WorkCountCaseStatusChangeMessage extends MqMessage {

    private Integer cityId;
    private Integer caseId;
    private Integer caseType;
    private Integer compId;
    private Integer regId;
    private Integer areaId;
    private Integer deptId;
    private Integer grId = 0;
    private Integer archiveId;
    private Integer userId;
    private Date createTime;
    private Integer countSize;
    private Integer statisticType;
    private String countFieldName;
    private Integer oldHouseStatus;
    private String trackId;
    private Integer caseStatus;
    private Date caseCreateTime;
    private Double dealMoney = 0d;
    private Integer dealId;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Double getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(Double dealMoney) {
        this.dealMoney = dealMoney;
    }

    public Date getCaseCreateTime() {
        return caseCreateTime;
    }

    public void setCaseCreateTime(Date caseCreateTime) {
        this.caseCreateTime = caseCreateTime;
    }

    public Integer getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(Integer caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCountSize() {
        return countSize;
    }

    public void setCountSize(Integer countSize) {
        this.countSize = countSize;
    }

    public Integer getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(Integer statisticType) {
        this.statisticType = statisticType;
    }

    public String getCountFieldName() {
        return countFieldName;
    }

    public void setCountFieldName(String countFieldName) {
        this.countFieldName = countFieldName;
    }

    public Integer getOldHouseStatus() {
        return oldHouseStatus;
    }

    public void setOldHouseStatus(Integer oldHouseStatus) {
        this.oldHouseStatus = oldHouseStatus;
    }
}
