package com.myfun.erpWeb.managecenter.houseComplain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class HouseComplainListVo {

    //类别，状态，房源，投诉原因，投诉人，发起时间，处理人，处理时间
    @ApiModelProperty(value = "审核id")
    private Integer auditId;
    @ApiModelProperty(value = "房源id")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型")
    private Integer caseType;
    @ApiModelProperty(value = "审核状态")
    private Integer auditStatus;
    @ApiModelProperty(value = "投诉类型")
    private Integer houseComplainType;
    @ApiModelProperty(value = "投诉理由")
    private String complainReason;
    @ApiModelProperty(value = "房屋信息")
    private String houseInfo;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "处理时间")
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date dealTime;
    @ApiModelProperty(value = "创建人")
    private Integer createUserId;
    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;
    @ApiModelProperty(value = "处理人Id")
    private Integer dealUserId;
    @ApiModelProperty(value = "处理人")
    private String dealUserName;

    public Integer getAuditId() {
        return auditId;
    }

    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
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

    public Integer getHouseComplainType() {
        return houseComplainType;
    }

    public void setHouseComplainType(Integer houseComplainType) {
        this.houseComplainType = houseComplainType;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    public String getComplainReason() {
        return complainReason;
    }

    public void setComplainReason(String complainReason) {
        this.complainReason = complainReason;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }

    public String getDealUserName() {
        return dealUserName;
    }

    public void setDealUserName(String dealUserName) {
        this.dealUserName = dealUserName;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}
