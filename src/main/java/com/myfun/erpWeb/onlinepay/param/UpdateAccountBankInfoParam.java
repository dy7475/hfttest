package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateAccountBankInfoParam implements EncryParamIfc {

    @ApiModelProperty(value = "账户Id", required = true)
    private Integer accountId;
    @ApiModelProperty(value = "1 = 绑定 2=解绑", required = true)
    private Integer opType;
    @ApiModelProperty(value = "余额账户虚拟号", hidden = true)
    private String virtualAccountNo;
    @ApiModelProperty(value = "开户公司信息", required = true)
    private String bindingAccountName;
    @ApiModelProperty(value = "账号", required = true)
    private String bindingAccountNo;
    @ApiModelProperty(value = "电话", required = true)
    private String phone;
    @ApiModelProperty(value = "开户行 opType=1必填", required = true)
    private String bindingAccountBankName;
    @ApiModelProperty(value = "开户行号 opType=1必填", required = true)
    private String bindingAccountBankCode;

    public String getBindingAccountBankName() {
        return bindingAccountBankName;
    }

    public void setBindingAccountBankName(String bindingAccountBankName) {
        this.bindingAccountBankName = bindingAccountBankName;
    }

    public String getBindingAccountBankCode() {
        return bindingAccountBankCode;
    }

    public void setBindingAccountBankCode(String bindingAccountBankCode) {
        this.bindingAccountBankCode = bindingAccountBankCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBindingAccountName() {
        return bindingAccountName;
    }

    public void setBindingAccountName(String bindingAccountName) {
        this.bindingAccountName = bindingAccountName;
    }

    public String getBindingAccountNo() {
        return bindingAccountNo;
    }

    public void setBindingAccountNo(String bindingAccountNo) {
        this.bindingAccountNo = bindingAccountNo;
    }

    public String getVirtualAccountNo() {
        return virtualAccountNo;
    }

    public void setVirtualAccountNo(String virtualAccountNo) {
        this.virtualAccountNo = virtualAccountNo;
    }

    public Integer getOpType() {
        return opType;
    }

    public void setOpType(Integer opType) {
        this.opType = opType;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}

