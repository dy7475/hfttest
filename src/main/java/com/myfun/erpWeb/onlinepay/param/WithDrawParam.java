package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel
public class WithDrawParam implements EncryParamIfc {

    @ApiModelProperty(value = "账户唯一标识", required = true)
    private Integer accountId;
    @ApiModelProperty(value = "提现金额")
    private BigDecimal withdrawAmount;
    @ApiModelProperty(value = "提现银行卡")
    private String payeeAccountNo;
    @ApiModelProperty(value = "账户唯一标识", hidden = true)
    private Integer cityId;
    @ApiModelProperty(value = "账户唯一标识", hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "账户唯一标识", hidden = true)
    private Integer userId;
    @ApiModelProperty(value = "账户唯一标识", hidden = true)
    private String userName;
    @ApiModelProperty(value = "账户唯一标识", hidden = true)
    private Integer archiveId;
    @ApiModelProperty(value = "账户唯一标识", hidden = true)
    private Integer deptId;
    @ApiModelProperty(value = "账户唯一标识", hidden = true)
    private String deptName;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
