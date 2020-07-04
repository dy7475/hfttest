package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class InsertWarrantProcessParam implements EncryParamIfc {
    @ApiModelProperty(value = "流程类别")
    private Integer modelId;
    @ApiModelProperty(value = "主办人ID")
    private Integer dealUserId;
    @ApiModelProperty(value = "流程名称")
    private String modelName;
    @ApiModelProperty(value = "主办人姓名")
    private String dealUserName;
    @ApiModelProperty(value = "合同ID")
    private Integer dealId;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDealUserName() {
        return dealUserName;
    }

    public void setDealUserName(String dealUserName) {
        this.dealUserName = dealUserName;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }
}
