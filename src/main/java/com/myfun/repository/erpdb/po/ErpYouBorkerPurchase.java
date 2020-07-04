package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpYouBorkerPurchase extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer purchaseId;
	/**
	 * @mbggenerated
	 */
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Byte isReturnIntegral;
	/**
	 * @mbggenerated
	 */
	private BigDecimal costIntegral;
	/**
	 * @mbggenerated
	 */
	private Byte complainFlag;
	/**
	 * @mbggenerated
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Byte youShareFlag;
	/**
	 * @mbggenerated
	 */
	private Integer youShareId;
	/**
	 * @mbggenerated
	 */
	private Integer targetComplainFlag;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getPurchaseId() {
		return purchaseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Byte getIsReturnIntegral() {
		return isReturnIntegral;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsReturnIntegral(Byte isReturnIntegral) {
		this.isReturnIntegral = isReturnIntegral;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCostIntegral() {
		return costIntegral;
	}

	/**
	 * @mbggenerated
	 */
	public void setCostIntegral(BigDecimal costIntegral) {
		this.costIntegral = costIntegral;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getComplainFlag() {
		return complainFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplainFlag(Byte complainFlag) {
		this.complainFlag = complainFlag;
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
	public Byte getYouShareFlag() {
		return youShareFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setYouShareFlag(Byte youShareFlag) {
		this.youShareFlag = youShareFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getYouShareId() {
		return youShareId;
	}

	/**
	 * @mbggenerated
	 */
	public void setYouShareId(Integer youShareId) {
		this.youShareId = youShareId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetComplainFlag() {
		return targetComplainFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetComplainFlag(Integer targetComplainFlag) {
		this.targetComplainFlag = targetComplainFlag;
	}

	/**
	 * @mbggenerated
	 */
	public ErpYouBorkerPurchase() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpYouBorkerPurchase(Integer shardCityId, Integer purchaseId) {
		super(shardCityId);
		this.purchaseId = purchaseId;
	}
}