package com.myfun.repository.erpdb.param;

import com.myfun.repository.support.param.PageParam;

public class ErpBuildingInfoParam extends PageParam{

	private String regName;
	private Integer provinceId;
	private Integer cityId;
	private Integer shardCityId;
	private Integer buildRegion;
	private String buildName;
	private String buildCode;
	private Integer buildPhoto;
	private Integer positionFlag;
	private Integer vertifyFlag;
	private Integer examFlag;
	private String createTime;
	private Integer buildStatus;
	private Integer price;
	private String sellTele1;
	private Integer typicFlag;
	
	public Integer getBuildRegion() {
		return buildRegion;
	}
	public void setBuildRegion(Integer buildRegion) {
		this.buildRegion = buildRegion;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getBuildCode() {
		return buildCode;
	}
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}
	public Integer getBuildPhoto() {
		return buildPhoto;
	}
	public void setBuildPhoto(Integer buildPhoto) {
		this.buildPhoto = buildPhoto;
	}
	public Integer getPositionFlag() {
		return positionFlag;
	}
	public void setPositionFlag(Integer positionFlag) {
		this.positionFlag = positionFlag;
	}
	public Integer getVertifyFlag() {
		return vertifyFlag;
	}
	public void setVertifyFlag(Integer vertifyFlag) {
		this.vertifyFlag = vertifyFlag;
	}
	public Integer getExamFlag() {
		return examFlag;
	}
	public void setExamFlag(Integer examFlag) {
		this.examFlag = examFlag;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getBuildStatus() {
		return buildStatus;
	}
	public void setBuildStatus(Integer buildStatus) {
		this.buildStatus = buildStatus;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getSellTele1() {
		return sellTele1;
	}
	public void setSellTele1(String sellTele1) {
		this.sellTele1 = sellTele1;
	}
	public Integer getTypicFlag() {
		return typicFlag;
	}
	public void setTypicFlag(Integer typicFlag) {
		this.typicFlag = typicFlag;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getShardCityId() {
		return shardCityId;
	}
	public void setShardCityId(Integer shardCityId) {
		this.shardCityId = shardCityId;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	 
	 
}
