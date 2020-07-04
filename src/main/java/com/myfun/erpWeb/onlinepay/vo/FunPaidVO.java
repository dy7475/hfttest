package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class FunPaidVO implements Serializable {

    @ApiModelProperty("城市ID")
    private Integer cityId;
    @ApiModelProperty("消费记录Id")
    private Integer paidId;
    @ApiModelProperty("账户ID")
    private Integer uaId;
    @ApiModelProperty("消费时间")
    private Date padiTime;
    @ApiModelProperty("消费金额")
    private BigDecimal amount;
    @ApiModelProperty("消费类型")
    private String paidType;
    @ApiModelProperty("消费类型")
    private String paidCatigory;
    private String json;
    @ApiModelProperty("消费描述")
    private String orderRemark;
    @ApiModelProperty("业务ID")
    private Integer businessId;
    @ApiModelProperty("业务类型")
    private Byte businessType;
    @ApiModelProperty("下单人")
    private String userName;
    @ApiModelProperty("下单门店")
    private String deptName;
    @ApiModelProperty("支付方")
    private Byte payer;
    @ApiModelProperty("支付姓名")
    private String payerName;
    @ApiModelProperty("款项目")
    private String pfName;

    public String getPfName() {
        return pfName;
    }

    public void setPfName(String pfName) {
        this.pfName = pfName;
    }

    public Byte getPayer() {
        return payer;
    }

    public void setPayer(Byte payer) {
        this.payer = payer;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getPaidId() {
        return paidId;
    }

    public void setPaidId(Integer paidId) {
        this.paidId = paidId;
    }

    public Integer getUaId() {
        return uaId;
    }

    public void setUaId(Integer uaId) {
        this.uaId = uaId;
    }

    public Date getPadiTime() {
        return padiTime;
    }

    public void setPadiTime(Date padiTime) {
        this.padiTime = padiTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaidType() {
        return paidType;
    }

    public void setPaidType(String paidType) {
        this.paidType = paidType;
    }

    public String getPaidCatigory() {
        return paidCatigory;
    }

    public void setPaidCatigory(String paidCatigory) {
        this.paidCatigory = paidCatigory;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
