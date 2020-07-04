package com.myfun.erpWeb.deal.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class AppletContractDetailsParam implements EncryParamIfc {
    @NotNull
    @ApiModelProperty(value = "合同Id", required = true)
    private Integer dealId;
    @NotNull
    @ApiModelProperty(value = "城市Id", required = true)
    private Integer cityId;
    @NotNull
    @ApiModelProperty(value = "经纪人Id", required = true)
    private Integer userId;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
