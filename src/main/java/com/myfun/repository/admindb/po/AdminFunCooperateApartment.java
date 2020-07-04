package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminFunCooperateApartment implements Serializable {

	/**
	 * @mbggenerated GID唯一表示(取消中横线小写)
	 */
	private String uuid;
	/**
	 * @mbggenerated 合作公寓系统 现有：优客=G1AT9S、水滴=JA9H81、LZ8KU1=爱上租品牌公寓 LZ8KU2=爱上租服务公寓
	 */
	private String appId;
	/**
	 * @mbggenerated 合作公寓系统的房屋id
	 */
	private String outHouseId;
	/**
	 * @mbggenerated 合作公寓系统的房屋视频url
	 */
	private String videoUrl;
	/**
	 * @mbggenerated 公寓配套服务，枚举值，可多选，以逗号分隔 1=健身房 2=公寓超市 3=智能门锁 4=ATM机 5=代收快递 6=专属客服 7=房间清洁
	 */
	private String servicePoint;
	/**
	 * @mbggenerated 月租金，以元为单位
	 */
	private BigDecimal monthRent;
	/**
	 * @mbggenerated 出租开始时间
	 */
	private Date rentStartDate;
	/**
	 * @mbggenerated 是否支持短租，枚举值 0=不支持 1=支持 例如(支持短租)：1
	 */
	private Byte shortRent;
	/**
	 * @mbggenerated 房屋所在小区详细地址
	 */
	private String street;
	/**
	 * @mbggenerated 房屋附近地铁站所在线路名
	 */
	private String subwayLine;
	/**
	 * @mbggenerated 房屋附近地铁站名
	 */
	private String subwayStation;
	/**
	 * @mbggenerated 房间位置标注-经度
	 */
	private String xCoord;
	/**
	 * @mbggenerated 房间位置标注-纬度
	 */
	private String yCoord;
	/**
	 * @mbggenerated 房管员手机号
	 */
	private String agentPhone;
	/**
	 * @mbggenerated 出租方式，枚举值 1=整套出租 2=单间出租 例如：1
	 */
	private Byte rentType;
	/**
	 * @mbggenerated 房屋户型-室
	 */
	private String bedRoomNum;
	/**
	 * @mbggenerated 房屋户型-厅
	 */
	private String livingRoomNum;
	/**
	 * @mbggenerated 房屋户型-卫
	 */
	private String toiletNum;
	/**
	 * @mbggenerated 该字段表示房源信息的总面积，对于单间出租的，为出租间面积对于整租的为房屋总面积,单位（㎡）不支持小数。
	 */
	private BigDecimal rentRoomArea;
	/**
	 * @mbggenerated 出租屋类型，枚举值。 1=主卧 2=次卧
	 */
	private Byte bedRoomType;
	/**
	 * @mbggenerated 朝向，枚举值。 0=东 1=南 2=西 3=北 4=东南 5=西南 6=东北 7=西北 8=东西 9=南北 例如（朝南）：1
	 */
	private Byte faceToType;
	/**
	 * @mbggenerated 房间编号，单间出租时的编号
	 */
	private String houseNum;
	/**
	 * @mbggenerated 总楼层
	 */
	private Integer totalFloor;
	/**
	 * @mbggenerated 所在楼层
	 */
	private String houseFloor;
	/**
	 * @mbggenerated 房间标签，枚举值，可多选，以逗号分隔 1=独卫 2=阳台 3=飘窗 4=空调 7=可月付  对应数据字典DIC_TYPE=FEATURE_TAG
	 */
	private String featureTag;
	/**
	 * @mbggenerated 房管员姓名
	 */
	private String agentName;
	/**
	 * @mbggenerated 租客性别 0=男生 1=女生
	 */
	private Integer rentCustSex;
	/**
	 * @mbggenerated 租客性别要求，0=全男生，1=全女生，2=无所谓
	 */
	private Byte sexRequire;
	/**
	 * @mbggenerated 是否出租 0=未租 1=已租
	 */
	private Byte isRent;
	/**
	 * @mbggenerated 合作系统区域ID
	 */
	private Integer hftRegId;
	/**
	 * @mbggenerated 合作系统区域名称
	 */
	private String hftRegName;
	/**
	 * @mbggenerated 分佣比例或分佣金额，配合 COMMISSION_TYPE 字段使用
	 */
	private Integer commissionRate;
	/**
	 * @mbggenerated 装修，枚举 1=毛坯 2=普通 3=精装 4=中等 5=高档 6=豪装 7=均可
	 */
	private Byte apartmentFitment;
	/**
	 * @mbggenerated 公共区域设施，枚举值 8=无线WIFI 9=公共储物区 10=餐桌 11=餐椅 12=冰箱 13=洗衣机 14=热水器 15=浴霸 16=公用厨房 17=离地铁近 18=独立卫生间 19=厨房   对应数据字典DIC_TYPE=DETAIL_POINT
	 */
	private String servicePublic;
	/**
	 * @mbggenerated 更新时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 合作公寓编号
	 */
	private String outHouseNo;
	/**
	 * @mbggenerated 房屋配置，枚举值，可多选，以逗号分隔 1=床 2=书桌 3=衣柜 4=折叠椅 5=台灯 6=穿衣镜 7=挂钩 20=空调 21=梳妆台 22=穿衣镜 23=电磁炉 24=微波炉 25=暖气 26=沙发 27=电视 28=智能锁 29=房屋清洁  对应数据字典DIC_TYPE=DETAIL_POINT
	 */
	private String detailPoint;
	/**
	 * @mbggenerated 入住时间
	 */
	private Date checkInTime;
	/**
	 * @mbggenerated 是否可以立即入住 0=不能 1=能
	 */
	private Byte immediatelyCheckIn;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 城市名称
	 */
	private String cityName;
	/**
	 * @mbggenerated 是否在B端 0=不展示 1=展示
	 */
	private Byte isBProducts;
	/**
	 * @mbggenerated 好房通楼盘ID
	 */
	private Integer hftBuildId;
	/**
	 * @mbggenerated 好房通楼盘名称
	 */
	private String hftBuildName;
	/**
	 * @mbggenerated 好房通板块ID（多个逗号分隔）
	 */
	private String hftSectionId;
	/**
	 * @mbggenerated 好房通板块名称（多个逗号分隔）
	 */
	private String hftSectionName;
	/**
	 * @mbggenerated 第三方公寓的楼盘ID
	 */
	private Integer aptBuildId;
	/**
	 * @mbggenerated 第三方公寓的楼盘名称
	 */
	private String aptBuildName;
	/**
	 * @mbggenerated 房屋状态 1=有效 2=已下架 第三方更新
	 */
	private Integer houseStatus;
	/**
	 * @mbggenerated 查看次数，每次查看详情的时候+1
	 */
	private Integer viewCount;
	/**
	 * @mbggenerated 房源标题（100个中文字符以内）
	 */
	private String houseTitle;
	/**
	 * @mbggenerated C端上架时间，由crm修改
	 */
	private Date upTime;
	/**
	 * @mbggenerated C端下架时间，由crm修改
	 */
	private Date downTime;
	/**
	 * @mbggenerated 是否在C端展示 0=不展示 1=展示
	 */
	private Byte isCProducts;
	/**
	 * @mbggenerated 首图地址
	 */
	private String thumbUrl;
	/**
	 * @mbggenerated 当前入住者性别 1=全男生，2=全女生，还剩一间没有入住的时候修改这个值
	 */
	private Byte sexNow;
	/**
	 * @mbggenerated B端上架时间
	 */
	private Date bUpTime;
	/**
	 * @mbggenerated B端 下架时间
	 */
	private Date bDownTime;
	/**
	 * @mbggenerated 出租中的房间列表，多个使用英文逗号分隔，例：A,B,D
	 */
	private String rentRooms;
	/**
	 * @mbggenerated 房管家头像
	 */
	private String agentPhoto;
	/**
	 * @mbggenerated 楼盘环域 DIC_TYPE=HOUSE_ROUND
	 */
	private Byte buildRound;
	/**
	 * @mbggenerated 创建时间，由我们这边insert的时候生成
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 真实的房源uuid，整租有多间房的时候会把房间放到房源表上，就会有这个uuid做记录
	 */
	private String realUuid;
	/**
	 * @mbggenerated 图片张数
	 */
	private Integer photoCount;
	/**
	 * @mbggenerated 0待审核 1审核成功 2审核失败
	 */
	private Byte auditStatus;
	/**
	 * @mbggenerated 审核时间
	 */
	private Date auditTime;
	/**
	 * @mbggenerated 第三方房间ID，整租时会用
	 */
	private String outRoomId;
	/**
	 * @mbggenerated 分佣类型，1=比例 2=佣金金额
	 */
	private Integer commissionType;
	/**
	 * @mbggenerated 公寓品牌名称
	 */
	private String brandName;
	/**
	 * @mbggenerated 房间描述（50-500字以内）
	 */
	private String houseDesc;
	/**
	 * @mbggenerated 第三方post过来的原始数据json字符串
	 */
	private String aptPostJson;
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
	public String getAppId() {
		return appId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOutHouseId() {
		return outHouseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutHouseId(String outHouseId) {
		this.outHouseId = outHouseId == null ? null : outHouseId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * @mbggenerated
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl == null ? null : videoUrl.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getServicePoint() {
		return servicePoint;
	}

	/**
	 * @mbggenerated
	 */
	public void setServicePoint(String servicePoint) {
		this.servicePoint = servicePoint == null ? null : servicePoint.trim();
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
	public String getStreet() {
		return street;
	}

	/**
	 * @mbggenerated
	 */
	public void setStreet(String street) {
		this.street = street == null ? null : street.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSubwayLine() {
		return subwayLine;
	}

	/**
	 * @mbggenerated
	 */
	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine == null ? null : subwayLine.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSubwayStation() {
		return subwayStation;
	}

	/**
	 * @mbggenerated
	 */
	public void setSubwayStation(String subwayStation) {
		this.subwayStation = subwayStation == null ? null : subwayStation.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getxCoord() {
		return xCoord;
	}

	/**
	 * @mbggenerated
	 */
	public void setxCoord(String xCoord) {
		this.xCoord = xCoord == null ? null : xCoord.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getyCoord() {
		return yCoord;
	}

	/**
	 * @mbggenerated
	 */
	public void setyCoord(String yCoord) {
		this.yCoord = yCoord == null ? null : yCoord.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getAgentPhone() {
		return agentPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone == null ? null : agentPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRentType() {
		return rentType;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentType(Byte rentType) {
		this.rentType = rentType;
	}

	/**
	 * @mbggenerated
	 */
	public String getBedRoomNum() {
		return bedRoomNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setBedRoomNum(String bedRoomNum) {
		this.bedRoomNum = bedRoomNum == null ? null : bedRoomNum.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLivingRoomNum() {
		return livingRoomNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setLivingRoomNum(String livingRoomNum) {
		this.livingRoomNum = livingRoomNum == null ? null : livingRoomNum.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getToiletNum() {
		return toiletNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setToiletNum(String toiletNum) {
		this.toiletNum = toiletNum == null ? null : toiletNum.trim();
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
	public Byte getFaceToType() {
		return faceToType;
	}

	/**
	 * @mbggenerated
	 */
	public void setFaceToType(Byte faceToType) {
		this.faceToType = faceToType;
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
	public Integer getTotalFloor() {
		return totalFloor;
	}

	/**
	 * @mbggenerated
	 */
	public void setTotalFloor(Integer totalFloor) {
		this.totalFloor = totalFloor;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseFloor() {
		return houseFloor;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseFloor(String houseFloor) {
		this.houseFloor = houseFloor == null ? null : houseFloor.trim();
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
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @mbggenerated
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName == null ? null : agentName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRentCustSex() {
		return rentCustSex;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentCustSex(Integer rentCustSex) {
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
	public Integer getHftRegId() {
		return hftRegId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHftRegId(Integer hftRegId) {
		this.hftRegId = hftRegId;
	}

	/**
	 * @mbggenerated
	 */
	public String getHftRegName() {
		return hftRegName;
	}

	/**
	 * @mbggenerated
	 */
	public void setHftRegName(String hftRegName) {
		this.hftRegName = hftRegName == null ? null : hftRegName.trim();
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
	public Byte getApartmentFitment() {
		return apartmentFitment;
	}

	/**
	 * @mbggenerated
	 */
	public void setApartmentFitment(Byte apartmentFitment) {
		this.apartmentFitment = apartmentFitment;
	}

	/**
	 * @mbggenerated
	 */
	public String getServicePublic() {
		return servicePublic;
	}

	/**
	 * @mbggenerated
	 */
	public void setServicePublic(String servicePublic) {
		this.servicePublic = servicePublic == null ? null : servicePublic.trim();
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
	public String getOutHouseNo() {
		return outHouseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setOutHouseNo(String outHouseNo) {
		this.outHouseNo = outHouseNo == null ? null : outHouseNo.trim();
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
	public String getCityName() {
		return cityName;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsBProducts() {
		return isBProducts;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsBProducts(Byte isBProducts) {
		this.isBProducts = isBProducts;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHftBuildId() {
		return hftBuildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHftBuildId(Integer hftBuildId) {
		this.hftBuildId = hftBuildId;
	}

	/**
	 * @mbggenerated
	 */
	public String getHftBuildName() {
		return hftBuildName;
	}

	/**
	 * @mbggenerated
	 */
	public void setHftBuildName(String hftBuildName) {
		this.hftBuildName = hftBuildName == null ? null : hftBuildName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHftSectionId() {
		return hftSectionId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHftSectionId(String hftSectionId) {
		this.hftSectionId = hftSectionId == null ? null : hftSectionId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getHftSectionName() {
		return hftSectionName;
	}

	/**
	 * @mbggenerated
	 */
	public void setHftSectionName(String hftSectionName) {
		this.hftSectionName = hftSectionName == null ? null : hftSectionName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAptBuildId() {
		return aptBuildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAptBuildId(Integer aptBuildId) {
		this.aptBuildId = aptBuildId;
	}

	/**
	 * @mbggenerated
	 */
	public String getAptBuildName() {
		return aptBuildName;
	}

	/**
	 * @mbggenerated
	 */
	public void setAptBuildName(String aptBuildName) {
		this.aptBuildName = aptBuildName == null ? null : aptBuildName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHouseStatus() {
		return houseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseStatus(Integer houseStatus) {
		this.houseStatus = houseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getViewCount() {
		return viewCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseTitle() {
		return houseTitle;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseTitle(String houseTitle) {
		this.houseTitle = houseTitle == null ? null : houseTitle.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpTime() {
		return upTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
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
	public Byte getIsCProducts() {
		return isCProducts;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsCProducts(Byte isCProducts) {
		this.isCProducts = isCProducts;
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
	public Byte getSexNow() {
		return sexNow;
	}

	/**
	 * @mbggenerated
	 */
	public void setSexNow(Byte sexNow) {
		this.sexNow = sexNow;
	}

	/**
	 * @mbggenerated
	 */
	public Date getbUpTime() {
		return bUpTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setbUpTime(Date bUpTime) {
		this.bUpTime = bUpTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getbDownTime() {
		return bDownTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setbDownTime(Date bDownTime) {
		this.bDownTime = bDownTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getRentRooms() {
		return rentRooms;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentRooms(String rentRooms) {
		this.rentRooms = rentRooms == null ? null : rentRooms.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getAgentPhoto() {
		return agentPhoto;
	}

	/**
	 * @mbggenerated
	 */
	public void setAgentPhoto(String agentPhoto) {
		this.agentPhoto = agentPhoto == null ? null : agentPhoto.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getBuildRound() {
		return buildRound;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildRound(Byte buildRound) {
		this.buildRound = buildRound;
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
	public String getRealUuid() {
		return realUuid;
	}

	/**
	 * @mbggenerated
	 */
	public void setRealUuid(String realUuid) {
		this.realUuid = realUuid == null ? null : realUuid.trim();
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
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName == null ? null : brandName.trim();
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

	/**
	 * @mbggenerated
	 */
	public String getAptPostJson() {
		return aptPostJson;
	}

	/**
	 * @mbggenerated
	 */
	public void setAptPostJson(String aptPostJson) {
		this.aptPostJson = aptPostJson == null ? null : aptPostJson.trim();
	}
}