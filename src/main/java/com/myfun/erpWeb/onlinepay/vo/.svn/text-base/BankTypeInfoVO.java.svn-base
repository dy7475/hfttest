package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class BankTypeInfoVO implements Serializable {

    @ApiModelProperty("业务查询结果，如果result=0 建议吐司提醒")
    private Integer result = 1;
    @ApiModelProperty("账户类型 贷记卡：CREDIT 借记卡：DEBIT")
    private String accountType;
    @ApiModelProperty("开户行名称")
    private String bankName;
    @ApiModelProperty("联行号")
    private String LiquBankCode;
    @ApiModelProperty("银行名称")
    private String LiquBankName;
    @ApiModelProperty("账号")
    private String cardNo;
    @ApiModelProperty("账号长度")
    private String cardNoLength;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getLiquBankCode() {
        return LiquBankCode;
    }

    public void setLiquBankCode(String liquBankCode) {
        LiquBankCode = liquBankCode;
    }

    public String getLiquBankName() {
        return LiquBankName;
    }

    public void setLiquBankName(String liquBankName) {
        LiquBankName = liquBankName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNoLength() {
        return cardNoLength;
    }

    public void setCardNoLength(String cardNoLength) {
        this.cardNoLength = cardNoLength;
    }
}
