package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2020/2/11
 */
public class GenerateCodeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}