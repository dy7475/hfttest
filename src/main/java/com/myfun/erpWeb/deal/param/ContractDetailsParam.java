package com.myfun.erpWeb.deal.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class ContractDetailsParam implements EncryParamIfc {
    @NotNull
    @ApiModelProperty(value = "合同Id", required = true)
    private Integer dealId;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }
}
