package com.myfun.erpWeb.deal.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class VerifyTelphoneNumParam implements EncryParamIfc {
    @NotNull
    @ApiModelProperty(value = "合同id", required = true)
    private Integer dealId;
    @NotNull
    @ApiModelProperty(value = "电话号码", required = true)
    private String telPhoneNum;
    @NotNull
    @ApiModelProperty(value = "城市", required = true)
    private Integer cityId;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getTelPhoneNum() {
        return telPhoneNum;
    }

    public void setTelPhoneNum(String telPhoneNum) {
        this.telPhoneNum = telPhoneNum;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
