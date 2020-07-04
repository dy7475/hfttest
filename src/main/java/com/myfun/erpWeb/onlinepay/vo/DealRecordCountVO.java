package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
public class DealRecordCountVO implements Serializable {

    @ApiModelProperty("成交笔数")
    private Integer dealRecordCount = 0;
    @ApiModelProperty("成交金额")
    private BigDecimal dealRecordAmount = BigDecimal.ZERO;

    public BigDecimal getDealRecordAmount() {
        return dealRecordAmount;
    }

    public void setDealRecordAmount(BigDecimal dealRecordAmount) {
        this.dealRecordAmount = dealRecordAmount;
    }

    public Integer getDealRecordCount() {
        return dealRecordCount;
    }

    public void setDealRecordCount(Integer dealRecordCount) {
        this.dealRecordCount = dealRecordCount;
    }

}
