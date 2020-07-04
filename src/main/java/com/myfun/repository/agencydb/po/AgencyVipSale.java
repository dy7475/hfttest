package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgencyVipSale implements Serializable {
    /**
	 * @mbggenerated 城市ID
	 */
	private Short cityId;
	/**
	 * @mbggenerated 房源ID
	 */
	private Integer saleId;
	/**
	 * @mbggenerated 楼盘ID
	 */
	private Integer buildId;
	/**
	 * @mbggenerated 楼盘名称
	 */
	private String buildName;
	/**
	 * @mbggenerated 楼盘地址
	 */
	private String buildAddr;
	/**
	 * @mbggenerated 行政区ID
	 */
	private Integer buildRegion;
	/**
	 * @mbggenerated 行政区名称
	 */
	private String regionName;
	/**
	 * @mbggenerated 片区ID
	 */
	private Integer sectionId;
	/**
	 * @mbggenerated 片区名称
	 */
	private String sectionName;
	/**
	 * @mbggenerated 房源标题
	 */
	private String houseSubject;
	/**
	 * @mbggenerated 房屋用途
	 */
	private String houseUseage;
	/**
	 * @mbggenerated 房屋类型
	 */
	private String houseType;
	/**
	 * @mbggenerated 房屋结构
	 */
	private String houseStruct;
	/**
	 * @mbggenerated 房屋年代
	 */
	private String houseYear;
	/**
	 * @mbggenerated 房屋朝向
	 */
	private String houseDirect;
	/**
	 * @mbggenerated 房屋产权
	 */
	private String houseRight;
	/**
	 * @mbggenerated 装修情况
	 */
	private String houseFitment;
	/**
	 * @mbggenerated 楼层
	 */
	private Short houseFloor;
	/**
	 * @mbggenerated 总楼层
	 */
	private Short houseFloors;
	/**
	 * @mbggenerated 几房（户型）
	 */
	private Byte houseRoom;
	/**
	 * @mbggenerated 几厅（户型）
	 */
	private Byte houseHall;
	/**
	 * @mbggenerated 几卫（户型）
	 */
	private Byte houseWei;
	/**
	 * @mbggenerated 面积（取整）
	 */
	private BigDecimal houseArea;
	/**
	 * @mbggenerated 价格
	 */
	private BigDecimal price;
	/**
	 * @mbggenerated 最低价格
	 */
	private BigDecimal priceMin;
	/**
	 * @mbggenerated 其他说明
	 */
	private String descp;
	/**
	 * @mbggenerated 有效期
	 */
	private Byte period;
	/**
	 * @mbggenerated 佣金比例
	 */
	private BigDecimal commission;
	/**
	 * @mbggenerated 保证金
	 */
	private Integer cashDeposit;
	/**
	 * @mbggenerated 客户ID
	 */
	private Integer clientId;
	/**
	 * @mbggenerated 登记时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 最后跟进人
	 */
	private Integer trackUser;
	/**
	 * @mbggenerated 最后跟进时间
	 */
	private Date trackTime;
	/**
	 * @mbggenerated 信息状态
	 */
	private Integer caseStatus;
	/**
	 * @mbggenerated 评定出售金额
	 */
	private Integer tradePrice;
	/**
	 * @mbggenerated 最多出售次数
	 */
	private Integer tradeTimes;
	/**
	 * @mbggenerated 定价人
	 */
	private Integer tradeUser;
	/**
	 * @mbggenerated 定价时间
	 */
	private Date tradeTime;
	/**
	 * @mbggenerated 可售标记
	 */
	private Byte tradeFlag;
	/**
	 * @mbggenerated 客户来源
	 */
	private Byte infoSource;
	/**
	 * @mbggenerated 重复标记
	 */
	private Byte repeatFlag;
	/**
	 * @mbggenerated 创建人
	 */
	private Integer creatorUid;
	/**
	 * @mbggenerated 是否有楼盘
	 */
	private Byte buildFlag;
	/**
	 * @mbggenerated 是否有新投诉
	 */
	private Byte newComplain;
	/**
	 * @mbggenerated 房屋现状
	 */
	private String houseState;
	/**
	 * @mbggenerated 栋
	 */
	private String houseRoof;
	/**
	 * @mbggenerated 单元
	 */
	private String houseUnit;
	/**
	 * @mbggenerated 号
	 */
	private String houseNum;
	/**
	 * @mbggenerated 最后投诉时间
	 */
	private Date complainTime;
	/**
	 * @mbggenerated 是否有退费
	 */
	private Byte hasRefund;
	/**
	 * @mbggenerated 最后退费时间
	 */
	private Date refundTime;
	/**
	 * @mbggenerated 购买次数
	 */
	private Byte purchaseCount;
	/**
	 * @mbggenerated 投诉次数
	 */
	private Byte complainCount;
	/**
	 * @mbggenerated 下架时间
	 */
	private Date downTime;
	/**
	 * @mbggenerated 购买人数已满时间
	 */
	private Date fullTime;
	/**
	 * @mbggenerated 下架跟进ID
	 */
	private Integer downTrackid;
	/**
	 * @mbggenerated ISURGENT
	 */
	private Byte isurgent;
	/**
	 * @mbggenerated 关联搜搜ID
	 */
	private Integer sosoId;
	/**
	 * @mbggenerated 关联UGC的ID
	 */
	private Integer ugcId;
	/**
	 * @mbggenerated WX_ID
	 */
	private Integer wxId;
	/**
	 * @mbggenerated LAST_PUSH_TIME
	 */
	private Date lastPushTime;
	/**
	 * @mbggenerated UGC_DATATYPE
	 */
	private Byte ugcDatatype;
	/**
	 * @mbggenerated WF_STATUS
	 */
	private Byte wfStatus;
	/**
	 * @mbggenerated CANCEL_REASON
	 */
	private String cancelReason;
	/**
	 * @mbggenerated IS_VIP
	 */
	private Byte isVip;
	/**
	 * @mbggenerated IS_HELP
	 */
	private Byte isHelp;
	/**
	 * @mbggenerated
	 */
	private Integer jiedanCount;
	/**
	 * @mbggenerated
	 */
	private Byte pushmsgLockflag;
	/**
	 * @mbggenerated
	 */
	private Date lastPushmsgTime;
	/**
	 * @mbggenerated 推送到的经纪人或者专属委托经纪人的档案ID
	 */
	private String wfArchives;
	/**
	 * @mbggenerated
	 */
	private Integer wfPushTimes;
	/**
	 * @mbggenerated
	 */
	private String wfFee;
	/**
	 * @mbggenerated
	 */
	private Integer wfSex;
	/**
	 * @mbggenerated
	 */
	private Byte ugcDatetype;
	/**
	 * @mbggenerated 委托来源 1 微信  2 APP 3 SOLR 4优家公众号
	 */
	private Byte sourceType;
	/**
	 * @mbggenerated 更新时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 对应solr资源
	 */
	private Byte solrResource;
	/**
	 * @mbggenerated 是否是从搜搜导入进来的数据，默认:0不是、1:是
	 */
	private Byte isIntoQueue;
	/**
	 * @mbggenerated 关联导入进来表的ID，需要与solr_resource联合判断来源表
	 */
	private Integer saleIdPk;
	/**
	 * @mbggenerated mongo上是否删除
	 */
	private Byte mongoDelete;
	/**
	 * @mbggenerated 图片数量
	 */
	private Integer picNum;
	/**
	 * @mbggenerated
	 */
	private String downReason;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * @mbggenerated
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSaleId() {
		return saleId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
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
		this.buildName = buildName == null ? null : buildName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuildAddr() {
		return buildAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildAddr(String buildAddr) {
		this.buildAddr = buildAddr == null ? null : buildAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBuildRegion() {
		return buildRegion;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildRegion(Integer buildRegion) {
		this.buildRegion = buildRegion;
	}

	/**
	 * @mbggenerated
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName == null ? null : regionName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @mbggenerated
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName == null ? null : sectionName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseSubject() {
		return houseSubject;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseSubject(String houseSubject) {
		this.houseSubject = houseSubject == null ? null : houseSubject.trim();
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
		this.houseUseage = houseUseage == null ? null : houseUseage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType == null ? null : houseType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseStruct() {
		return houseStruct;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseStruct(String houseStruct) {
		this.houseStruct = houseStruct == null ? null : houseStruct.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseYear() {
		return houseYear;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseYear(String houseYear) {
		this.houseYear = houseYear == null ? null : houseYear.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseDirect() {
		return houseDirect;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseDirect(String houseDirect) {
		this.houseDirect = houseDirect == null ? null : houseDirect.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseRight() {
		return houseRight;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRight(String houseRight) {
		this.houseRight = houseRight == null ? null : houseRight.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseFitment() {
		return houseFitment;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseFitment(String houseFitment) {
		this.houseFitment = houseFitment == null ? null : houseFitment.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Short getHouseFloor() {
		return houseFloor;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseFloor(Short houseFloor) {
		this.houseFloor = houseFloor;
	}

	/**
	 * @mbggenerated
	 */
	public Short getHouseFloors() {
		return houseFloors;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseFloors(Short houseFloors) {
		this.houseFloors = houseFloors;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseRoom() {
		return houseRoom;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseHall() {
		return houseHall;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseHall(Byte houseHall) {
		this.houseHall = houseHall;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseWei() {
		return houseWei;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseWei(Byte houseWei) {
		this.houseWei = houseWei;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getHouseArea() {
		return houseArea;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
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
	public BigDecimal getPriceMin() {
		return priceMin;
	}

	/**
	 * @mbggenerated
	 */
	public void setPriceMin(BigDecimal priceMin) {
		this.priceMin = priceMin;
	}

	/**
	 * @mbggenerated
	 */
	public String getDescp() {
		return descp;
	}

	/**
	 * @mbggenerated
	 */
	public void setDescp(String descp) {
		this.descp = descp == null ? null : descp.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPeriod() {
		return period;
	}

	/**
	 * @mbggenerated
	 */
	public void setPeriod(Byte period) {
		this.period = period;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCommission() {
		return commission;
	}

	/**
	 * @mbggenerated
	 */
	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCashDeposit() {
		return cashDeposit;
	}

	/**
	 * @mbggenerated
	 */
	public void setCashDeposit(Integer cashDeposit) {
		this.cashDeposit = cashDeposit;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @mbggenerated
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
	public Integer getTrackUser() {
		return trackUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackUser(Integer trackUser) {
		this.trackUser = trackUser;
	}

	/**
	 * @mbggenerated
	 */
	public Date getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackTime(Date trackTime) {
		this.trackTime = trackTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseStatus(Integer caseStatus) {
		this.caseStatus = caseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTradePrice() {
		return tradePrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradePrice(Integer tradePrice) {
		this.tradePrice = tradePrice;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTradeTimes() {
		return tradeTimes;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradeTimes(Integer tradeTimes) {
		this.tradeTimes = tradeTimes;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTradeUser() {
		return tradeUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradeUser(Integer tradeUser) {
		this.tradeUser = tradeUser;
	}

	/**
	 * @mbggenerated
	 */
	public Date getTradeTime() {
		return tradeTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getTradeFlag() {
		return tradeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradeFlag(Byte tradeFlag) {
		this.tradeFlag = tradeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getInfoSource() {
		return infoSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setInfoSource(Byte infoSource) {
		this.infoSource = infoSource;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRepeatFlag() {
		return repeatFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepeatFlag(Byte repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreatorUid() {
		return creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getBuildFlag() {
		return buildFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildFlag(Byte buildFlag) {
		this.buildFlag = buildFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getNewComplain() {
		return newComplain;
	}

	/**
	 * @mbggenerated
	 */
	public void setNewComplain(Byte newComplain) {
		this.newComplain = newComplain;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseState() {
		return houseState;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseState(String houseState) {
		this.houseState = houseState == null ? null : houseState.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseRoof() {
		return houseRoof;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRoof(String houseRoof) {
		this.houseRoof = houseRoof == null ? null : houseRoof.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseUnit() {
		return houseUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUnit(String houseUnit) {
		this.houseUnit = houseUnit == null ? null : houseUnit.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseNum() {
		return houseNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum == null ? null : houseNum.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getComplainTime() {
		return complainTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplainTime(Date complainTime) {
		this.complainTime = complainTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHasRefund() {
		return hasRefund;
	}

	/**
	 * @mbggenerated
	 */
	public void setHasRefund(Byte hasRefund) {
		this.hasRefund = hasRefund;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRefundTime() {
		return refundTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPurchaseCount() {
		return purchaseCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setPurchaseCount(Byte purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getComplainCount() {
		return complainCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplainCount(Byte complainCount) {
		this.complainCount = complainCount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getDownTime() {
		return downTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDownTime(Date downTime) {
		this.downTime = downTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getFullTime() {
		return fullTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setFullTime(Date fullTime) {
		this.fullTime = fullTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDownTrackid() {
		return downTrackid;
	}

	/**
	 * @mbggenerated
	 */
	public void setDownTrackid(Integer downTrackid) {
		this.downTrackid = downTrackid;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsurgent() {
		return isurgent;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsurgent(Byte isurgent) {
		this.isurgent = isurgent;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSosoId() {
		return sosoId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSosoId(Integer sosoId) {
		this.sosoId = sosoId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUgcId() {
		return ugcId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUgcId(Integer ugcId) {
		this.ugcId = ugcId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWxId() {
		return wxId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWxId(Integer wxId) {
		this.wxId = wxId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getLastPushTime() {
		return lastPushTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLastPushTime(Date lastPushTime) {
		this.lastPushTime = lastPushTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUgcDatatype() {
		return ugcDatatype;
	}

	/**
	 * @mbggenerated
	 */
	public void setUgcDatatype(Byte ugcDatatype) {
		this.ugcDatatype = ugcDatatype;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWfStatus() {
		return wfStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfStatus(Byte wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getCancelReason() {
		return cancelReason;
	}

	/**
	 * @mbggenerated
	 */
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason == null ? null : cancelReason.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsVip() {
		return isVip;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsVip(Byte isVip) {
		this.isVip = isVip;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsHelp() {
		return isHelp;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsHelp(Byte isHelp) {
		this.isHelp = isHelp;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getJiedanCount() {
		return jiedanCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setJiedanCount(Integer jiedanCount) {
		this.jiedanCount = jiedanCount;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPushmsgLockflag() {
		return pushmsgLockflag;
	}

	/**
	 * @mbggenerated
	 */
	public void setPushmsgLockflag(Byte pushmsgLockflag) {
		this.pushmsgLockflag = pushmsgLockflag;
	}

	/**
	 * @mbggenerated
	 */
	public Date getLastPushmsgTime() {
		return lastPushmsgTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLastPushmsgTime(Date lastPushmsgTime) {
		this.lastPushmsgTime = lastPushmsgTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getWfArchives() {
		return wfArchives;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfArchives(String wfArchives) {
		this.wfArchives = wfArchives == null ? null : wfArchives.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfPushTimes() {
		return wfPushTimes;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfPushTimes(Integer wfPushTimes) {
		this.wfPushTimes = wfPushTimes;
	}

	/**
	 * @mbggenerated
	 */
	public String getWfFee() {
		return wfFee;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfFee(String wfFee) {
		this.wfFee = wfFee == null ? null : wfFee.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWfSex() {
		return wfSex;
	}

	/**
	 * @mbggenerated
	 */
	public void setWfSex(Integer wfSex) {
		this.wfSex = wfSex;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getUgcDatetype() {
		return ugcDatetype;
	}

	/**
	 * @mbggenerated
	 */
	public void setUgcDatetype(Byte ugcDatetype) {
		this.ugcDatetype = ugcDatetype;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSourceType() {
		return sourceType;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceType(Byte sourceType) {
		this.sourceType = sourceType;
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
	public Byte getSolrResource() {
		return solrResource;
	}

	/**
	 * @mbggenerated
	 */
	public void setSolrResource(Byte solrResource) {
		this.solrResource = solrResource;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsIntoQueue() {
		return isIntoQueue;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsIntoQueue(Byte isIntoQueue) {
		this.isIntoQueue = isIntoQueue;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSaleIdPk() {
		return saleIdPk;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleIdPk(Integer saleIdPk) {
		this.saleIdPk = saleIdPk;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getMongoDelete() {
		return mongoDelete;
	}

	/**
	 * @mbggenerated
	 */
	public void setMongoDelete(Byte mongoDelete) {
		this.mongoDelete = mongoDelete;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPicNum() {
		return picNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setPicNum(Integer picNum) {
		this.picNum = picNum;
	}

	/**
	 * @mbggenerated
	 */
	public String getDownReason() {
		return downReason;
	}

	/**
	 * @mbggenerated
	 */
	public void setDownReason(String downReason) {
		this.downReason = downReason == null ? null : downReason.trim();
	}

	private Integer ugcDateType;
    
    
    
    public Integer getUgcDateType() {
		return ugcDateType;
	}

	public void setUgcDateType(Integer ugcDateType) {
		this.ugcDateType = ugcDateType;
	}
}