package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminFunHouseBidding implements Serializable {

	/**
	 * @mbggenerated ID号
	 */
	private Integer biddId;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 房源ID
	 */
	private Integer houseId;
	/**
	 * @mbggenerated 楼盘ID
	 */
	private Integer buildId;
	/**
	 * @mbggenerated 用途
	 */
	private String houseUseage;
	/**
	 * @mbggenerated 租售类型
	 */
	private String saleLease;
	/**
	 * @mbggenerated 竞价时间
	 */
	private Date biddingSuccTime;
	/**
	 * @mbggenerated 结束时间,根据(BIDDING_DAYS)竞价天数计算
	 */
	private Date biddingEndTime;
	/**
	 * @mbggenerated 竞价天数
	 */
	private Integer biddingDays;
	/**
	 * @mbggenerated 每天的出价
	 */
	private BigDecimal biddingPrice;
	/**
	 * @mbggenerated 公司花费
	 */
	private BigDecimal compPrice;
	/**
	 * @mbggenerated 个人花费
	 */
	private BigDecimal personalPrice;
	/**
	 * @mbggenerated 竞价人的ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 腾讯竞价数据状态
	 */
	private Byte qqStatus;
	/**
	 * @mbggenerated 好房在线推广或竞价状态
	 */
	private Byte haofangStatus;
	/**
	 * @mbggenerated 帐户类型
	 */
	private Byte uaType;
	/**
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private BigDecimal compCoin;
	/**
	 * @mbggenerated
	 */
	private Integer compUaId;
	/**
	 * @mbggenerated 好房币的使用量
	 */
	private BigDecimal personalCoin;
	/**
	 * @mbggenerated 竞价的来源1：ERP2：手机APP
	 */
	private Byte biddSource;
	/**
	 * @mbggenerated
	 */
	private Integer syncFlag;
	/**
	 * @mbggenerated 审核状态0=未审核 1=审核通过 2=审核不通过
	 */
	private Byte auditStatus;
	/**
	 * @mbggenerated
	 */
	private BigDecimal sortPrice;
	/**
	 * @mbggenerated
	 */
	private BigDecimal activityPrice;
	/**
	 * @mbggenerated
	 */
	private BigDecimal cashBalancePrice;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getBiddId() {
		return biddId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBiddId(Integer biddId) {
		this.biddId = biddId;
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
	public Integer getHouseId() {
		return houseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public String getSaleLease() {
		return saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleLease(String saleLease) {
		this.saleLease = saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public Date getBiddingSuccTime() {
		return biddingSuccTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setBiddingSuccTime(Date biddingSuccTime) {
		this.biddingSuccTime = biddingSuccTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getBiddingEndTime() {
		return biddingEndTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setBiddingEndTime(Date biddingEndTime) {
		this.biddingEndTime = biddingEndTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBiddingDays() {
		return biddingDays;
	}

	/**
	 * @mbggenerated
	 */
	public void setBiddingDays(Integer biddingDays) {
		this.biddingDays = biddingDays;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getBiddingPrice() {
		return biddingPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setBiddingPrice(BigDecimal biddingPrice) {
		this.biddingPrice = biddingPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCompPrice() {
		return compPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompPrice(BigDecimal compPrice) {
		this.compPrice = compPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getPersonalPrice() {
		return personalPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setPersonalPrice(BigDecimal personalPrice) {
		this.personalPrice = personalPrice;
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
	public Byte getQqStatus() {
		return qqStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setQqStatus(Byte qqStatus) {
		this.qqStatus = qqStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHaofangStatus() {
		return haofangStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setHaofangStatus(Byte haofangStatus) {
		this.haofangStatus = haofangStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUaType() {
		return uaType;
	}

	/**
	 * @mbggenerated
	 */
	public void setUaType(Byte uaType) {
		this.uaType = uaType;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCompCoin() {
		return compCoin;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompCoin(BigDecimal compCoin) {
		this.compCoin = compCoin;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompUaId() {
		return compUaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompUaId(Integer compUaId) {
		this.compUaId = compUaId;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getPersonalCoin() {
		return personalCoin;
	}

	/**
	 * @mbggenerated
	 */
	public void setPersonalCoin(BigDecimal personalCoin) {
		this.personalCoin = personalCoin;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getBiddSource() {
		return biddSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setBiddSource(Byte biddSource) {
		this.biddSource = biddSource;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSyncFlag() {
		return syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getSortPrice() {
		return sortPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setSortPrice(BigDecimal sortPrice) {
		this.sortPrice = sortPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getActivityPrice() {
		return activityPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setActivityPrice(BigDecimal activityPrice) {
		this.activityPrice = activityPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCashBalancePrice() {
		return cashBalancePrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setCashBalancePrice(BigDecimal cashBalancePrice) {
		this.cashBalancePrice = cashBalancePrice;
	}
}