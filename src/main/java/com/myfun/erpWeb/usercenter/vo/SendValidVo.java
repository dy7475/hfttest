package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SendValidVo {

    @ApiModelProperty("发送验证码次数")
    private Integer sendCount;

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }
}
