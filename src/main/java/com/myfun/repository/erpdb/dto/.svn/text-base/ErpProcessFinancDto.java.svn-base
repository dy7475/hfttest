package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class ErpProcessFinancDto extends ErpProcessFinanc {

	@ApiModelProperty(value = "0未支付 1：已支付（不能删除，不能反审核） 2：取消 3：作废")
	private Integer payStatus;
	private String payAccount;
	private String orderNo;
	private Integer orderId;
	private Integer financShouldget;
	private Integer actualProfit;
	private String shouldgetAduited;
	private String acutalgetAduited;

	private BigDecimal transferNeedPerformance;
	private BigDecimal transferRealPerformance;
	private BigDecimal secondhandNeedPerformance;
	private BigDecimal secondhandRealPerformance;
	private BigDecimal newhouseNeedPerformance;
	private BigDecimal newhouseRealPerformance;
	private BigDecimal leaseNeedPerformance;
	private BigDecimal leaseRealPerformance;
	private BigDecimal financeNeedPerformance;
	private BigDecimal financeRealPerformance;
	private BigDecimal totalNeedPerformance;
	private BigDecimal totalRealPerformance;
	private BigDecimal totalNeedIncome;
	private BigDecimal totalRealIncome;

	private BigDecimal buyCustomerCommsion;
	private BigDecimal sellOwnerCommsion;
	private BigDecimal yingshouMoney;
	private BigDecimal shishouMoney;
	@ApiModelProperty("回执单文件地址")
	private String receiptFilePath;
	@ApiModelProperty(value = "回执单文件ID", hidden = true)
	private Integer onlinePaymentReceiptFileId;
	@ApiModelProperty(value = "付款人名字")
	private String payerName;

	@ApiModelProperty(value = "付款类型 1=原有的支付方式 3=新网银行（不能反审核和删除）")
	private Integer payType;

	@Override
	public Integer getPayType() {
		return payType;
	}

	@Override
	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Override
	public Integer getOnlinePaymentReceiptFileId() {
		return onlinePaymentReceiptFileId;
	}

	@Override
	public void setOnlinePaymentReceiptFileId(Integer onlinePaymentReceiptFileId) {
		this.onlinePaymentReceiptFileId = onlinePaymentReceiptFileId;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getReceiptFilePath() {
		return receiptFilePath;
	}

	public void setReceiptFilePath(String receiptFilePath) {
		this.receiptFilePath = receiptFilePath;
	}

	public BigDecimal getYingshouMoney() {
		return yingshouMoney;
	}

	public void setYingshouMoney(BigDecimal yingshouMoney) {
		this.yingshouMoney = yingshouMoney;
	}

	public BigDecimal getShishouMoney() {
		return shishouMoney;
	}

	public void setShishouMoney(BigDecimal shishouMoney) {
		this.shishouMoney = shishouMoney;
	}

	public BigDecimal getBuyCustomerCommsion() {
		return buyCustomerCommsion;
	}

	public void setBuyCustomerCommsion(BigDecimal buyCustomerCommsion) {
		this.buyCustomerCommsion = buyCustomerCommsion;
	}

	public BigDecimal getSellOwnerCommsion() {
		return sellOwnerCommsion;
	}

	public void setSellOwnerCommsion(BigDecimal sellOwnerCommsion) {
		this.sellOwnerCommsion = sellOwnerCommsion;
	}

	public BigDecimal getTotalNeedIncome() {
		return totalNeedIncome;
	}

	public void setTotalNeedIncome(BigDecimal totalNeedIncome) {
		this.totalNeedIncome = totalNeedIncome;
	}

	public BigDecimal getTotalRealIncome() {
		return totalRealIncome;
	}

	public void setTotalRealIncome(BigDecimal totalRealIncome) {
		this.totalRealIncome = totalRealIncome;
	}

	public BigDecimal getTransferNeedPerformance() {
		return transferNeedPerformance;
	}

	public void setTransferNeedPerformance(BigDecimal transferNeedPerformance) {
		this.transferNeedPerformance = transferNeedPerformance;
	}

	public BigDecimal getTransferRealPerformance() {
		return transferRealPerformance;
	}

	public void setTransferRealPerformance(BigDecimal transferRealPerformance) {
		this.transferRealPerformance = transferRealPerformance;
	}

	public BigDecimal getSecondhandNeedPerformance() {
		return secondhandNeedPerformance;
	}

	public void setSecondhandNeedPerformance(BigDecimal secondhandNeedPerformance) {
		this.secondhandNeedPerformance = secondhandNeedPerformance;
	}

	public BigDecimal getSecondhandRealPerformance() {
		return secondhandRealPerformance;
	}

	public void setSecondhandRealPerformance(BigDecimal secondhandRealPerformance) {
		this.secondhandRealPerformance = secondhandRealPerformance;
	}

	public BigDecimal getNewhouseNeedPerformance() {
		return newhouseNeedPerformance;
	}

	public void setNewhouseNeedPerformance(BigDecimal newhouseNeedPerformance) {
		this.newhouseNeedPerformance = newhouseNeedPerformance;
	}

	public BigDecimal getNewhouseRealPerformance() {
		return newhouseRealPerformance;
	}

	public void setNewhouseRealPerformance(BigDecimal newhouseRealPerformance) {
		this.newhouseRealPerformance = newhouseRealPerformance;
	}

	public BigDecimal getLeaseNeedPerformance() {
		return leaseNeedPerformance;
	}

	public void setLeaseNeedPerformance(BigDecimal leaseNeedPerformance) {
		this.leaseNeedPerformance = leaseNeedPerformance;
	}

	public BigDecimal getLeaseRealPerformance() {
		return leaseRealPerformance;
	}

	public void setLeaseRealPerformance(BigDecimal leaseRealPerformance) {
		this.leaseRealPerformance = leaseRealPerformance;
	}

	public BigDecimal getFinanceNeedPerformance() {
		return financeNeedPerformance;
	}

	public void setFinanceNeedPerformance(BigDecimal financeNeedPerformance) {
		this.financeNeedPerformance = financeNeedPerformance;
	}

	public BigDecimal getFinanceRealPerformance() {
		return financeRealPerformance;
	}

	public void setFinanceRealPerformance(BigDecimal financeRealPerformance) {
		this.financeRealPerformance = financeRealPerformance;
	}

	public BigDecimal getTotalNeedPerformance() {
		return totalNeedPerformance;
	}

	public void setTotalNeedPerformance(BigDecimal totalNeedPerformance) {
		this.totalNeedPerformance = totalNeedPerformance;
	}

	public BigDecimal getTotalRealPerformance() {
		return totalRealPerformance;
	}

	public void setTotalRealPerformance(BigDecimal totalRealPerformance) {
		this.totalRealPerformance = totalRealPerformance;
	}

	public Integer getFinancShouldget() {
		return financShouldget;
	}

	public void setFinancShouldget(Integer financShouldget) {
		this.financShouldget = financShouldget;
	}

	public Integer getActualProfit() {
		return actualProfit;
	}

	public void setActualProfit(Integer actualProfit) {
		this.actualProfit = actualProfit;
	}

	public String getShouldgetAduited() {
		return shouldgetAduited;
	}

	public void setShouldgetAduited(String shouldgetAduited) {
		this.shouldgetAduited = shouldgetAduited;
	}

	public String getAcutalgetAduited() {
		return acutalgetAduited;
	}

	public void setAcutalgetAduited(String acutalgetAduited) {
		this.acutalgetAduited = acutalgetAduited;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
}
