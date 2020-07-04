package com.myfun.erpWeb.onlinepay.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @title 订单分账方
 * @author lcb
 * @since 2019/8/27
 * @param
 * @return
 */
@ApiModel
public class PaymentPayeeParam implements Serializable {

    // 账户ID
    @ApiModelProperty(value = "账户ID", required = true)
    private Integer accountId;
    // 城市ID
    @ApiModelProperty(value = "分账方城市ID", required = true)
    private Integer cityId;
    // 公司ID
    @ApiModelProperty(value = "分账方公司ID", required = true)
    private Integer compId;
    // 分账金额
    @ApiModelProperty(value = "分账金额", required = true)
    private BigDecimal amountReceived;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public BigDecimal getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(BigDecimal amountReceived) {
        this.amountReceived = amountReceived;
    }
}
