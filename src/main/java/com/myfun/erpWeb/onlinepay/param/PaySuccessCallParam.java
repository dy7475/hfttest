package com.myfun.erpWeb.onlinepay.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class PaySuccessCallParam implements Serializable {

    @ApiModelProperty(value = "订单id", required = true)
    private Integer orderId;
    @ApiModelProperty(value = "城市Id", required = true)
    private Integer cityId;
    @ApiModelProperty(value = "文件Id", required = true)
    private Integer receiptFileId;

    public Integer getReceiptFileId() {
        return receiptFileId;
    }

    public void setReceiptFileId(Integer receiptFileId) {
        this.receiptFileId = receiptFileId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
