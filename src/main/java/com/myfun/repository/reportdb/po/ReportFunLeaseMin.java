package com.myfun.repository.reportdb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class ReportFunLeaseMin implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID，自增序列")
	private Integer leaseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司大区ID，From:FUN_AREA")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司区域ID，From:FUN_REGION")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人用户ID，From:FUN_USER")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "经纪人档案ID，与USER_ID对应的ARCHIVE_ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登记时间")
	private String creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "本条数据最后同步时间")
	private String lastSyncTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋状态，DD：HOUSE_STATUS")
	private Integer leaseStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "几房")
	private Byte leaseRoom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区ID")
	private Integer sectionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘ID")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区ID")
	private Integer leaseReg;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋用途，DD:HOUSE_USEAGE")
	private Byte leaseUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "类型，DD: HOUSE_TYPE")
	private Byte leaseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼")
	private String unitFloor;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有钥匙，1=是0=否")
	private Boolean leaseKey;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房勘标志，1=已勘0=未勘")
	private Boolean leaseExplrth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源")
	private Byte trueFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片张数")
	private Integer leaseMap;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频数量，Def:0")
	private Integer videoNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR图片数量")
	private Integer panoramaMap;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首次房堪标记-0代表没有房堪过1，代表已房堪过")
	private Byte hasFunkan;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出租面积")
	private BigDecimal leaseArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租金金额")
	private BigDecimal leaseTotalPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租金单位，DD:PRICE_UNIT")
	private Byte priceUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "来源")
	private Byte leaseSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0=无标签，1=有标签")
	private Byte haveTagFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0=无户型图，1=有户型图")
	private Byte haveLayoutFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托DD：HOUSE_CONSIGN")
	private Byte leaseConsign;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息重复标记，0=否 1=电话重复 2=地址重复 3=电话地址都重复")
	private Byte repeatFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "营销推广总开关  1=开启（以前的是否发布到微店分出来了） 9-29    默认=0")
	private Boolean leasePublish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "级别，DD: HOUSE_LEVEL")
	private Byte leaseLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "盘别，DD：PLATE_TYPE")
	private Byte plateType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市大公盘分享状态 0=下架 1=非优家免费 2=非优家付费 3=优家免费 4=优家付费")
	private Byte cityShareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "最近带看时间")
	private Date lastDkanTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer userLevel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String tissueLine;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商ID")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 房源ID，自增序列
	 */
	public Integer getLeaseId() {
		return leaseId;
	}

	/**
	 * @mbggenerated 房源ID，自增序列
	 */
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 公司大区ID，From:FUN_AREA
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 公司大区ID，From:FUN_AREA
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 公司区域ID，From:FUN_REGION
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 公司区域ID，From:FUN_REGION
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 经纪人用户ID，From:FUN_USER
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 经纪人用户ID，From:FUN_USER
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 经纪人档案ID，与USER_ID对应的ARCHIVE_ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 经纪人档案ID，与USER_ID对应的ARCHIVE_ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 登记时间
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 登记时间
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime == null ? null : creationTime.trim();
	}

	/**
	 * @mbggenerated 本条数据最后同步时间
	 */
	public String getLastSyncTime() {
		return lastSyncTime;
	}

	/**
	 * @mbggenerated 本条数据最后同步时间
	 */
	public void setLastSyncTime(String lastSyncTime) {
		this.lastSyncTime = lastSyncTime == null ? null : lastSyncTime.trim();
	}

	/**
	 * @mbggenerated 房屋状态，DD：HOUSE_STATUS
	 */
	public Integer getLeaseStatus() {
		return leaseStatus;
	}

	/**
	 * @mbggenerated 房屋状态，DD：HOUSE_STATUS
	 */
	public void setLeaseStatus(Integer leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	/**
	 * @mbggenerated 几房
	 */
	public Byte getLeaseRoom() {
		return leaseRoom;
	}

	/**
	 * @mbggenerated 几房
	 */
	public void setLeaseRoom(Byte leaseRoom) {
		this.leaseRoom = leaseRoom;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘ID
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated 行政区ID
	 */
	public Integer getLeaseReg() {
		return leaseReg;
	}

	/**
	 * @mbggenerated 行政区ID
	 */
	public void setLeaseReg(Integer leaseReg) {
		this.leaseReg = leaseReg;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public Byte getLeaseUseage() {
		return leaseUseage;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public void setLeaseUseage(Byte leaseUseage) {
		this.leaseUseage = leaseUseage;
	}

	/**
	 * @mbggenerated 类型，DD: HOUSE_TYPE
	 */
	public Byte getLeaseType() {
		return leaseType;
	}

	/**
	 * @mbggenerated 类型，DD: HOUSE_TYPE
	 */
	public void setLeaseType(Byte leaseType) {
		this.leaseType = leaseType;
	}

	/**
	 * @mbggenerated 楼
	 */
	public String getUnitFloor() {
		return unitFloor;
	}

	/**
	 * @mbggenerated 楼
	 */
	public void setUnitFloor(String unitFloor) {
		this.unitFloor = unitFloor == null ? null : unitFloor.trim();
	}

	/**
	 * @mbggenerated 是否有钥匙，1=是0=否
	 */
	public Boolean getLeaseKey() {
		return leaseKey;
	}

	/**
	 * @mbggenerated 是否有钥匙，1=是0=否
	 */
	public void setLeaseKey(Boolean leaseKey) {
		this.leaseKey = leaseKey;
	}

	/**
	 * @mbggenerated 房勘标志，1=已勘0=未勘
	 */
	public Boolean getLeaseExplrth() {
		return leaseExplrth;
	}

	/**
	 * @mbggenerated 房勘标志，1=已勘0=未勘
	 */
	public void setLeaseExplrth(Boolean leaseExplrth) {
		this.leaseExplrth = leaseExplrth;
	}

	/**
	 * @mbggenerated 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源
	 */
	public Byte getTrueFlag() {
		return trueFlag;
	}

	/**
	 * @mbggenerated 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源
	 */
	public void setTrueFlag(Byte trueFlag) {
		this.trueFlag = trueFlag;
	}

	/**
	 * @mbggenerated 图片张数
	 */
	public Integer getLeaseMap() {
		return leaseMap;
	}

	/**
	 * @mbggenerated 图片张数
	 */
	public void setLeaseMap(Integer leaseMap) {
		this.leaseMap = leaseMap;
	}

	/**
	 * @mbggenerated 视频数量，Def:0
	 */
	public Integer getVideoNum() {
		return videoNum;
	}

	/**
	 * @mbggenerated 视频数量，Def:0
	 */
	public void setVideoNum(Integer videoNum) {
		this.videoNum = videoNum;
	}

	/**
	 * @mbggenerated VR图片数量
	 */
	public Integer getPanoramaMap() {
		return panoramaMap;
	}

	/**
	 * @mbggenerated VR图片数量
	 */
	public void setPanoramaMap(Integer panoramaMap) {
		this.panoramaMap = panoramaMap;
	}

	/**
	 * @mbggenerated 首次房堪标记-0代表没有房堪过1，代表已房堪过
	 */
	public Byte getHasFunkan() {
		return hasFunkan;
	}

	/**
	 * @mbggenerated 首次房堪标记-0代表没有房堪过1，代表已房堪过
	 */
	public void setHasFunkan(Byte hasFunkan) {
		this.hasFunkan = hasFunkan;
	}

	/**
	 * @mbggenerated 出租面积
	 */
	public BigDecimal getLeaseArea() {
		return leaseArea;
	}

	/**
	 * @mbggenerated 出租面积
	 */
	public void setLeaseArea(BigDecimal leaseArea) {
		this.leaseArea = leaseArea;
	}

	/**
	 * @mbggenerated 租金金额
	 */
	public BigDecimal getLeaseTotalPrice() {
		return leaseTotalPrice;
	}

	/**
	 * @mbggenerated 租金金额
	 */
	public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
		this.leaseTotalPrice = leaseTotalPrice;
	}

	/**
	 * @mbggenerated 租金单位，DD:PRICE_UNIT
	 */
	public Byte getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated 租金单位，DD:PRICE_UNIT
	 */
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @mbggenerated 来源
	 */
	public Byte getLeaseSource() {
		return leaseSource;
	}

	/**
	 * @mbggenerated 来源
	 */
	public void setLeaseSource(Byte leaseSource) {
		this.leaseSource = leaseSource;
	}

	/**
	 * @mbggenerated 0=无标签，1=有标签
	 */
	public Byte getHaveTagFlag() {
		return haveTagFlag;
	}

	/**
	 * @mbggenerated 0=无标签，1=有标签
	 */
	public void setHaveTagFlag(Byte haveTagFlag) {
		this.haveTagFlag = haveTagFlag;
	}

	/**
	 * @mbggenerated 0=无户型图，1=有户型图
	 */
	public Byte getHaveLayoutFlag() {
		return haveLayoutFlag;
	}

	/**
	 * @mbggenerated 0=无户型图，1=有户型图
	 */
	public void setHaveLayoutFlag(Byte haveLayoutFlag) {
		this.haveLayoutFlag = haveLayoutFlag;
	}

	/**
	 * @mbggenerated 委托DD：HOUSE_CONSIGN
	 */
	public Byte getLeaseConsign() {
		return leaseConsign;
	}

	/**
	 * @mbggenerated 委托DD：HOUSE_CONSIGN
	 */
	public void setLeaseConsign(Byte leaseConsign) {
		this.leaseConsign = leaseConsign;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否 1=电话重复 2=地址重复 3=电话地址都重复
	 */
	public Byte getRepeatFlag() {
		return repeatFlag;
	}

	/**
	 * @mbggenerated 信息重复标记，0=否 1=电话重复 2=地址重复 3=电话地址都重复
	 */
	public void setRepeatFlag(Byte repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	/**
	 * @mbggenerated 营销推广总开关  1=开启（以前的是否发布到微店分出来了） 9-29    默认=0
	 */
	public Boolean getLeasePublish() {
		return leasePublish;
	}

	/**
	 * @mbggenerated 营销推广总开关  1=开启（以前的是否发布到微店分出来了） 9-29    默认=0
	 */
	public void setLeasePublish(Boolean leasePublish) {
		this.leasePublish = leasePublish;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public Byte getLeaseLevel() {
		return leaseLevel;
	}

	/**
	 * @mbggenerated 级别，DD: HOUSE_LEVEL
	 */
	public void setLeaseLevel(Byte leaseLevel) {
		this.leaseLevel = leaseLevel;
	}

	/**
	 * @mbggenerated 盘别，DD：PLATE_TYPE
	 */
	public Byte getPlateType() {
		return plateType;
	}

	/**
	 * @mbggenerated 盘别，DD：PLATE_TYPE
	 */
	public void setPlateType(Byte plateType) {
		this.plateType = plateType;
	}

	/**
	 * @mbggenerated 城市大公盘分享状态 0=下架 1=非优家免费 2=非优家付费 3=优家免费 4=优家付费
	 */
	public Byte getCityShareFlag() {
		return cityShareFlag;
	}

	/**
	 * @mbggenerated 城市大公盘分享状态 0=下架 1=非优家免费 2=非优家付费 3=优家免费 4=优家付费
	 */
	public void setCityShareFlag(Byte cityShareFlag) {
		this.cityShareFlag = cityShareFlag;
	}

	/**
	 * @mbggenerated 最近带看时间
	 */
	public Date getLastDkanTime() {
		return lastDkanTime;
	}

	/**
	 * @mbggenerated 最近带看时间
	 */
	public void setLastDkanTime(Date lastDkanTime) {
		this.lastDkanTime = lastDkanTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getUserLevel() {
		return userLevel;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @mbggenerated -
	 */
	public String getTissueLine() {
		return tissueLine;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTissueLine(String tissueLine) {
		this.tissueLine = tissueLine == null ? null : tissueLine.trim();
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
}