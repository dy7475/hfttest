package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgencyAmountHistory implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer detailId;
	/**
	 * @mbggenerated
	 */
	private Date applyTime;
	/**
	 * @mbggenerated
	 */
	private String extractNo;
	/**
	 * @mbggenerated
	 */
	private BigDecimal extractAmount;
	/**
	 * @mbggenerated
	 */
	private Byte receiveType;
	/**
	 * @mbggenerated
	 */
	private Byte needInvoice;
	/**
	 * @mbggenerated
	 */
	private BigDecimal feePaid;
	/**
	 * @mbggenerated
	 */
	private BigDecimal actualAmount;
	/**
	 * @mbggenerated
	 */
	private Date payTime;
	/**
	 * @mbggenerated
	 */
	private Byte payStatus;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private String userName;
	/**
	 * @mbggenerated
	 */
	private String userMobile;
	/**
	 * @mbggenerated
	 */
	private Integer crmUserId;
	/**
	 * @mbggenerated
	 */
	private Byte compFlag;
	/**
	 * @mbggenerated
	 */
	private Byte isRecharge;
	/**
	 * @mbggenerated
	 */
	private Integer accountId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private String voucherAddr;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getDetailId() {
		return detailId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getExtractNo() {
		return extractNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setExtractNo(String extractNo) {
		this.extractNo = extractNo == null ? null : extractNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getExtractAmount() {
		return extractAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setExtractAmount(BigDecimal extractAmount) {
		this.extractAmount = extractAmount;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getReceiveType() {
		return receiveType;
	}

	/**
	 * @mbggenerated
	 */
	public void setReceiveType(Byte receiveType) {
		this.receiveType = receiveType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getNeedInvoice() {
		return needInvoice;
	}

	/**
	 * @mbggenerated
	 */
	public void setNeedInvoice(Byte needInvoice) {
		this.needInvoice = needInvoice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getFeePaid() {
		return feePaid;
	}

	/**
	 * @mbggenerated
	 */
	public void setFeePaid(BigDecimal feePaid) {
		this.feePaid = feePaid;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getPayTime() {
		return payTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPayStatus() {
		return payStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCrmUserId() {
		return crmUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCrmUserId(Integer crmUserId) {
		this.crmUserId = crmUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCompFlag() {
		return compFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompFlag(Byte compFlag) {
		this.compFlag = compFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsRecharge() {
		return isRecharge;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsRecharge(Byte isRecharge) {
		this.isRecharge = isRecharge;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public String getVoucherAddr() {
		return voucherAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setVoucherAddr(String voucherAddr) {
		this.voucherAddr = voucherAddr == null ? null : voucherAddr.trim();
	}
}