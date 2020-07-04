package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminFunApartmentRoom implements Serializable {

	/**
	 * @mbggenerated 主键UUID(取消中横线小写)
	 */
	private String uuid;
	/**
	 * @mbggenerated 房源UUID
	 */
	private String apartmentUuid;
	/**
	 * @mbggenerated 以元为单位 例如（2100元/月）：2100
	 */
	private BigDecimal monthRent;
	/**
	 * @mbggenerated 起租时间 例：2015-12-31 12:10:00
	 */
	private Date rentStartDate;
	/**
	 * @mbggenerated 是否支持短租，枚举值 0=不支持 1=支持 例如(支持短租)：1
	 */
	private Byte shortRent;
	/**
	 * @mbggenerated 对于单间出租的，为出租间面积 对于整租的为房屋总面积 单位（㎡）不支持小数 例如：110
	 */
	private BigDecimal rentRoomArea;
	/**
	 * @mbggenerated 租客性别 0=男生 1=女生
	 */
	private Byte rentCustSex;
	/**
	 * @mbggenerated 租客性别要求，0=全男生，1=全女生，2=无所谓
	 */
	private Byte sexRequire;
	/**
	 * @mbggenerated 是否已租出 1=已租出
	 */
	private Byte isRent;
	/**
	 * @mbggenerated 入住时间
	 */
	private Date checkInTime;
	/**
	 * @mbggenerated 是否能立即入住 1=是
	 */
	private Byte immediatelyCheckIn;
	/**
	 * @mbggenerated 房间状态 0=无效 1=有效 2=已出租
	 */
	private Byte roomStatus;
	/**
	 * @mbggenerated 房源编号，A
	 */
	private String houseNum;
	/**
	 * @mbggenerated 房屋配置，枚举值，可多选，以逗号分隔 1=床 2=书桌 3=衣柜 4=折叠椅 5=台灯 6=穿衣镜 7=挂钩 20=空调 21=梳妆台 22=穿衣镜 23=电磁炉 24=微波炉 25=暖气 26=沙发 27=电视 28=智能锁 29=房屋清洁  对应数据字典DIC_TYPE=DETAIL_POINT
	 */
	private String detailPoint;
	/**
	 * @mbggenerated 房间标签，枚举值，可多选，以逗号分隔 1=独卫 2=阳台 3=飘窗 4=空调 5=可加空调 6=两人 7=可月付
	 */
	private String featureTag;
	/**
	 * @mbggenerated 出租屋类型，枚举值。 1=主卧 2=次卧
	 */
	private Byte bedRoomType;
	/**
	 * @mbggenerated 首图地址
	 */
	private String thumbUrl;
	/**
	 * @mbggenerated 分佣比例或佣金金额，配合字段：COMMISSION_TYPE  使用
	 */
	private Integer commissionRate;
	/**
	 * @mbggenerated 创建时间，我们这边insert的时候记录
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 更新时间，我们这边update的时候记录
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 图片张数
	 */
	private Integer photoCount;
	/**
	 * @mbggenerated 第三方房间ID
	 */
	private String outRoomId;
	/**
	 * @mbggenerated 分佣类型，1=比例 2=佣金金额
	 */
	private Integer commissionType;
	/**
	 * @mbggenerated 是否在B端展示 0=不展示 1=展示
	 */
	private Integer isBProducts;
	/**
	 * @mbggenerated 是否在C端展示 0=不展示 1=展示
	 */
	private Integer isCProducts;
	/**
	 * @mbggenerated
	 */
	private Byte listShow;
	/**
	 * @mbggenerated
	 */
	private Byte roomStatusList;
	/**
	 * @mbggenerated
	 */
	private Byte isRentList;
	/**
	 * @mbggenerated
	 */
	private BigDecimal monthRentList;
	/**
	 * @mbggenerated
	 */
	private String immediatelyCheckInList;
	/**
	 * @mbggenerated
	 */
	private Date checkInTimeList;
	/**
	 * @mbggenerated
	 */
	private BigDecimal rentRoomAreaList;
	/**
	 * @mbggenerated
	 */
	private String featureTagList;
	/**
	 * @mbggenerated
	 */
	private Integer photoCountList;
	/**
	 * @mbggenerated 房间描述（50-500字以内）
	 */
	private String houseDesc;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @mbggenerated
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getApartmentUuid() {
		return apartmentUuid;
	}

	/**
	 * @mbggenerated
	 */
	public void setApartmentUuid(String apartmentUuid) {
		this.apartmentUuid = apartmentUuid == null ? null : apartmentUuid.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getMonthRent() {
		return monthRent;
	}

	/**
	 * @mbggenerated
	 */
	public void setMonthRent(BigDecimal monthRent) {
		this.monthRent = monthRent;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRentStartDate() {
		return rentStartDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentStartDate(Date rentStartDate) {
		this.rentStartDate = rentStartDate;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getShortRent() {
		return shortRent;
	}

	/**
	 * @mbggenerated
	 */
	public void setShortRent(Byte shortRent) {
		this.shortRent = shortRent;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getRentRoomArea() {
		return rentRoomArea;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentRoomArea(BigDecimal rentRoomArea) {
		this.rentRoomArea = rentRoomArea;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRentCustSex() {
		return rentCustSex;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentCustSex(Byte rentCustSex) {
		this.rentCustSex = rentCustSex;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSexRequire() {
		return sexRequire;
	}

	/**
	 * @mbggenerated
	 */
	public void setSexRequire(Byte sexRequire) {
		this.sexRequire = sexRequire;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsRent() {
		return isRent;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsRent(Byte isRent) {
		this.isRent = isRent;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCheckInTime() {
		return checkInTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getImmediatelyCheckIn() {
		return immediatelyCheckIn;
	}

	/**
	 * @mbggenerated
	 */
	public void setImmediatelyCheckIn(Byte immediatelyCheckIn) {
		this.immediatelyCheckIn = immediatelyCheckIn;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRoomStatus() {
		return roomStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoomStatus(Byte roomStatus) {
		this.roomStatus = roomStatus;
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
	public String getDetailPoint() {
		return detailPoint;
	}

	/**
	 * @mbggenerated
	 */
	public void setDetailPoint(String detailPoint) {
		this.detailPoint = detailPoint == null ? null : detailPoint.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFeatureTag() {
		return featureTag;
	}

	/**
	 * @mbggenerated
	 */
	public void setFeatureTag(String featureTag) {
		this.featureTag = featureTag == null ? null : featureTag.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getBedRoomType() {
		return bedRoomType;
	}

	/**
	 * @mbggenerated
	 */
	public void setBedRoomType(Byte bedRoomType) {
		this.bedRoomType = bedRoomType;
	}

	/**
	 * @mbggenerated
	 */
	public String getThumbUrl() {
		return thumbUrl;
	}

	/**
	 * @mbggenerated
	 */
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl == null ? null : thumbUrl.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCommissionRate() {
		return commissionRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setCommissionRate(Integer commissionRate) {
		this.commissionRate = commissionRate;
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
	public Integer getPhotoCount() {
		return photoCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoCount(Integer photoCount) {
		this.photoCount = photoCount;
	}

	/**
	 * @mbggenerated
	 */
	public String getOutRoomId() {
		return outRoomId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutRoomId(String outRoomId) {
		this.outRoomId = outRoomId == null ? null : outRoomId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCommissionType() {
		return commissionType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCommissionType(Integer commissionType) {
		this.commissionType = commissionType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getIsBProducts() {
		return isBProducts;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsBProducts(Integer isBProducts) {
		this.isBProducts = isBProducts;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getIsCProducts() {
		return isCProducts;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsCProducts(Integer isCProducts) {
		this.isCProducts = isCProducts;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getListShow() {
		return listShow;
	}

	/**
	 * @mbggenerated
	 */
	public void setListShow(Byte listShow) {
		this.listShow = listShow;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRoomStatusList() {
		return roomStatusList;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoomStatusList(Byte roomStatusList) {
		this.roomStatusList = roomStatusList;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsRentList() {
		return isRentList;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsRentList(Byte isRentList) {
		this.isRentList = isRentList;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getMonthRentList() {
		return monthRentList;
	}

	/**
	 * @mbggenerated
	 */
	public void setMonthRentList(BigDecimal monthRentList) {
		this.monthRentList = monthRentList;
	}

	/**
	 * @mbggenerated
	 */
	public String getImmediatelyCheckInList() {
		return immediatelyCheckInList;
	}

	/**
	 * @mbggenerated
	 */
	public void setImmediatelyCheckInList(String immediatelyCheckInList) {
		this.immediatelyCheckInList = immediatelyCheckInList == null ? null : immediatelyCheckInList.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCheckInTimeList() {
		return checkInTimeList;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckInTimeList(Date checkInTimeList) {
		this.checkInTimeList = checkInTimeList;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getRentRoomAreaList() {
		return rentRoomAreaList;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentRoomAreaList(BigDecimal rentRoomAreaList) {
		this.rentRoomAreaList = rentRoomAreaList;
	}

	/**
	 * @mbggenerated
	 */
	public String getFeatureTagList() {
		return featureTagList;
	}

	/**
	 * @mbggenerated
	 */
	public void setFeatureTagList(String featureTagList) {
		this.featureTagList = featureTagList == null ? null : featureTagList.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPhotoCountList() {
		return photoCountList;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoCountList(Integer photoCountList) {
		this.photoCountList = photoCountList;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseDesc() {
		return houseDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc == null ? null : houseDesc.trim();
	}
}