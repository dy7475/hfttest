package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/11/13
 */
public class SysParamVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数Id")
    private String paramId;

    @ApiModelProperty(value = "参数值")
    private String paramValue;

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}