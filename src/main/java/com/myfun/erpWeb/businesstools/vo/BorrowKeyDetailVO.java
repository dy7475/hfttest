package com.myfun.erpWeb.businesstools.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
public class BorrowKeyDetailVO implements Serializable {

    @ApiModelProperty("借用人电话")
    private String borrowPhone;
    @ApiModelProperty("钥匙编号")
    private String keyNo;
    @ApiModelProperty("钥匙状态")
    private Integer keyStatus;
    @ApiModelProperty("借用人姓名")
    private String borrowName;
    @ApiModelProperty("提交人姓名")
    private String submitName;
    @ApiModelProperty("当前押金")
    private BigDecimal currentDeposit;
    @ApiModelProperty("审核人姓名")
    private String reviewName;

    @ApiModelProperty("提交人电话")
    private String submitPhone;
    @ApiModelProperty("押金状态")
    private Integer currentDepositStatus;
    @ApiModelProperty("门店名称")
    private String deptName;

    public Integer getCurrentDepositStatus() {
        return currentDepositStatus;
    }

    public void setCurrentDepositStatus(Integer currentDepositStatus) {
        this.currentDepositStatus = currentDepositStatus;
    }

    public String getSubmitPhone() {
        return submitPhone;
    }

    public void setSubmitPhone(String submitPhone) {
        this.submitPhone = submitPhone;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBorrowPhone() {
        return borrowPhone;
    }

    public void setBorrowPhone(String borrowPhone) {
        this.borrowPhone = borrowPhone;
    }

    public String getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo;
    }

    public Integer getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(Integer keyStatus) {
        this.keyStatus = keyStatus;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getSubmitName() {
        return submitName;
    }

    public void setSubmitName(String submitName) {
        this.submitName = submitName;
    }

    public BigDecimal getCurrentDeposit() {
        return currentDeposit;
    }

    public void setCurrentDeposit(BigDecimal currentDeposit) {
        this.currentDeposit = currentDeposit;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }
}
