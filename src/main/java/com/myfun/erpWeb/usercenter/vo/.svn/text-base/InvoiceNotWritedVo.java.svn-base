package com.myfun.erpWeb.usercenter.vo;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class InvoiceNotWritedVo  {

    @ApiModelProperty("冲值(消费)金额")
    private String amount;
    @ApiModelProperty("冲值方式")
    private String paidType;
    @ApiModelProperty("支付类型")
    private Integer ptType;
    @ApiModelProperty("门店名称")
    private String deptName;
    @ApiModelProperty("0代表没有收据，但可能有发票，1代表只有收据，2代表两个都有")
    private Byte hasReceipt;
    @ApiModelProperty("主键自增")
    private Integer paidId;
    @ApiModelProperty("FUN_ISSUE_INVOICE 表自增主键")
    private Integer invoiceId;
    @ApiModelProperty("档案ID")
    private Integer archiveId;
    @ApiModelProperty("冲值(消费)日期")
    private Date padiTime;
    @ApiModelProperty("门店ID")
    private Integer deptId;
    @ApiModelProperty("发票状态 0=待审核 1=审核失败 2=业务审核通过 3=财务审核通过 4=已邮寄 5=已开具 6=仅保存")
    private Byte invoiceStatus;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaidType() {
        return paidType;
    }

    public void setPaidType(String paidType) {
        this.paidType = paidType;
    }

    public Integer getPtType() {
        return ptType;
    }

    public void setPtType(Integer ptType) {
        this.ptType = ptType;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Byte getHasReceipt() {
        return hasReceipt;
    }

    public void setHasReceipt(Byte hasReceipt) {
        this.hasReceipt = hasReceipt;
    }

    public Integer getPaidId() {
        return paidId;
    }

    public void setPaidId(Integer paidId) {
        this.paidId = paidId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Date getPadiTime() {
        return padiTime;
    }

    public void setPadiTime(Date padiTime) {
        this.padiTime = padiTime;
    }

	public Byte getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Byte invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
    
}
