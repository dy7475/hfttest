package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel
public class PaymentOrderVO {

    // 订单支付方式
    @ApiModelProperty("支付方式，1=微信 2=快捷支付")
    private Byte orderPaymentType;
    @ApiModelProperty("微信或者快捷支付方式的url")
    private String url;
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("预单号")
    private String txnNo;
    @ApiModelProperty("状态  等于0 代表不正常 1=成功")
    private Integer result = 0;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getTxnNo() {
        return txnNo;
    }

    public void setTxnNo(String txnNo) {
        this.txnNo = txnNo;
    }

    public Byte getOrderPaymentType() {
        return orderPaymentType;
    }

    public void setOrderPaymentType(Byte orderPaymentType) {
        this.orderPaymentType = orderPaymentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
