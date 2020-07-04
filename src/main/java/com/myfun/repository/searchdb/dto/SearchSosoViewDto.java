package com.myfun.repository.searchdb.dto;

import java.math.BigDecimal;

import com.myfun.repository.searchdb.po.SearchSosoView;

public class SearchSosoViewDto extends SearchSosoView {
	private static final long serialVersionUID = 1L;
	private Integer sosoId;
	private Integer convertCount;//搜搜转入系统次数
	// 公用
	private Integer caseType;
	private Integer userId;
	private String userName;
	private String buildName;
	private Integer buildId;
	// 出售
	private Byte saleStatus;
	private Integer saleId;
	private Integer saleFloor;
	private Integer saleFloors;
	private Integer saleDoors;
	private Byte saleRoom;
	private Byte saleHall;
	private Byte saleWei;
	private Byte saleYang;
	private BigDecimal saleArea;
	private BigDecimal saleTotalPrice;
	// 出租
	private Byte priceUnit;
	private Byte leaseStatus;
	private Integer leaseId;
	private Integer leaseFloor;
	private Integer leaseFloors;
	private Integer leaseDoors;
	private Byte leaseRoom;
	private Byte leaseHall;
	private Byte leaseWei;
	private Byte leaseYang;
	private BigDecimal leaseArea;
	private BigDecimal leaseTotalPrice;
	
	@Override
	public Integer getSosoId() {
		return sosoId;
	}

	@Override
	public void setSosoId(Integer sosoId) {
		this.sosoId = sosoId;
	}

	public Integer getConvertCount() {
		return convertCount;
	}

	public void setConvertCount(Integer convertCount) {
		this.convertCount = convertCount;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public Byte getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Byte saleStatus) {
		this.saleStatus = saleStatus;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getSaleFloor() {
		return saleFloor;
	}

	public void setSaleFloor(Integer saleFloor) {
		this.saleFloor = saleFloor;
	}

	public Integer getSaleFloors() {
		return saleFloors;
	}

	public void setSaleFloors(Integer saleFloors) {
		this.saleFloors = saleFloors;
	}

	public Integer getSaleDoors() {
		return saleDoors;
	}

	public void setSaleDoors(Integer saleDoors) {
		this.saleDoors = saleDoors;
	}

	public Byte getSaleRoom() {
		return saleRoom;
	}

	public void setSaleRoom(Byte saleRoom) {
		this.saleRoom = saleRoom;
	}

	public Byte getSaleHall() {
		return saleHall;
	}

	public void setSaleHall(Byte saleHall) {
		this.saleHall = saleHall;
	}

	public Byte getSaleWei() {
		return saleWei;
	}

	public void setSaleWei(Byte saleWei) {
		this.saleWei = saleWei;
	}

	public Byte getSaleYang() {
		return saleYang;
	}

	public void setSaleYang(Byte saleYang) {
		this.saleYang = saleYang;
	}

	public BigDecimal getSaleArea() {
		return saleArea;
	}

	public void setSaleArea(BigDecimal saleArea) {
		this.saleArea = saleArea;
	}

	public BigDecimal getSaleTotalPrice() {
		return saleTotalPrice;
	}

	public void setSaleTotalPrice(BigDecimal saleTotalPrice) {
		this.saleTotalPrice = saleTotalPrice;
	}

	public Byte getLeaseStatus() {
		return leaseStatus;
	}

	public void setLeaseStatus(Byte leaseStatus) {
		this.leaseStatus = leaseStatus;
	}

	public Integer getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}

	public Integer getLeaseFloor() {
		return leaseFloor;
	}

	public void setLeaseFloor(Integer leaseFloor) {
		this.leaseFloor = leaseFloor;
	}

	public Integer getLeaseFloors() {
		return leaseFloors;
	}

	public void setLeaseFloors(Integer leaseFloors) {
		this.leaseFloors = leaseFloors;
	}

	public Integer getLeaseDoors() {
		return leaseDoors;
	}

	public void setLeaseDoors(Integer leaseDoors) {
		this.leaseDoors = leaseDoors;
	}

	public Byte getLeaseRoom() {
		return leaseRoom;
	}

	public void setLeaseRoom(Byte leaseRoom) {
		this.leaseRoom = leaseRoom;
	}

	public Byte getLeaseHall() {
		return leaseHall;
	}

	public void setLeaseHall(Byte leaseHall) {
		this.leaseHall = leaseHall;
	}

	public Byte getLeaseWei() {
		return leaseWei;
	}

	public void setLeaseWei(Byte leaseWei) {
		this.leaseWei = leaseWei;
	}

	public Byte getLeaseYang() {
		return leaseYang;
	}

	public void setLeaseYang(Byte leaseYang) {
		this.leaseYang = leaseYang;
	}

	public BigDecimal getLeaseArea() {
		return leaseArea;
	}

	public void setLeaseArea(BigDecimal leaseArea) {
		this.leaseArea = leaseArea;
	}

	public BigDecimal getLeaseTotalPrice() {
		return leaseTotalPrice;
	}

	public void setLeaseTotalPrice(BigDecimal leaseTotalPrice) {
		this.leaseTotalPrice = leaseTotalPrice;
	}

	public Byte getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}
	
}

