package com.myfun.erpWeb.historyCustomer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel("历史成交vo")
public class TransferRecordListVO {
    @ApiModelProperty(value="id")
    private Integer funHistoryDealRecordId;
    @ApiModelProperty(value="创建人")
    private String createdUserId;
    @ApiModelProperty(value="创建时间")
    private Date createdTime;
    @ApiModelProperty(value="更新人")
    private String updatedUserId;
    @ApiModelProperty(value="更新时间")
    private Date updatedTime;
    @ApiModelProperty(value="历史成交客ID")
    private Integer funHistoryDealCustId;
    @ApiModelProperty(value="变动原因")
    private String changeCause;
    @ApiModelProperty(value="变动前归属人")
    private Integer beforeChangeUserId;
    @ApiModelProperty(value="变动前归属人名称")
    private String beforeChangeUserName;
    @ApiModelProperty(value="变动前归属人组织ID")
    private Integer beforeChangeOrgId;
    @ApiModelProperty(value="变动前归属人组织名称")
    private String beforeChangeOrgName;
    @ApiModelProperty(value="变动后归属人")
    private Integer afterChangeUserId;
    @ApiModelProperty(value="变动后归属人名称")
    private String afterChangeUserName;
    @ApiModelProperty(value="变动后归属人组织ID")
    private Integer afterChangeOrgId;
    @ApiModelProperty(value="变动后组织名称")
    private String afterChangeOrgName;

    public Integer getFunHistoryDealRecordId() {
        return funHistoryDealRecordId;
    }

    public void setFunHistoryDealRecordId(Integer funHistoryDealRecordId) {
        this.funHistoryDealRecordId = funHistoryDealRecordId;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getFunHistoryDealCustId() {
        return funHistoryDealCustId;
    }

    public void setFunHistoryDealCustId(Integer funHistoryDealCustId) {
        this.funHistoryDealCustId = funHistoryDealCustId;
    }

    public String getChangeCause() {
        return changeCause;
    }

    public void setChangeCause(String changeCause) {
        this.changeCause = changeCause;
    }

    public Integer getBeforeChangeUserId() {
        return beforeChangeUserId;
    }

    public void setBeforeChangeUserId(Integer beforeChangeUserId) {
        this.beforeChangeUserId = beforeChangeUserId;
    }

    public String getBeforeChangeUserName() {
        return beforeChangeUserName;
    }

    public void setBeforeChangeUserName(String beforeChangeUserName) {
        this.beforeChangeUserName = beforeChangeUserName;
    }

    public Integer getBeforeChangeOrgId() {
        return beforeChangeOrgId;
    }

    public void setBeforeChangeOrgId(Integer beforeChangeOrgId) {
        this.beforeChangeOrgId = beforeChangeOrgId;
    }

    public String getBeforeChangeOrgName() {
        return beforeChangeOrgName;
    }

    public void setBeforeChangeOrgName(String beforeChangeOrgName) {
        this.beforeChangeOrgName = beforeChangeOrgName;
    }

    public Integer getAfterChangeUserId() {
        return afterChangeUserId;
    }

    public void setAfterChangeUserId(Integer afterChangeUserId) {
        this.afterChangeUserId = afterChangeUserId;
    }

    public String getAfterChangeUserName() {
        return afterChangeUserName;
    }

    public void setAfterChangeUserName(String afterChangeUserName) {
        this.afterChangeUserName = afterChangeUserName;
    }

    public Integer getAfterChangeOrgId() {
        return afterChangeOrgId;
    }

    public void setAfterChangeOrgId(Integer afterChangeOrgId) {
        this.afterChangeOrgId = afterChangeOrgId;
    }

    public String getAfterChangeOrgName() {
        return afterChangeOrgName;
    }

    public void setAfterChangeOrgName(String afterChangeOrgName) {
        this.afterChangeOrgName = afterChangeOrgName;
    }
}
