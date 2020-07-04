package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunHouseBidding extends ShardDb implements Serializable {

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
	 * @mbggenerated 租售类型，DD:CASE_TYPE
	 */
	private Byte saleLease;
	/**
	 * @mbggenerated 用途，DD:HOUSE_USEAGE
	 */
	private Byte houseUseage;
	/**
	 * @mbggenerated 楼盘ID
	 */
	private Integer buildId;
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
	 * @mbggenerated ，0:为无效
	 */
	private Byte qqStatus;
	/**
	 * @mbggenerated ，0:为无效
	 */
	private Byte haofangStatus;
	/**
	 * @mbggenerated ，1=公司
	 */
	private Byte uaType;
	/**
	 * @mbggenerated 更新时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 公司账户
	 */
	private Integer compUaId;
	/**
	 * @mbggenerated 好房币的使用量
	 */
	private BigDecimal personalCoin;
	/**
	 * @mbggenerated 公司好房币的使用量
	 */
	private BigDecimal compCoin;
	/**
	 * @mbggenerated 个人账户
	 */
	private Integer uaId;
	/**
	 * @mbggenerated 竞价的来源
	 */
	private Byte biddSource;
	/**
	 * @mbggenerated 优优竞价状态  1:有效 0:下架,可在继续推广 2:停止推广
	 */
	private Byte yyStatus;
	/**
	 * @mbggenerated 头条广告审核人ID
	 */
	private Integer auditUserId;
	/**
	 * @mbggenerated 头条广告审核人姓名
	 */
	private String auditUserName;
	/**
	 * @mbggenerated 头条广告审核时间
	 */
	private Date auditTime;
	/**
	 * @mbggenerated 头条广告ID
	 */
	private Integer adId;
	/**
	 * @mbggenerated 审核状态0=未审核 1=审核通过 2=审核不通过
	 */
	private Byte auditStatus;
	/**
	 * @mbggenerated 头条审核锁定人ID
	 */
	private Integer lockedUserId;
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
	public Byte getSaleLease() {
		return saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleLease(Byte saleLease) {
		this.saleLease = saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
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
	public Integer getUaId() {
		return uaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUaId(Integer uaId) {
		this.uaId = uaId;
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
	public Byte getYyStatus() {
		return yyStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setYyStatus(Byte yyStatus) {
		this.yyStatus = yyStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditUserId() {
		return auditUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}

	/**
	 * @mbggenerated
	 */
	public String getAuditUserName() {
		return auditUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName == null ? null : auditUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAdId() {
		return adId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAdId(Integer adId) {
		this.adId = adId;
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
	public Integer getLockedUserId() {
		return lockedUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setLockedUserId(Integer lockedUserId) {
		this.lockedUserId = lockedUserId;
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

	/**
	 * @mbggenerated
	 */
	public ErpFunHouseBidding() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunHouseBidding(Integer shardCityId, Integer biddId) {
		super(shardCityId);
		this.biddId = biddId;
	}
}