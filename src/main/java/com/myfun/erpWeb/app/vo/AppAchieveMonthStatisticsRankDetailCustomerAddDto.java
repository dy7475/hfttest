package com.myfun.erpWeb.app.vo;

import java.math.BigDecimal;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class AppAchieveMonthStatisticsRankDetailCustomerAddDto extends AbstractEncryParam {

	@ApiModelProperty("客源主键id")
	private Integer caseId;
	@ApiModelProperty("客源类型,1=出售2=出租3=求购4=求组")
	private Integer caseType;
	@ApiModelProperty("客源创建人userId")
	private Integer userId;
	@ApiModelProperty("客源创建人deptId")
	private Integer deptId;
	@ApiModelProperty("房源创建人userName")
	private String userName;
	@ApiModelProperty("房源创建人所在门店名称")
	private String deptName;
	@ApiModelProperty("客源创建人archiveId")
	private Integer archiveId;
	@ApiModelProperty("客源创建时间")
	private String creationTime;
	@ApiModelProperty("客源客户姓名")
	private String custName;
	@ApiModelProperty("楼盘Id")
	private Integer buildId;
	@ApiModelProperty("楼盘名称")
	private String buildName;
	@ApiModelProperty("区域名字")
	private String regionName;
	@ApiModelProperty("范围名字")
	private String sectionName;
	@ApiModelProperty("客屋性质1=住宅2=别墅3=商铺4=写字楼5=厂客6=仓库7=车库,多个用途用空格隔开")
	private String houseUseage;
	@ApiModelProperty("几室开始")
	private Byte houseRoom;
	@ApiModelProperty("几室开始")
	private Byte houseRoom1;
	@ApiModelProperty("几厅")
	private Byte houseHall;
	@ApiModelProperty("几卫")
	private Byte houseWei;
	@ApiModelProperty("阳台")
	private Byte houseYang;
	@ApiModelProperty("客屋面积")
	private BigDecimal houseAreaHigh;
	@ApiModelProperty("客屋面积")
	private BigDecimal houseAreaLow;
	@ApiModelProperty("楼层")
	private Short houseFloor;
	@ApiModelProperty("总楼层")
	private Integer houseFloors;
	@ApiModelProperty("客屋最高价")
	private BigDecimal houseTotalPrice;
	@ApiModelProperty("客屋最低价")
	private BigDecimal houseLowestPrice;
	@ApiModelProperty("租金单位，DD:PRICE_UNIT")
	private Byte priceUnit;
	@ApiModelProperty("客户性别")
	private Integer customerSex;
	@ApiModelProperty("组织Id")
	private Integer organizationId;
	@ApiModelProperty("组织名称")
	private String organizationName;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(Integer customerSex) {
		this.customerSex = customerSex;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Integer getBuildId() {
		return buildId;
	}
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getHouseUseage() {
		return houseUseage;
	}
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}
	public Byte getHouseRoom() {
		return houseRoom;
	}
	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}
	public Byte getHouseRoom1() {
		return houseRoom1;
	}
	public void setHouseRoom1(Byte houseRoom1) {
		this.houseRoom1 = houseRoom1;
	}
	public Byte getHouseHall() {
		return houseHall;
	}
	public void setHouseHall(Byte houseHall) {
		this.houseHall = houseHall;
	}
	public Byte getHouseWei() {
		return houseWei;
	}
	public void setHouseWei(Byte houseWei) {
		this.houseWei = houseWei;
	}
	public Byte getHouseYang() {
		return houseYang;
	}
	public void setHouseYang(Byte houseYang) {
		this.houseYang = houseYang;
	}
	public BigDecimal getHouseAreaHigh() {
		return houseAreaHigh;
	}
	public void setHouseAreaHigh(BigDecimal houseAreaHigh) {
		this.houseAreaHigh = houseAreaHigh;
	}
	public BigDecimal getHouseAreaLow() {
		return houseAreaLow;
	}
	public void setHouseAreaLow(BigDecimal houseAreaLow) {
		this.houseAreaLow = houseAreaLow;
	}
	public Short getHouseFloor() {
		return houseFloor;
	}
	public void setHouseFloor(Short houseFloor) {
		this.houseFloor = houseFloor;
	}
	public Integer getHouseFloors() {
		return houseFloors;
	}
	public void setHouseFloors(Integer houseFloors) {
		this.houseFloors = houseFloors;
	}
	public BigDecimal getHouseTotalPrice() {
		return houseTotalPrice;
	}
	public void setHouseTotalPrice(BigDecimal houseTotalPrice) {
		this.houseTotalPrice = houseTotalPrice;
	}
	public BigDecimal getHouseLowestPrice() {
		return houseLowestPrice;
	}
	public void setHouseLowestPrice(BigDecimal houseLowestPrice) {
		this.houseLowestPrice = houseLowestPrice;
	}
	public Byte getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
