package com.myfun.repository.reportdb.dto;

import com.myfun.repository.reportdb.po.ReportFunWageDetail1;

import java.math.BigDecimal;

public class ReportFunWageDetail1Dto extends ReportFunWageDetail1 {

	private static final long serialVersionUID = -8339376644074358857L;

	private Integer userId;
	//房源
	private Integer plateType; //盘别
	private String buildName; //名称
	private Integer buildId; //楼盘ID
	private String houseUseage; //用途
	//出售房源
	private Integer houseFloors; //总楼层
	private Integer houseFloor; //楼层
	private Integer houseMap; //图片张数
	private Integer houseKey; //是否有钥匙
	private boolean houseExplrth; // 房勘，1=已勘0=未勘
	private Integer houseLevel; //级别
	private BigDecimal houseArea; //建筑面积
	private BigDecimal houseTotalPrice; //总价
	private BigDecimal houseUnitPrice; //单价
	private Integer houseRoom; // 几房
	private Integer houseHall; // 几厅
	private Integer houseWei; // 几卫
	//客源
	private String custLevel; //客户登记
	private Integer houseRoom1; //房2
	private Integer houseFloorLow; //楼层1
	private Integer houseFloorHigh; //楼层2
	private BigDecimal housePriceLow; //价格1
	private BigDecimal housePriceHigh; //价格2
	private BigDecimal houseAreaLow; //面积1
	private BigDecimal houseAreaHigh; //面积2
	private boolean houseLook; //带看
	private String custName; //客户姓名
	private String custNo; //客户编码

	@Override
	public Integer getUserId() {
		return userId;
	}

	@Override
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPlateType() {
		return plateType;
	}

	public void setPlateType(Integer plateType) {
		this.plateType = plateType;
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

	public String getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}

	public Integer getHouseFloors() {
		return houseFloors;
	}

	public void setHouseFloors(Integer houseFloors) {
		this.houseFloors = houseFloors;
	}

	public Integer getHouseFloor() {
		return houseFloor;
	}

	public void setHouseFloor(Integer houseFloor) {
		this.houseFloor = houseFloor;
	}

	public Integer getHouseMap() {
		return houseMap;
	}

	public void setHouseMap(Integer houseMap) {
		this.houseMap = houseMap;
	}

	public Integer getHouseKey() {
		return houseKey;
	}

	public void setHouseKey(Integer houseKey) {
		this.houseKey = houseKey;
	}

	public boolean isHouseExplrth() {
		return houseExplrth;
	}

	public void setHouseExplrth(boolean houseExplrth) {
		this.houseExplrth = houseExplrth;
	}

	public Integer getHouseLevel() {
		return houseLevel;
	}

	public void setHouseLevel(Integer houseLevel) {
		this.houseLevel = houseLevel;
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

	public BigDecimal getHouseUnitPrice() {
		return houseUnitPrice;
	}

	public void setHouseUnitPrice(BigDecimal houseUnitPrice) {
		this.houseUnitPrice = houseUnitPrice;
	}

	public Integer getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(Integer houseRoom) {
		this.houseRoom = houseRoom;
	}

	public Integer getHouseHall() {
		return houseHall;
	}

	public void setHouseHall(Integer houseHall) {
		this.houseHall = houseHall;
	}

	public Integer getHouseWei() {
		return houseWei;
	}

	public void setHouseWei(Integer houseWei) {
		this.houseWei = houseWei;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public Integer getHouseRoom1() {
		return houseRoom1;
	}

	public void setHouseRoom1(Integer houseRoom1) {
		this.houseRoom1 = houseRoom1;
	}

	public Integer getHouseFloorLow() {
		return houseFloorLow;
	}

	public void setHouseFloorLow(Integer houseFloorLow) {
		this.houseFloorLow = houseFloorLow;
	}

	public Integer getHouseFloorHigh() {
		return houseFloorHigh;
	}

	public void setHouseFloorHigh(Integer houseFloorHigh) {
		this.houseFloorHigh = houseFloorHigh;
	}

	public BigDecimal getHousePriceLow() {
		return housePriceLow;
	}

	public void setHousePriceLow(BigDecimal housePriceLow) {
		this.housePriceLow = housePriceLow;
	}

	public BigDecimal getHousePriceHigh() {
		return housePriceHigh;
	}

	public void setHousePriceHigh(BigDecimal housePriceHigh) {
		this.housePriceHigh = housePriceHigh;
	}

	public BigDecimal getHouseAreaLow() {
		return houseAreaLow;
	}

	public void setHouseAreaLow(BigDecimal houseAreaLow) {
		this.houseAreaLow = houseAreaLow;
	}

	public BigDecimal getHouseAreaHigh() {
		return houseAreaHigh;
	}

	public void setHouseAreaHigh(BigDecimal houseAreaHigh) {
		this.houseAreaHigh = houseAreaHigh;
	}

	public boolean isHouseLook() {
		return houseLook;
	}

	public void setHouseLook(boolean houseLook) {
		this.houseLook = houseLook;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
}
