package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class CheckAccountStatusVO implements Serializable {

    @ApiModelProperty("账户状态， 0= 不存在，需要走开户流程 1=审核中 2=开户失败 3=开户成功")
    private Byte openAccountStatus = 0;

    @ApiModelProperty("账户ID")
    private Integer accountId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Byte getOpenAccountStatus() {
        return openAccountStatus;
    }

    public void setOpenAccountStatus(Byte openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }
}
