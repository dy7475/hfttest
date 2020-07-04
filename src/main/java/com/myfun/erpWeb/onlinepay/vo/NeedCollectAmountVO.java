package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
public class NeedCollectAmountVO implements Serializable {

    @ApiModelProperty("应收金额")
    private BigDecimal needCollectAmount = BigDecimal.ZERO;


    public BigDecimal getNeedCollectAmount() {
        return needCollectAmount;
    }

    public void setNeedCollectAmount(BigDecimal needCollectAmount) {
        this.needCollectAmount = needCollectAmount;
    }
}
