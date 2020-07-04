package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(description = "获取新房分销使用协议状态VO")
public class GetAgencyUseFlagVo implements Serializable {
    /**
     * @mbggenerated 新房分销平台使用协议状态 0=不同意 1=同意
     */
    @ApiModelProperty("新房分销平台使用协议状态 0=不同意 1=同意")
    private Byte agencyUseFlag;

    public Byte getAgencyUseFlag() {
        return agencyUseFlag;
    }

    public void setAgencyUseFlag(Byte agencyUseFlag) {
        this.agencyUseFlag = agencyUseFlag;
    }
}
