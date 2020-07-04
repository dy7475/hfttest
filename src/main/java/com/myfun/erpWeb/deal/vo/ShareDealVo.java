package com.myfun.erpWeb.deal.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/8/24
 */
public class ShareDealVo implements Serializable {

    @ApiModelProperty("分享合同更新openId状态码 200=成功 500=失败")
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}