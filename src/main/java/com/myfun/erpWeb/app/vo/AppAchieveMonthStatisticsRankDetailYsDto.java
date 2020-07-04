package com.myfun.erpWeb.app.vo;

import java.math.BigDecimal;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class AppAchieveMonthStatisticsRankDetailYsDto extends AbstractEncryParam {
	
	@ApiModelProperty("房源主键id")
	private Integer caseId;
	@ApiModelProperty("房源类型,1=出售2=出租3=求购4=求组")
	private Integer caseType;
	@ApiModelProperty("楼盘Id")
	private Integer buildId;
	@ApiModelProperty("楼盘名称")
	private String buildName;
	@ApiModelProperty("区域名字")
	private String regionName;
	@ApiModelProperty("范围名字")
	private String sectionName;
	@ApiModelProperty("几室")
	private Byte houseRoom;
	@ApiModelProperty("几厅")
	private Byte houseHall;
	@ApiModelProperty("房屋性质1=住宅2=别墅3=商铺4=写字楼5=厂房6=仓库7=车库")
	private Byte houseUseage;
	@ApiModelProperty("房屋面积")
	private BigDecimal houseArea;
	@ApiModelProperty("房屋最高价")
	private BigDecimal houseTotalPrice;
	@ApiModelProperty("房屋最低价")
	private BigDecimal houseLowestPrice;
	@ApiModelProperty("租金单位，DD:PRICE_UNIT")
	private Byte priceUnit;
	@ApiModelProperty("钥匙编号")
	private String keyNo;
	@ApiModelProperty("钥匙所在门店ID")
	private Integer keyDeptId;
	@ApiModelProperty("钥匙所在门店名")
	private String keyDeptName;
	@ApiModelProperty("钥匙跟进创建人userId")
	private Integer userId;
	@ApiModelProperty("钥匙跟进创建人userName")
	private String userName;
	@ApiModelProperty("钥匙跟进创建人所在门店名称")
	private String deptName;
	@ApiModelProperty("钥匙跟进创建人deptId")
	private Integer deptId;
	@ApiModelProperty("钥匙跟进创建人archiveId")
	private Integer archiveId;
	@ApiModelProperty("钥匙跟进创建时间")
	private String creationTime;
	@ApiModelProperty(value = "层级主键ID   (员工:-2)")
	private Integer defId;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	@ApiModelProperty(value = "组织名称")
	private String organizationName;

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}

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
	public Byte getHouseRoom() {
		return houseRoom;
	}
	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}
	public Byte getHouseHall() {
		return houseHall;
	}
	public void setHouseHall(Byte houseHall) {
		this.houseHall = houseHall;
	}
	public Byte getHouseUseage() {
		return houseUseage;
	}
	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
	}
	public BigDecimal getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
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
	public String getKeyNo() {
		return keyNo;
	}
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	public Integer getKeyDeptId() {
		return keyDeptId;
	}
	public void setKeyDeptId(Integer keyDeptId) {
		this.keyDeptId = keyDeptId;
	}
	public String getKeyDeptName() {
		return keyDeptName;
	}
	public void setKeyDeptName(String keyDeptName) {
		this.keyDeptName = keyDeptName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
}
