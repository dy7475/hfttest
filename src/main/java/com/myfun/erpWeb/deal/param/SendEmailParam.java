package com.myfun.erpWeb.deal.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class SendEmailParam implements EncryParamIfc {
    @NotNull
    @ApiModelProperty(value = "合同id", required = true)
    private Integer dealId;
    @NotNull
    @ApiModelProperty(value = "邮箱地址", required = true)
    private String emailAddress;
    @NotNull
    @ApiModelProperty(value = "城市", required = true)
    private Integer cityId;
    @NotNull
    @ApiModelProperty(value = "合同买卖双方的电话号码一个", required = true)
    private String telNum;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }
}
