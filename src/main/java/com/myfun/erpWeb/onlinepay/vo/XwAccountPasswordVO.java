package com.myfun.erpWeb.onlinepay.vo;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class XwAccountPasswordVO implements EncryParamIfc {


    // 业务处理结果 只有等于1 才是成功的
    @ApiModelProperty("业务处理结果 result=1 成功 等于其他的建议吐司提示错误")
    private Integer result = 0;
    // 业务url
    @ApiModelProperty("跳转链接")
    private String redirectUrl;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
