package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "获取诚意金详情VO")
public class ErpFunEarbestMoneyDto extends ErpFunEarbestMoney implements Serializable {

	private String receiptUserMobile;

	/**** 拉卡拉的支付状态 ****/
	private Byte payStatus;
	private String payAccount;
	private Integer createGrId;
	private Integer createDeptId;
	private Integer receiptGrId;
	private Integer receiptArchiveId;  //收款人
	private Integer createArchiveId; //登记人
	private Integer confirmArchiveId; //确认人
	private Integer depositArchiveId; //转定金人
	private Integer refundArchiveId; //退款人

	@ApiModelProperty(value = "房源id")
	private Integer houseId;

	@ApiModelProperty(value = "经济人id")
	private Integer houseUserId;

	@ApiModelProperty(value = "业主姓名")
	private String ownerName;
	@ApiModelProperty(value = "楼盘名称")
	private String buildName;
	@ApiModelProperty(value = "房源价格")
	private BigDecimal housePrice;
	@ApiModelProperty(value = "出租房源租金单位，出售不需要，默认万元")
	private Byte housePriceUnit;

	@ApiModelProperty(value = "审核门店")
	private Integer auditDeptId;

	@ApiModelProperty(value = "审核门店名称")
	private String auditDeptName;

	@ApiModelProperty(value = "审核人ID")
	private Integer auditUserId;

	@ApiModelProperty(value = "审核人姓名")
	private String auditUserName;

	@ApiModelProperty(value = "审核时间")
	private Date auditTime;

	@ApiModelProperty(value = "成交状态: 0未成交 1已成交")
	private Integer dealStatus = 0;

	public Integer getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public Integer getAuditDeptId() {
		return auditDeptId;
	}

	public void setAuditDeptId(Integer auditDeptId) {
		this.auditDeptId = auditDeptId;
	}

	public String getAuditDeptName() {
		return auditDeptName;
	}

	public void setAuditDeptName(String auditDeptName) {
		this.auditDeptName = auditDeptName;
	}

	public Integer getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
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

	public Integer getRefundArchiveId() {
		return refundArchiveId;
	}

	public void setRefundArchiveId(Integer refundArchiveId) {
		this.refundArchiveId = refundArchiveId;
	}

	public Integer getReceiptArchiveId() {
		return receiptArchiveId;
	}

	public void setReceiptArchiveId(Integer receiptArchiveId) {
		this.receiptArchiveId = receiptArchiveId;
	}

	public Integer getCreateArchiveId() {
		return createArchiveId;
	}

	public void setCreateArchiveId(Integer createArchiveId) {
		this.createArchiveId = createArchiveId;
	}

	public Integer getConfirmArchiveId() {
		return confirmArchiveId;
	}

	public void setConfirmArchiveId(Integer confirmArchiveId) {
		this.confirmArchiveId = confirmArchiveId;
	}

	public Integer getDepositArchiveId() {
		return depositArchiveId;
	}

	public void setDepositArchiveId(Integer depositArchiveId) {
		this.depositArchiveId = depositArchiveId;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public Byte getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}

	public String getReceiptUserMobile() {
		return receiptUserMobile;
	}

	public void setReceiptUserMobile(String receiptUserMobile) {
		this.receiptUserMobile = receiptUserMobile;
	}

	public Integer getCreateGrId() {
		return createGrId;
	}

	public void setCreateGrId(Integer createGrId) {
		this.createGrId = createGrId;
	}

	public Integer getCreateDeptId() {
		return createDeptId;
	}

	public void setCreateDeptId(Integer createDeptId) {
		this.createDeptId = createDeptId;
	}

	public Integer getReceiptGrId() {
		return receiptGrId;
	}

	public void setReceiptGrId(Integer receiptGrId) {
		this.receiptGrId = receiptGrId;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getHouseUserId() {
		return houseUserId;
	}

	public void setHouseUserId(Integer houseUserId) {
		this.houseUserId = houseUserId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String getBuildName() {
		return buildName;
	}

	@Override
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public BigDecimal getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(BigDecimal housePrice) {
		this.housePrice = housePrice;
	}

	public Byte getHousePriceUnit() {
		return housePriceUnit;
	}

	public void setHousePriceUnit(Byte housePriceUnit) {
		this.housePriceUnit = housePriceUnit;
	}
}
