package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyWfRecomHouse;

public class AgencyWfRecomHouseDto extends AgencyWfRecomHouse {

	private static final long serialVersionUID = 1L;
	private String blCount;// 保留意向量
	private String buildName;// 楼盘名称
	private String houseUseAge;// 房屋用途
	private String houseRoom;// 几室
	private String houseHall;// 几厅
	private String houseWei;// 几卫
	private String houseArea;// 面积
	private String houseFitment;// 装修情况
	private String houseFloor;// 当前楼层
	private String houseFloors;// 总楼层
	private String isTrue;// 1=真房源
	private String blStatus;// 0=保留意向,1=不再考虑
	private String price;// 业主标价
	private String photoCount;// 图片总量
	private String photoAddr;// 首图地址
	private String praiseNum;// 好评数
	private String rentId;// 房源ID
	private String isDeal;// 1=已成交
	private String intentionRate;// 保留意向占比

	public String getIntentionRate() {
		return intentionRate;
	}

	public void setIntentionRate(String intentionRate) {
		this.intentionRate = intentionRate;
	}

	public String getBlCount() {
		return blCount;
	}

	public void setBlCount(String blCount) {
		this.blCount = blCount;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getHouseUseAge() {
		return houseUseAge;
	}

	public void setHouseUseAge(String houseUseAge) {
		this.houseUseAge = houseUseAge;
	}

	public String getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(String houseRoom) {
		this.houseRoom = houseRoom;
	}

	public String getHouseHall() {
		return houseHall;
	}

	public void setHouseHall(String houseHall) {
		this.houseHall = houseHall;
	}

	public String getHouseWei() {
		return houseWei;
	}

	public void setHouseWei(String houseWei) {
		this.houseWei = houseWei;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getHouseFitment() {
		return houseFitment;
	}

	public void setHouseFitment(String houseFitment) {
		this.houseFitment = houseFitment;
	}

	public String getHouseFloor() {
		return houseFloor;
	}

	public void setHouseFloor(String houseFloor) {
		this.houseFloor = houseFloor;
	}

	public String getHouseFloors() {
		return houseFloors;
	}

	public void setHouseFloors(String houseFloors) {
		this.houseFloors = houseFloors;
	}

	public String getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}

	public String getBlStatus() {
		return blStatus;
	}

	public void setBlStatus(String blStatus) {
		this.blStatus = blStatus;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(String photoCount) {
		this.photoCount = photoCount;
	}

	public String getPhotoAddr() {
		return photoAddr;
	}

	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	public String getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(String praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getRentId() {
		return rentId;
	}

	public void setRentId(String rentId) {
		this.rentId = rentId;
	}

	public String getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(String isDeal) {
		this.isDeal = isDeal;
	}

}
