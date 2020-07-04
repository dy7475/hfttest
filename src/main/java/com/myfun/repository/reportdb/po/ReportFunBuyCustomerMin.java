package com.myfun.repository.reportdb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;

public class ReportFunBuyCustomerMin implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "求购ID，自增序列")
	private Integer buyCustId;
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
	@ApiModelProperty(value = "经纪人门店ID，From:FUN_USER")
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
	@ApiModelProperty(value = "房1")
	private Byte houseRoom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房2")
	private Byte houseRoom1;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "面积1")
	private BigDecimal houseAreaLow;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "面积2")
	private BigDecimal houseAreaHigh;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "价格1")
	private BigDecimal housePriceLow;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "价格2")
	private BigDecimal housePriceHigh;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "信息状态，DD: HOUSE_STATUS")
	private Byte buyCustStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否带看，1=是0=否")
	private Boolean houseLook;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行政区IDS")
	private String houseRegion;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区IDS，板块IDS")
	private String sectionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘IDS")
	private String buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋用途，DD:HOUSE_USEAGE")
	private String houseUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房屋类型，DD: HOUSE_TYPE")
	private String houseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "来源")
	private Byte buyCustSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0=无标签，1=有标签")
	private Byte haveTagFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte plateType;
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
	 * @mbggenerated 求购ID，自增序列
	 */
	public Integer getBuyCustId() {
		return buyCustId;
	}

	/**
	 * @mbggenerated 求购ID，自增序列
	 */
	public void setBuyCustId(Integer buyCustId) {
		this.buyCustId = buyCustId;
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
	 * @mbggenerated 经纪人门店ID，From:FUN_USER
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 经纪人门店ID，From:FUN_USER
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
	 * @mbggenerated 房1
	 */
	public Byte getHouseRoom() {
		return houseRoom;
	}

	/**
	 * @mbggenerated 房1
	 */
	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}

	/**
	 * @mbggenerated 房2
	 */
	public Byte getHouseRoom1() {
		return houseRoom1;
	}

	/**
	 * @mbggenerated 房2
	 */
	public void setHouseRoom1(Byte houseRoom1) {
		this.houseRoom1 = houseRoom1;
	}

	/**
	 * @mbggenerated 面积1
	 */
	public BigDecimal getHouseAreaLow() {
		return houseAreaLow;
	}

	/**
	 * @mbggenerated 面积1
	 */
	public void setHouseAreaLow(BigDecimal houseAreaLow) {
		this.houseAreaLow = houseAreaLow;
	}

	/**
	 * @mbggenerated 面积2
	 */
	public BigDecimal getHouseAreaHigh() {
		return houseAreaHigh;
	}

	/**
	 * @mbggenerated 面积2
	 */
	public void setHouseAreaHigh(BigDecimal houseAreaHigh) {
		this.houseAreaHigh = houseAreaHigh;
	}

	/**
	 * @mbggenerated 价格1
	 */
	public BigDecimal getHousePriceLow() {
		return housePriceLow;
	}

	/**
	 * @mbggenerated 价格1
	 */
	public void setHousePriceLow(BigDecimal housePriceLow) {
		this.housePriceLow = housePriceLow;
	}

	/**
	 * @mbggenerated 价格2
	 */
	public BigDecimal getHousePriceHigh() {
		return housePriceHigh;
	}

	/**
	 * @mbggenerated 价格2
	 */
	public void setHousePriceHigh(BigDecimal housePriceHigh) {
		this.housePriceHigh = housePriceHigh;
	}

	/**
	 * @mbggenerated 信息状态，DD: HOUSE_STATUS
	 */
	public Byte getBuyCustStatus() {
		return buyCustStatus;
	}

	/**
	 * @mbggenerated 信息状态，DD: HOUSE_STATUS
	 */
	public void setBuyCustStatus(Byte buyCustStatus) {
		this.buyCustStatus = buyCustStatus;
	}

	/**
	 * @mbggenerated 是否带看，1=是0=否
	 */
	public Boolean getHouseLook() {
		return houseLook;
	}

	/**
	 * @mbggenerated 是否带看，1=是0=否
	 */
	public void setHouseLook(Boolean houseLook) {
		this.houseLook = houseLook;
	}

	/**
	 * @mbggenerated 行政区IDS
	 */
	public String getHouseRegion() {
		return houseRegion;
	}

	/**
	 * @mbggenerated 行政区IDS
	 */
	public void setHouseRegion(String houseRegion) {
		this.houseRegion = houseRegion == null ? null : houseRegion.trim();
	}

	/**
	 * @mbggenerated 片区IDS，板块IDS
	 */
	public String getSectionId() {
		return sectionId;
	}

	/**
	 * @mbggenerated 片区IDS，板块IDS
	 */
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId == null ? null : sectionId.trim();
	}

	/**
	 * @mbggenerated 楼盘IDS
	 */
	public String getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘IDS
	 */
	public void setBuildId(String buildId) {
		this.buildId = buildId == null ? null : buildId.trim();
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public String getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated 房屋用途，DD:HOUSE_USEAGE
	 */
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage == null ? null : houseUseage.trim();
	}

	/**
	 * @mbggenerated 房屋类型，DD: HOUSE_TYPE
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * @mbggenerated 房屋类型，DD: HOUSE_TYPE
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType == null ? null : houseType.trim();
	}

	/**
	 * @mbggenerated 来源
	 */
	public Byte getBuyCustSource() {
		return buyCustSource;
	}

	/**
	 * @mbggenerated 来源
	 */
	public void setBuyCustSource(Byte buyCustSource) {
		this.buyCustSource = buyCustSource;
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
	 * @mbggenerated -
	 */
	public Byte getPlateType() {
		return plateType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPlateType(Byte plateType) {
		this.plateType = plateType;
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