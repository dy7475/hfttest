package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ValidateMsgCodeVO implements Serializable {

    @ApiModelProperty(value = "是否需要验证", required = true)
    private Integer requireValidate = 1;

    public Integer getRequireValidate() {
        return requireValidate;
    }

    public void setRequireValidate(Integer requireValidate) {
        this.requireValidate = requireValidate;
    }
}
