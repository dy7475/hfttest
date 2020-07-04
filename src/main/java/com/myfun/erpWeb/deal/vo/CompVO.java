package com.myfun.erpWeb.deal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel
public class CompVO implements Serializable {
    @ApiModelProperty("是否开通了上上签在线合同签约 1=是")
    private Byte openOnlineContract =0;
    @ApiModelProperty("开通在线签约填写公司信息weburl")
    private String compInfoWebUrl;
    @ApiModelProperty("是否是总经理账号  1=是 0=否")
    private String userosition;

    public String getUserosition() {
        return userosition;
    }

    public void setUserosition(String userosition) {
        this.userosition = userosition;
    }

    public Byte getOpenOnlineContract() {
        return openOnlineContract;
    }

    public void setOpenOnlineContract(Byte openOnlineContract) {
        this.openOnlineContract = openOnlineContract;
    }

    public String getCompInfoWebUrl() {
        return compInfoWebUrl;
    }

    public void setCompInfoWebUrl(String compInfoWebUrl) {
        this.compInfoWebUrl = compInfoWebUrl;
    }
}
