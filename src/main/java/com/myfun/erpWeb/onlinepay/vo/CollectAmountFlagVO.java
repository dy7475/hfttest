package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class CollectAmountFlagVO implements Serializable {

    @ApiModelProperty("业务查询结果，1=收齐 0=未收齐")
    private Integer result = 0;
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
