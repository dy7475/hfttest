package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class AccountBankInfoVO implements Serializable {

    @ApiModelProperty("业务查询结果，如果result=0 建议吐司提醒")
    private Integer result = 0;

    @ApiModelProperty("银行信息")
    private List<BankInfoVO> bankInfo;
    @ApiModelProperty("账户ID")
    private Integer accountId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<BankInfoVO> getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(List<BankInfoVO> bankInfo) {
        this.bankInfo = bankInfo;
    }
}
