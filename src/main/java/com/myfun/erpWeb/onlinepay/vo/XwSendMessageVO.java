package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel
public class XwSendMessageVO implements Serializable {
    private Integer result = 0;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
