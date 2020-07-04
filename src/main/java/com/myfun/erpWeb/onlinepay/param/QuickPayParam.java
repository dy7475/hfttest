package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel
public class QuickPayParam implements EncryParamIfc {

    // 快捷支付 预下单号
    private String txnNo;
    // 银行卡号
    private String payerAccountNo;
    // 银行开户名
    private String payerAccountName;
    // 银行卡类型  CREDIT：信用卡  DEBIT：借记卡
    private String payerAccountType;
    // 信用卡有效期
    private String validDate;
    // 信用卡cvn2
    private String cvn2;
    private String payerPhone;
    // 付款人证件号
    private String payerCerNo;
    // 证件类型
    private String payerCerType;
    // 短信码
    private String messageCaptcha;

    private Integer accountId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTxnNo() {
        return txnNo;
    }

    public void setTxnNo(String txnNo) {
        this.txnNo = txnNo;
    }

    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo;
    }

    public String getPayerAccountName() {
        return payerAccountName;
    }

    public void setPayerAccountName(String payerAccountName) {
        this.payerAccountName = payerAccountName;
    }

    public String getPayerAccountType() {
        return payerAccountType;
    }

    public void setPayerAccountType(String payerAccountType) {
        this.payerAccountType = payerAccountType;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getCvn2() {
        return cvn2;
    }

    public void setCvn2(String cvn2) {
        this.cvn2 = cvn2;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getPayerCerNo() {
        return payerCerNo;
    }

    public void setPayerCerNo(String payerCerNo) {
        this.payerCerNo = payerCerNo;
    }

    public String getPayerCerType() {
        return payerCerType;
    }

    public void setPayerCerType(String payerCerType) {
        this.payerCerType = payerCerType;
    }

    public String getMessageCaptcha() {
        return messageCaptcha;
    }

    public void setMessageCaptcha(String messageCaptcha) {
        this.messageCaptcha = messageCaptcha;
    }
}
