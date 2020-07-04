package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminFunBuildingBidding implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer biddingId;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 楼盘ID
	 */
	private Integer buildId;
	/**
	 * @mbggenerated 楼盘名
	 */
	private String buildName;
	/**
	 * @mbggenerated 开始时间
	 */
	private Date beginTime;
	/**
	 * @mbggenerated 结束时间
	 */
	private Date endTime;
	/**
	 * @mbggenerated 档案ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 本次总扣费金额
	 */
	private BigDecimal price;
	/**
	 * @mbggenerated 公司资金账户扣费额度（好房币+优惠券）
	 */
	private BigDecimal compPrice;
	/**
	 * @mbggenerated 个人资金账户扣费额度（好房币+优惠券）
	 */
	private BigDecimal personalPrice;
	/**
	 * @mbggenerated 是否是第一名，值：1、0，用于最后扣费
	 */
	private Byte isTop;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private Byte qqStatus;
	/**
	 * @mbggenerated 1入住成功
	 */
	private Byte haofangStatus;
	/**
	 * @mbggenerated 任务里面需要，ERP里面不需要判断这个,1已扣费、0尚未扣费
	 */
	private Byte payFlag;
	/**
	 * @mbggenerated
	 */
	private String extCode400;
	/**
	 * @mbggenerated 更新时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 资金账户类型 1=公司账户 2=个人账户 3=公司和个人账户都用了
	 */
	private Byte uaType;
	/**
	 * @mbggenerated 资金账户ID
	 */
	private Integer uaId;
	/**
	 * @mbggenerated 个人支付的好房币额度（好房币）
	 */
	private BigDecimal personalCoin;
	/**
	 * @mbggenerated 公司支付的好房币额度（好房币）
	 */
	private BigDecimal compCoin;
	/**
	 * @mbggenerated 用户所在公司的UA_ID
	 */
	private Integer compUaId;
	/**
	 * @mbggenerated 1=erp竞价 3：系统自动竞价 - 陈文超、5：配合优优系统自动竞价的小区专家-陈文超
	 */
	private Byte biddSource;
	/**
	 * @mbggenerated 1、退费(用于竞价失败标记成功退费)、2、竞价成功后等于2
	 */
	private Byte returnPrice;
	/**
	 * @mbggenerated 暂时没有使用该字段
	 */
	private Byte syncFlag;
	/**
	 * @mbggenerated 是否将竞价的结果同步到优优业务中，1:已同步、默认:0 ----陈文超
	 */
	private Byte youyouBizSyncFlag;
	/**
	 * @mbggenerated 排序价格，价格不会受到vip和非vip的打折的影响
	 */
	private BigDecimal sortPrice;
	/**
	 * @mbggenerated 推广活动，参考资金账户表的SHARE_MONEY字段一起使用
	 */
	private BigDecimal activityPrice;
	/**
	 * @mbggenerated 现金余额，参考资金账户表的CASH_MONEY字段一起使用
	 */
	private BigDecimal cashBalancePrice;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getBiddingId() {
		return biddingId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBiddingId(Integer biddingId) {
		this.biddingId = biddingId;
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
	public String getBuildName() {
		return buildName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * @mbggenerated
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @mbggenerated
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
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
	public Byte getIsTop() {
		return isTop;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsTop(Byte isTop) {
		this.isTop = isTop;
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
	public Byte getPayFlag() {
		return payFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayFlag(Byte payFlag) {
		this.payFlag = payFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getExtCode400() {
		return extCode400;
	}

	/**
	 * @mbggenerated
	 */
	public void setExtCode400(String extCode400) {
		this.extCode400 = extCode400;
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
	public Byte getReturnPrice() {
		return returnPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setReturnPrice(Byte returnPrice) {
		this.returnPrice = returnPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSyncFlag() {
		return syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncFlag(Byte syncFlag) {
		this.syncFlag = syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getYouyouBizSyncFlag() {
		return youyouBizSyncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setYouyouBizSyncFlag(Byte youyouBizSyncFlag) {
		this.youyouBizSyncFlag = youyouBizSyncFlag;
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