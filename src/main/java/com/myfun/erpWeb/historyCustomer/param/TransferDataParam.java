package com.myfun.erpWeb.historyCustomer.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("移交数据参数")
public class TransferDataParam implements EncryParamIfc {
    @ApiModelProperty("历史成交客id 多个以，分隔,全部传ALL")
    private String funHistoryDealCustId;
    @ApiModelProperty("转出组织id")
    private String beforeChangeOrgId;
    @ApiModelProperty("转出人组织名称")
    private String beforeChangeOrgName;
    @ApiModelProperty("转出人id")
    private String beforeChangeUserId;
    @ApiModelProperty("转出人名称")
    private String beforeChangeUserName;
    @ApiModelProperty("接收人组织id")
    private String       afterChangeOrgId;
    @ApiModelProperty("接收人id")
    private String   afterChangeUserId;
    @ApiModelProperty("接收人名称")
    private String   afterChangeUserName;
    @ApiModelProperty("接收人组织名称")
    private String   afterChangeOrgName;
    @ApiModelProperty("移交原因")
    private String    changeCause;

    public String getBeforeChangeOrgName() {
        return beforeChangeOrgName;
    }

    public void setBeforeChangeOrgName(String beforeChangeOrgName) {
        this.beforeChangeOrgName = beforeChangeOrgName;
    }

    public String getBeforeChangeUserName() {
        return beforeChangeUserName;
    }

    public void setBeforeChangeUserName(String beforeChangeUserName) {
        this.beforeChangeUserName = beforeChangeUserName;
    }

    public String getAfterChangeUserName() {
        return afterChangeUserName;
    }

    public void setAfterChangeUserName(String afterChangeUserName) {
        this.afterChangeUserName = afterChangeUserName;
    }

    public String getAfterChangeOrgName() {
        return afterChangeOrgName;
    }

    public void setAfterChangeOrgName(String afterChangeOrgName) {
        this.afterChangeOrgName = afterChangeOrgName;
    }

    public String getFunHistoryDealCustId() {
        return funHistoryDealCustId;
    }

    public void setFunHistoryDealCustId(String funHistoryDealCustId) {
        this.funHistoryDealCustId = funHistoryDealCustId;
    }


    public String getBeforeChangeUserId() {
        return beforeChangeUserId;
    }

    public void setBeforeChangeUserId(String beforeChangeUserId) {
        this.beforeChangeUserId = beforeChangeUserId;
    }

    public String getBeforeChangeOrgId() {
        return beforeChangeOrgId;
    }

    public void setBeforeChangeOrgId(String beforeChangeOrgId) {
        this.beforeChangeOrgId = beforeChangeOrgId;
    }

    public String getAfterChangeOrgId() {
        return afterChangeOrgId;
    }

    public void setAfterChangeOrgId(String afterChangeOrgId) {
        this.afterChangeOrgId = afterChangeOrgId;
    }

    public String getAfterChangeUserId() {
        return afterChangeUserId;
    }

    public void setAfterChangeUserId(String afterChangeUserId) {
        this.afterChangeUserId = afterChangeUserId;
    }

    public String getChangeCause() {
        return changeCause;
    }

    public void setChangeCause(String changeCause) {
        this.changeCause = changeCause;
    }
}