package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminYouPaid implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer paidId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private String paidCatigory;
	/**
	 * @mbggenerated
	 */
	private String paidType;
	/**
	 * @mbggenerated
	 */
	private BigDecimal youAmount;
	/**
	 * @mbggenerated
	 */
	private BigDecimal amountBefore;
	/**
	 * @mbggenerated
	 */
	private BigDecimal amountAfter;
	/**
	 * @mbggenerated
	 */
	private String paidDesc;
	/**
	 * @mbggenerated
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getPaidId() {
		return paidId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaidId(Integer paidId) {
		this.paidId = paidId;
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
	public String getPaidCatigory() {
		return paidCatigory;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaidCatigory(String paidCatigory) {
		this.paidCatigory = paidCatigory == null ? null : paidCatigory.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPaidType() {
		return paidType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaidType(String paidType) {
		this.paidType = paidType == null ? null : paidType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getYouAmount() {
		return youAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setYouAmount(BigDecimal youAmount) {
		this.youAmount = youAmount;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAmountBefore() {
		return amountBefore;
	}

	/**
	 * @mbggenerated
	 */
	public void setAmountBefore(BigDecimal amountBefore) {
		this.amountBefore = amountBefore;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAmountAfter() {
		return amountAfter;
	}

	/**
	 * @mbggenerated
	 */
	public void setAmountAfter(BigDecimal amountAfter) {
		this.amountAfter = amountAfter;
	}

	/**
	 * @mbggenerated
	 */
	public String getPaidDesc() {
		return paidDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaidDesc(String paidDesc) {
		this.paidDesc = paidDesc == null ? null : paidDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
}