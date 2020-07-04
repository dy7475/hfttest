package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class PretieCardParam implements EncryParamIfc {

    @ApiModelProperty(value = "accountId", required = true)
    private Integer accountId;
    @ApiModelProperty(value = "电话", required = true)
    private String phone;
    @ApiModelProperty(value = "发送短信业务类型  快捷支付=QUICKPAY 充值=TOPUP", required = true)
    private String type;
    @ApiModelProperty(value = "txnNo", required = true)
    private String txnNo;
    @ApiModelProperty(value = "orderNo", required = true)
    private String orderNo;
    @ApiModelProperty(value = "卡类型 贷记卡：CREDIT 借记卡：DEBIT", required = true)
    private String accountType;
    @ApiModelProperty(value = "户名", required = true)
    private String accountName;
    @ApiModelProperty(value = "账号", required = true)
    private String accountNo;
    @ApiModelProperty(value = "证件类型 身份证：B01", required = true)
    private String cerType;
    @ApiModelProperty(value = "证件号码", required = true)
    private String cerNo;
    @ApiModelProperty(value = "银行卡安全码", required = true)
    private String cvn2;
    @ApiModelProperty(value = "银行卡有效期", required = true)
    private String validDate;

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

    public String getCerNo() {
        return cerNo;
    }

    public void setCerNo(String cerNo) {
        this.cerNo = cerNo;
    }

    public String getCerType() {
        return cerType;
    }

    public void setCerType(String cerType) {
        this.cerType = cerType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTxnNo() {
        return txnNo;
    }

    public void setTxnNo(String txnNo) {
        this.txnNo = txnNo;
    }
}
