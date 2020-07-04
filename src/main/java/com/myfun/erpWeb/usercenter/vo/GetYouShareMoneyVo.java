package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel
public class GetYouShareMoneyVo implements Serializable {

    private String totleMoney;

    private String haveTrue;

    private String canWithdrawalsMoney;

    public String getTotleMoney() {
        return totleMoney;
    }

    public void setTotleMoney(String totleMoney) {
        this.totleMoney = totleMoney;
    }

    public String getHaveTrue() {
        return haveTrue;
    }

    public void setHaveTrue(String haveTrue) {
        this.haveTrue = haveTrue;
    }

    public String getCanWithdrawalsMoney() {
        return canWithdrawalsMoney;
    }

    public void setCanWithdrawalsMoney(String canWithdrawalsMoney) {
        this.canWithdrawalsMoney = canWithdrawalsMoney;
    }
}
