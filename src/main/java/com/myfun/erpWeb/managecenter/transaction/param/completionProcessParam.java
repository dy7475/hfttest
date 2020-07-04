package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class completionProcessParam implements EncryParamIfc {
    @ApiModelProperty("合同Id")
    private Integer dealId;
    @ApiModelProperty("流程名称")
    private String modelName;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
