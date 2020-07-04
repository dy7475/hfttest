package com.myfun.erpWeb.onlinepay.vo;

import com.myfun.repository.admindb.po.AdminXwBankAccount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel
public class AccountInfoVO implements Serializable {
    @ApiModelProperty("返回结果 1成功")
    private Integer result = 0;
    @ApiModelProperty("账户信息")
    private AdminXwBankAccount adminXwBankAccount;
    @ApiModelProperty("可提金额")
    private BigDecimal valibleAmt;
    @ApiModelProperty("银行卡信息")
    private List<BankInfoVO> bankInfo;
    @ApiModelProperty("账户ID")
    private Integer accountId;
    @ApiModelProperty("提现手续费")
    private String serviceFee;

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public AdminXwBankAccount getAdminXwBankAccount() {
        return adminXwBankAccount;
    }

    public void setAdminXwBankAccount(AdminXwBankAccount adminXwBankAccount) {
        this.adminXwBankAccount = adminXwBankAccount;
    }

    public BigDecimal getValibleAmt() {
        return valibleAmt;
    }

    public void setValibleAmt(BigDecimal valibleAmt) {
        this.valibleAmt = valibleAmt;
    }

    public List<BankInfoVO> getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(List<BankInfoVO> bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
