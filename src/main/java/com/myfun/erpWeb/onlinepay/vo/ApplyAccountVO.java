package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ApplyAccountVO implements Serializable {

    @ApiModelProperty("处理结果：1=申请成功，获取url 供前端打开 2=已有正常账户 3=已有账户，新网审核中 4=申请失败")
    private Byte result = 0;
    @ApiModelProperty("跳转地址 只有resultCode=1 才有")
    private String redirectUrl;
    @ApiModelProperty("处理消息，仅resultCode=4 才有")
    private String returnMsg;

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }
}
