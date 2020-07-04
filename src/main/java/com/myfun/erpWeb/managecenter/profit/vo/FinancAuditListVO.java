package com.myfun.erpWeb.managecenter.profit.vo;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class FinancAuditListVO {

    @ApiModelProperty(value = "合同ID，自增序列")
    private Integer dealId;
    @ApiModelProperty(value = "系统创建时间")
    private String creatorDate;
    @ApiModelProperty(value = "款项 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融")
    private Byte performanceType;
    @ApiModelProperty(value = "款项中文名称")
    private String performanceName;
    @ApiModelProperty(value = "卖方业主姓名")
    private String sellOwnerName;
    @ApiModelProperty(value = "买方业主姓名")
    private String buyOwnerName;
    @ApiModelProperty(value = "付款方，1:客户 2:业主 3:中介   dic:PROCESS_FINANC_PAYER")
    private String pfPayer;
    @ApiModelProperty(value = "付款方中文名称")
    private String pfPayerName;
    @ApiModelProperty(value = "收款方，1:客户 2:业主 3:中介 4：房管局 5：银行 6：评估公司 7：其他   dic:PROCESS_FINANC_GETER")
    private String pfGeter;
    @ApiModelProperty(value = "收款方中文名称")
    private String pfGeterName;
    @ApiModelProperty(value = "付款金额")
    private BigDecimal payAmount;
    @ApiModelProperty(value = "付款时间")
    private Date pfTime;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "合同编号自动生成【创建合同后系统自动生成的编号，在后台数据库保存的】")
    private String agreementNo;
    @ApiModelProperty(value = "合同成交时的房源地址描述")
    private String houseaddress;
    @ApiModelProperty(value = "财务款项审核状态0未审，1已审核  2=审核中 3=撤销审核中")
    private String auditStatus;
    @ApiModelProperty(value = "财务款项中文名称")
    private String auditName;
    @ApiModelProperty(value = "审核人姓名")
    private String auditUserName;
    @ApiModelProperty(value = "财务款项新增审核日期")
    private Date auditTime;

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getPfPayerName() {
        return pfPayerName;
    }

    public void setPfPayerName(String pfPayerName) {
        this.pfPayerName = pfPayerName;
    }

    public String getPfGeterName() {
        return pfGeterName;
    }

    public void setPfGeterName(String pfGeterName) {
        this.pfGeterName = pfGeterName;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getCreatorDate() {
        return creatorDate;
    }

    public void setCreatorDate(String creatorDate) {
        this.creatorDate = creatorDate;
    }

    public Byte getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(Byte performanceType) {
        this.performanceType = performanceType;
    }

    public String getSellOwnerName() {
        return sellOwnerName;
    }

    public void setSellOwnerName(String sellOwnerName) {
        this.sellOwnerName = sellOwnerName;
    }

    public String getBuyOwnerName() {
        return buyOwnerName;
    }

    public void setBuyOwnerName(String buyOwnerName) {
        this.buyOwnerName = buyOwnerName;
    }

    public String getPfPayer() {
        return pfPayer;
    }

    public void setPfPayer(String pfPayer) {
        this.pfPayer = pfPayer;
    }

    public String getPfGeter() {
        return pfGeter;
    }

    public void setPfGeter(String pfGeter) {
        this.pfGeter = pfGeter;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPfTime() {
        return pfTime;
    }

    public void setPfTime(Date pfTime) {
        this.pfTime = pfTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAgreementNo() {
        return agreementNo;
    }

    public void setAgreementNo(String agreementNo) {
        this.agreementNo = agreementNo;
    }

    public String getHouseaddress() {
        return houseaddress;
    }

    public void setHouseaddress(String houseaddress) {
        this.houseaddress = houseaddress;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}
