package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class OnlinePaymentOrderVO implements Serializable {

    @ApiModelProperty("订单ID")
    private Integer orderId;
    @ApiModelProperty("订单编号")
    private String orderNo;
    @ApiModelProperty("楼盘")
    private String buildName;
    @ApiModelProperty("款项名称")
    private String pfName;
    @ApiModelProperty("付款人")
    private String payerName;
    @ApiModelProperty("付款方")
    private Byte payer;
    @ApiModelProperty("付款时间")
    private Date paymentTime;
    @ApiModelProperty("订单金额")
    private BigDecimal orderAmount;
    @ApiModelProperty("分得金额，展示使用这个金额")
    private BigDecimal receivedAmount;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Byte getPayer() {
        return payer;
    }

    public void setPayer(Byte payer) {
        this.payer = payer;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(BigDecimal receivedAmount) {
        this.receivedAmount = receivedAmount;
    }
}
