package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpTmpLeasePer extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer leaseId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private String creationTime;
	/**
	 * @mbggenerated
	 */
	private Integer createArchiveId;
	/**
	 * @mbggenerated
	 */
	private String leaseNo;
	/**
	 * @mbggenerated
	 */
	private String leaseSubject;
	/**
	 * @mbggenerated
	 */
	private String leaseOwner;
	/**
	 * @mbggenerated
	 */
	private String cellPhone;
	/**
	 * @mbggenerated
	 */
	private String idCard;
	/**
	 * @mbggenerated
	 */
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	private String buildName;
	/**
	 * @mbggenerated
	 */
	private String buildCode;
	/**
	 * @mbggenerated
	 */
	private Integer leaseReg;
	/**
	 * @mbggenerated
	 */
	private String regionName;
	/**
	 * @mbggenerated
	 */
	private Integer sectionId;
	/**
	 * @mbggenerated
	 */
	private String sectionName;
	/**
	 * @mbggenerated
	 */
	private Byte leaseRound;
	/**
	 * @mbggenerated
	 */
	private String tradeAddr;
	/**
	 * @mbggenerated
	 */
	private String leaseRoof;
	/**
	 * @mbggenerated
	 */
	private String leaseUnit;
	/**
	 * @mbggenerated
	 */
	private String unitFloor;
	/**
	 * @mbggenerated
	 */
	private String leaseNum;
	/**
	 * @mbggenerated
	 */
	private String leaseRoofR;
	/**
	 * @mbggenerated
	 */
	private String leaseUnitR;
	/**
	 * @mbggenerated
	 */
	private String unitFloorR;
	/**
	 * @mbggenerated
	 */
	private String leaseNumR;
	/**
	 * @mbggenerated
	 */
	private Byte plateType;
	/**
	 * @mbggenerated
	 */
	private Byte leaseRoom;
	/**
	 * @mbggenerated
	 */
	private Byte leaseHall;
	/**
	 * @mbggenerated
	 */
	private Byte leaseWei;
	/**
	 * @mbggenerated
	 */
	private Byte leaseYang;
	/**
	 * @mbggenerated
	 */
	private Byte leaseLadder;
	/**
	 * @mbggenerated
	 */
	private Integer leaseDoors;
	/**
	 * @mbggenerated
	 */
	private Byte leaseType;
	/**
	 * @mbggenerated
	 */
	private Short leaseFloor;
	/**
	 * @mbggenerated
	 */
	private Integer leaseFloors;
	/**
	 * @mbggenerated
	 */
	private Byte leaseFitment;
	/**
	 * @mbggenerated
	 */
	private Byte leaseDirect;
	/**
	 * @mbggenerated
	 */
	private Short leaseYear;
	/**
	 * @mbggenerated
	 */
	private Byte leaseUseage;
	/**
	 * @mbggenerated
	 */
	private Boolean leaseStreet;
	/**
	 * @mbggenerated
	 */
	private Integer leaseAccount;
	/**
	 * @mbggenerated
	 */
	private BigDecimal leaseArea;
	/**
	 * @mbggenerated
	 */
	private BigDecimal leaseTotalPrice;
	/**
	 * @mbggenerated
	 */
	private Byte priceUnit;
	/**
	 * @mbggenerated
	 */
	private BigDecimal leaseLowestPrice;
	/**
	 * @mbggenerated
	 */
	private BigDecimal leaseProperty;
	/**
	 * @mbggenerated
	 */
	private Boolean isSeperator;
	/**
	 * @mbggenerated
	 */
	private String shopUsage;
	/**
	 * @mbggenerated
	 */
	private Byte ownerType;
	/**
	 * @mbggenerated
	 */
	private Byte officeLevel;
	/**
	 * @mbggenerated
	 */
	private Integer leaseDeposit;
	/**
	 * @mbggenerated
	 */
	private String leaseLeaveTime;
	/**
	 * @mbggenerated
	 */
	private Integer leaseLimite;
	/**
	 * @mbggenerated
	 */
	private Byte hallStructure;
	/**
	 * @mbggenerated
	 */
	private BigDecimal ugArea;
	/**
	 * @mbggenerated
	 */
	private Integer ugType;
	/**
	 * @mbggenerated
	 */
	private BigDecimal gardenArea;
	/**
	 * @mbggenerated
	 */
	private Integer garageAmount;
	/**
	 * @mbggenerated
	 */
	private String leaseSet;
	/**
	 * @mbggenerated
	 */
	private String leaseCharact;
	/**
	 * @mbggenerated
	 */
	private String leaseMemo;
	/**
	 * @mbggenerated
	 */
	private Byte leaseSource;
	/**
	 * @mbggenerated
	 */
	private Byte leaseLevel;
	/**
	 * @mbggenerated
	 */
	private Boolean leaseKey;
	/**
	 * @mbggenerated
	 */
	private String leaseKeyNum;
	/**
	 * @mbggenerated
	 */
	private String keyTime;
	/**
	 * @mbggenerated
	 */
	private Boolean leaseExplrth;
	/**
	 * @mbggenerated
	 */
	private String explrthDatetime;
	/**
	 * @mbggenerated
	 */
	private Integer leaseConsign;
	/**
	 * @mbggenerated
	 */
	private String leaseConsignNo;
	/**
	 * @mbggenerated
	 */
	private String weituoTime;
	/**
	 * @mbggenerated
	 */
	private Boolean leaseCooperate;
	/**
	 * @mbggenerated
	 */
	private String cooperateTime;
	/**
	 * @mbggenerated
	 */
	private Boolean complaintFlag;
	/**
	 * @mbggenerated
	 */
	private Boolean leasePublish;
	/**
	 * @mbggenerated
	 */
	private String publishTime;
	/**
	 * @mbggenerated
	 */
	private Integer leaseMap;
	/**
	 * @mbggenerated
	 */
	private String photoTime;
	/**
	 * @mbggenerated
	 */
	private Integer leaseStatus;
	/**
	 * @mbggenerated
	 */
	private String trackTime;
	/**
	 * @mbggenerated
	 */
	private String trackTime2;
	/**
	 * @mbggenerated
	 */
	private String actionTime;
	/**
	 * @mbggenerated
	 */
	private Boolean fromSoso;
	/**
	 * @mbggenerated
	 */
	private Integer repeatFlag;
	/**
	 * @mbggenerated
	 */
	private Byte infoType;
	/**
	 * @mbggenerated
	 */
	private Boolean shareFlag;
	/**
	 * @mbggenerated
	 */
	private Boolean friendHouse;
	/**
	 * @mbggenerated
	 */
	private Boolean redFlag;
	/**
	 * @mbggenerated
	 */
	private Boolean orangeFlag;
	/**
	 * @mbggenerated
	 */
	private Byte publicCount;
	/**
	 * @mbggenerated
	 */
	private String publicTime;
	/**
	 * @mbggenerated
	 */
	private String dueTime;
	/**
	 * @mbggenerated
	 */
	private String specialTime;
	/**
	 * @mbggenerated
	 */
	private String scheduleTime;
	/**
	 * @mbggenerated
	 */
	private String dealTime;
	/**
	 * @mbggenerated
	 */
	private String writeoffTime;
	/**
	 * @mbggenerated
	 */
	private String secrecyTime;
	/**
	 * @mbggenerated
	 */
	private String commendTime;
	/**
	 * @mbggenerated
	 */
	private String privateTime;
	/**
	 * @mbggenerated
	 */
	private Boolean fromPublic;
	/**
	 * @mbggenerated
	 */
	private String thumbUrl;
	/**
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private String tagIds;
	/**
	 * @mbggenerated
	 */
	private String leaseCertTime;
	/**
	 * @mbggenerated
	 */
	private Integer publishSites;
	/**
	 * @mbggenerated
	 */
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	private String leaseRoofT;
	/**
	 * @mbggenerated
	 */
	private String leaseNumT;
	/**
	 * @mbggenerated
	 */
	private String leaseUnitT;
	/**
	 * @mbggenerated
	 */
	private Byte leaseRight;
	/**
	 * @mbggenerated
	 */
	private Integer videoNum;
	/**
	 * @mbggenerated
	 */
	private Integer creatorUid;
	/**
	 * @mbggenerated
	 */
	private Byte isIgnore;
	/**
	 * @mbggenerated
	 */
	private Integer leaseIdOld;
	/**
	 * @mbggenerated
	 */
	private BigDecimal leaseInnerarea;
	/**
	 * @mbggenerated
	 */
	private Boolean houseBargain;
	/**
	 * @mbggenerated
	 */
	private Byte encodeFlag;
	/**
	 * @mbggenerated
	 */
	private Byte lock;
	/**
	 * @mbggenerated
	 */
	private Byte trueFlag;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseId() {
		return leaseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
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
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime == null ? null : creationTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateArchiveId() {
		return createArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateArchiveId(Integer createArchiveId) {
		this.createArchiveId = createArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseNo() {
		return leaseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseNo(String leaseNo) {
		this.leaseNo = leaseNo == null ? null : leaseNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseSubject() {
		return leaseSubject;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseSubject(String leaseSubject) {
		this.leaseSubject = leaseSubject == null ? null : leaseSubject.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseOwner() {
		return leaseOwner;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseOwner(String leaseOwner) {
		this.leaseOwner = leaseOwner == null ? null : leaseOwner.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone == null ? null : cellPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @mbggenerated
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
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
	public String getBuildCode() {
		return buildCode;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode == null ? null : buildCode.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseReg() {
		return leaseReg;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseReg(Integer leaseReg) {
		this.leaseReg = leaseReg;
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
	public Byte getLeaseRound() {
		return leaseRound;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseRound(Byte leaseRound) {
		this.leaseRound = leaseRound;
	}

	/**
	 * @mbggenerated
	 */
	public String getTradeAddr() {
		return tradeAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradeAddr(String tradeAddr) {
		this.tradeAddr = tradeAddr == null ? null : tradeAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseRoof() {
		return leaseRoof;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseRoof(String leaseRoof) {
		this.leaseRoof = leaseRoof == null ? null : leaseRoof.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseUnit() {
		return leaseUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseUnit(String leaseUnit) {
		this.leaseUnit = leaseUnit == null ? null : leaseUnit.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUnitFloor() {
		return unitFloor;
	}

	/**
	 * @mbggenerated
	 */
	public void setUnitFloor(String unitFloor) {
		this.unitFloor = unitFloor == null ? null : unitFloor.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseNum() {
		return leaseNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseNum(String leaseNum) {
		this.leaseNum = leaseNum == null ? null : leaseNum.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseRoofR() {
		return leaseRoofR;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseRoofR(String leaseRoofR) {
		this.leaseRoofR = leaseRoofR == null ? null : leaseRoofR.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseUnitR() {
		return leaseUnitR;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseUnitR(String leaseUnitR) {
		this.leaseUnitR = leaseUnitR == null ? null : leaseUnitR.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUnitFloorR() {
		return unitFloorR;
	}

	/**
	 * @mbggenerated
	 */
	public void setUnitFloorR(String unitFloorR) {
		this.unitFloorR = unitFloorR == null ? null : unitFloorR.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseNumR() {
		return leaseNumR;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseNumR(String leaseNumR) {
		this.leaseNumR = leaseNumR == null ? null : leaseNumR.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPlateType() {
		return plateType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPlateType(Byte plateType) {
		this.plateType = plateType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseRoom() {
		return leaseRoom;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseRoom(Byte leaseRoom) {
		this.leaseRoom = leaseRoom;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseHall() {
		return leaseHall;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseHall(Byte leaseHall) {
		this.leaseHall = leaseHall;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseWei() {
		return leaseWei;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseWei(Byte leaseWei) {
		this.leaseWei = leaseWei;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseYang() {
		return leaseYang;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseYang(Byte leaseYang) {
		this.leaseYang = leaseYang;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseLadder() {
		return leaseLadder;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseLadder(Byte leaseLadder) {
		this.leaseLadder = leaseLadder;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseDoors() {
		return leaseDoors;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseDoors(Integer leaseDoors) {
		this.leaseDoors = leaseDoors;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseType() {
		return leaseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseType(Byte leaseType) {
		this.leaseType = leaseType;
	}

	/**
	 * @mbggenerated
	 */
	public Short getLeaseFloor() {
		return leaseFloor;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseFloor(Short leaseFloor) {
		this.leaseFloor = leaseFloor;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseFloors() {
		return leaseFloors;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseFloors(Integer leaseFloors) {
		this.leaseFloors = leaseFloors;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseFitment() {
		return leaseFitment;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseFitment(Byte leaseFitment) {
		this.leaseFitment = leaseFitment;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseDirect() {
		return leaseDirect;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseDirect(Byte leaseDirect) {
		this.leaseDirect = leaseDirect;
	}

	/**
	 * @mbggenerated
	 */
	public Short getLeaseYear() {
		return leaseYear;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseYear(Short leaseYear) {
		this.leaseYear = leaseYear;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseUseage() {
		return leaseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseUseage(Byte leaseUseage) {
		this.leaseUseage = leaseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getLeaseStreet() {
		return leaseStreet;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseStreet(Boolean leaseStreet) {
		this.leaseStreet = leaseStreet;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseAccount() {
		return leaseAccount;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseAccount(Integer leaseAccount) {
		this.leaseAccount = leaseAccount;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getLeaseArea() {
		return leaseArea;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseArea(BigDecimal leaseArea) {
		this.leaseArea = leaseArea;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getLeaseTotalPrice() {
		return leaseTotalPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
		this.leaseTotalPrice = leaseTotalPrice;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getLeaseLowestPrice() {
		return leaseLowestPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseLowestPrice(BigDecimal leaseLowestPrice) {
		this.leaseLowestPrice = leaseLowestPrice;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getLeaseProperty() {
		return leaseProperty;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseProperty(BigDecimal leaseProperty) {
		this.leaseProperty = leaseProperty;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsSeperator() {
		return isSeperator;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsSeperator(Boolean isSeperator) {
		this.isSeperator = isSeperator;
	}

	/**
	 * @mbggenerated
	 */
	public String getShopUsage() {
		return shopUsage;
	}

	/**
	 * @mbggenerated
	 */
	public void setShopUsage(String shopUsage) {
		this.shopUsage = shopUsage == null ? null : shopUsage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getOwnerType() {
		return ownerType;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwnerType(Byte ownerType) {
		this.ownerType = ownerType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getOfficeLevel() {
		return officeLevel;
	}

	/**
	 * @mbggenerated
	 */
	public void setOfficeLevel(Byte officeLevel) {
		this.officeLevel = officeLevel;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseDeposit() {
		return leaseDeposit;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseDeposit(Integer leaseDeposit) {
		this.leaseDeposit = leaseDeposit;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseLeaveTime() {
		return leaseLeaveTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseLeaveTime(String leaseLeaveTime) {
		this.leaseLeaveTime = leaseLeaveTime == null ? null : leaseLeaveTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseLimite() {
		return leaseLimite;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseLimite(Integer leaseLimite) {
		this.leaseLimite = leaseLimite;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHallStructure() {
		return hallStructure;
	}

	/**
	 * @mbggenerated
	 */
	public void setHallStructure(Byte hallStructure) {
		this.hallStructure = hallStructure;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getUgArea() {
		return ugArea;
	}

	/**
	 * @mbggenerated
	 */
	public void setUgArea(BigDecimal ugArea) {
		this.ugArea = ugArea;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUgType() {
		return ugType;
	}

	/**
	 * @mbggenerated
	 */
	public void setUgType(Integer ugType) {
		this.ugType = ugType;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getGardenArea() {
		return gardenArea;
	}

	/**
	 * @mbggenerated
	 */
	public void setGardenArea(BigDecimal gardenArea) {
		this.gardenArea = gardenArea;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGarageAmount() {
		return garageAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setGarageAmount(Integer garageAmount) {
		this.garageAmount = garageAmount;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseSet() {
		return leaseSet;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseSet(String leaseSet) {
		this.leaseSet = leaseSet == null ? null : leaseSet.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseCharact() {
		return leaseCharact;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseCharact(String leaseCharact) {
		this.leaseCharact = leaseCharact == null ? null : leaseCharact.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseMemo() {
		return leaseMemo;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseMemo(String leaseMemo) {
		this.leaseMemo = leaseMemo == null ? null : leaseMemo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseSource() {
		return leaseSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseSource(Byte leaseSource) {
		this.leaseSource = leaseSource;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseLevel() {
		return leaseLevel;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseLevel(Byte leaseLevel) {
		this.leaseLevel = leaseLevel;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getLeaseKey() {
		return leaseKey;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseKey(Boolean leaseKey) {
		this.leaseKey = leaseKey;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseKeyNum() {
		return leaseKeyNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseKeyNum(String leaseKeyNum) {
		this.leaseKeyNum = leaseKeyNum == null ? null : leaseKeyNum.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getKeyTime() {
		return keyTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setKeyTime(String keyTime) {
		this.keyTime = keyTime == null ? null : keyTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getLeaseExplrth() {
		return leaseExplrth;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseExplrth(Boolean leaseExplrth) {
		this.leaseExplrth = leaseExplrth;
	}

	/**
	 * @mbggenerated
	 */
	public String getExplrthDatetime() {
		return explrthDatetime;
	}

	/**
	 * @mbggenerated
	 */
	public void setExplrthDatetime(String explrthDatetime) {
		this.explrthDatetime = explrthDatetime == null ? null : explrthDatetime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseConsign() {
		return leaseConsign;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseConsign(Integer leaseConsign) {
		this.leaseConsign = leaseConsign;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseConsignNo() {
		return leaseConsignNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseConsignNo(String leaseConsignNo) {
		this.leaseConsignNo = leaseConsignNo == null ? null : leaseConsignNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWeituoTime() {
		return weituoTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setWeituoTime(String weituoTime) {
		this.weituoTime = weituoTime == null ? null : weituoTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getLeaseCooperate() {
		return leaseCooperate;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseCooperate(Boolean leaseCooperate) {
		this.leaseCooperate = leaseCooperate;
	}

	/**
	 * @mbggenerated
	 */
	public String getCooperateTime() {
		return cooperateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCooperateTime(String cooperateTime) {
		this.cooperateTime = cooperateTime == null ? null : cooperateTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getComplaintFlag() {
		return complaintFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setComplaintFlag(Boolean complaintFlag) {
		this.complaintFlag = complaintFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getLeasePublish() {
		return leasePublish;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeasePublish(Boolean leasePublish) {
		this.leasePublish = leasePublish;
	}

	/**
	 * @mbggenerated
	 */
	public String getPublishTime() {
		return publishTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime == null ? null : publishTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseMap() {
		return leaseMap;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseMap(Integer leaseMap) {
		this.leaseMap = leaseMap;
	}

	/**
	 * @mbggenerated
	 */
	public String getPhotoTime() {
		return photoTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoTime(String photoTime) {
		this.photoTime = photoTime == null ? null : photoTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseStatus() {
		return leaseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseStatus(Integer leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackTime(String trackTime) {
		this.trackTime = trackTime == null ? null : trackTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTrackTime2() {
		return trackTime2;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackTime2(String trackTime2) {
		this.trackTime2 = trackTime2 == null ? null : trackTime2.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getActionTime() {
		return actionTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime == null ? null : actionTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getFromSoso() {
		return fromSoso;
	}

	/**
	 * @mbggenerated
	 */
	public void setFromSoso(Boolean fromSoso) {
		this.fromSoso = fromSoso;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRepeatFlag() {
		return repeatFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepeatFlag(Integer repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getInfoType() {
		return infoType;
	}

	/**
	 * @mbggenerated
	 */
	public void setInfoType(Byte infoType) {
		this.infoType = infoType;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getShareFlag() {
		return shareFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setShareFlag(Boolean shareFlag) {
		this.shareFlag = shareFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getFriendHouse() {
		return friendHouse;
	}

	/**
	 * @mbggenerated
	 */
	public void setFriendHouse(Boolean friendHouse) {
		this.friendHouse = friendHouse;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getRedFlag() {
		return redFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setRedFlag(Boolean redFlag) {
		this.redFlag = redFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getOrangeFlag() {
		return orangeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setOrangeFlag(Boolean orangeFlag) {
		this.orangeFlag = orangeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPublicCount() {
		return publicCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setPublicCount(Byte publicCount) {
		this.publicCount = publicCount;
	}

	/**
	 * @mbggenerated
	 */
	public String getPublicTime() {
		return publicTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPublicTime(String publicTime) {
		this.publicTime = publicTime == null ? null : publicTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDueTime() {
		return dueTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime == null ? null : dueTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSpecialTime() {
		return specialTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setSpecialTime(String specialTime) {
		this.specialTime = specialTime == null ? null : specialTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getScheduleTime() {
		return scheduleTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime == null ? null : scheduleTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDealTime() {
		return dealTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime == null ? null : dealTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWriteoffTime() {
		return writeoffTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setWriteoffTime(String writeoffTime) {
		this.writeoffTime = writeoffTime == null ? null : writeoffTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSecrecyTime() {
		return secrecyTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setSecrecyTime(String secrecyTime) {
		this.secrecyTime = secrecyTime == null ? null : secrecyTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCommendTime() {
		return commendTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCommendTime(String commendTime) {
		this.commendTime = commendTime == null ? null : commendTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPrivateTime() {
		return privateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setPrivateTime(String privateTime) {
		this.privateTime = privateTime == null ? null : privateTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getFromPublic() {
		return fromPublic;
	}

	/**
	 * @mbggenerated
	 */
	public void setFromPublic(Boolean fromPublic) {
		this.fromPublic = fromPublic;
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
	public String getTagIds() {
		return tagIds;
	}

	/**
	 * @mbggenerated
	 */
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds == null ? null : tagIds.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseCertTime() {
		return leaseCertTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseCertTime(String leaseCertTime) {
		this.leaseCertTime = leaseCertTime == null ? null : leaseCertTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPublishSites() {
		return publishSites;
	}

	/**
	 * @mbggenerated
	 */
	public void setPublishSites(Integer publishSites) {
		this.publishSites = publishSites;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseRoofT() {
		return leaseRoofT;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseRoofT(String leaseRoofT) {
		this.leaseRoofT = leaseRoofT == null ? null : leaseRoofT.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseNumT() {
		return leaseNumT;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseNumT(String leaseNumT) {
		this.leaseNumT = leaseNumT == null ? null : leaseNumT.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLeaseUnitT() {
		return leaseUnitT;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseUnitT(String leaseUnitT) {
		this.leaseUnitT = leaseUnitT == null ? null : leaseUnitT.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLeaseRight() {
		return leaseRight;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseRight(Byte leaseRight) {
		this.leaseRight = leaseRight;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getVideoNum() {
		return videoNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setVideoNum(Integer videoNum) {
		this.videoNum = videoNum;
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
	public Byte getIsIgnore() {
		return isIgnore;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsIgnore(Byte isIgnore) {
		this.isIgnore = isIgnore;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLeaseIdOld() {
		return leaseIdOld;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseIdOld(Integer leaseIdOld) {
		this.leaseIdOld = leaseIdOld;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getLeaseInnerarea() {
		return leaseInnerarea;
	}

	/**
	 * @mbggenerated
	 */
	public void setLeaseInnerarea(BigDecimal leaseInnerarea) {
		this.leaseInnerarea = leaseInnerarea;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getHouseBargain() {
		return houseBargain;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseBargain(Boolean houseBargain) {
		this.houseBargain = houseBargain;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getEncodeFlag() {
		return encodeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setEncodeFlag(Byte encodeFlag) {
		this.encodeFlag = encodeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLock() {
		return lock;
	}

	/**
	 * @mbggenerated
	 */
	public void setLock(Byte lock) {
		this.lock = lock;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getTrueFlag() {
		return trueFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrueFlag(Byte trueFlag) {
		this.trueFlag = trueFlag;
	}

	/**
	 * @mbggenerated
	 */
	public ErpTmpLeasePer() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpTmpLeasePer(Integer shardCityId) {
		super(shardCityId);
	}
}