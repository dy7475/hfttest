package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class XwAccountPasswordParam implements EncryParamIfc {

    @ApiModelProperty(value = "密码操作类型 1=修改 2=重置", required = true)
    private Byte opType;

    @ApiModelProperty(value = "账户ID", required = true)
    private Integer accountId;

    @ApiModelProperty(value = "城市ID", hidden = true)
    private Integer cityId;

    public Byte getOpType() {
        return opType;
    }

    public void setOpType(Byte opType) {
        this.opType = opType;
    }

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
}
