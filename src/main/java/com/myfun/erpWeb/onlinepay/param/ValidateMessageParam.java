package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ValidateMessageParam implements EncryParamIfc {

    @ApiModelProperty(value = "城市ID", hidden = true)
    private Integer cityId;
    @ApiModelProperty(value = "公司ID", hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "电话", required = true)
    private String phone;
    @ApiModelProperty(value = "验证码", required = true)
    private String messageKey;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
