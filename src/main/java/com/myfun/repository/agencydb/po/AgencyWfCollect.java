package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class AgencyWfCollect implements Serializable {

	/**
	 * @mbggenerated 
	 */
	private Integer id;
	/**
	 * @mbggenerated id
	 */
	private Integer cityId;
	/**
	 * @mbggenerated ûid
	 */
	private String wxId;
	/**
	 * @mbggenerated Դid
	 */
	private Integer caseId;
	/**
	 * @mbggenerated Ƿղ1ղ0ȡղ
	 */
	private Byte caseDataType;
	/**
	 * @mbggenerated Դ1236 7Ԣ 8Ԣ
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * @mbggenerated Դ1ERP 2 н 3 Ѹ 4ź÷ 5
	 */
	private Byte resource;
	/**
	 * @mbggenerated Դ
	 */
	private String subject;
	/**
	 * @mbggenerated 
	 */
	private Integer room;
	/**
	 * @mbggenerated 
	 */
	private Integer hall;
	/**
	 * @mbggenerated 
	 */
	private BigDecimal area;
	/**
	 * @mbggenerated ܼ
	 */
	private BigDecimal totalPrice;
	/**
	 * @mbggenerated ¥
	 */
	private String buildName;
	/**
	 * @mbggenerated 
	 */
	private String regionName;
	/**
	 * @mbggenerated Ƭ
	 */
	private String sectionName;
	/**
	 * @mbggenerated ǩ
	 */
	private String tagIds;
	/**
	 * @mbggenerated ͼַ
	 */
	private String thumbUrl;
	/**
	 * @mbggenerated Ƶ
	 */
	private Integer videoNum;
	/**
	 * @mbggenerated ǷVR
	 */
	private Integer hasPanorama;
	/**
	 * @mbggenerated 淿Դ
	 */
	private Byte trueFlag;
	/**
	 * @mbggenerated λ
	 */
	private Byte priceUnit;
	/**
	 * @mbggenerated 1ԴѾ¼
	 */
	private Byte houseStatus;
	/**
	 * @mbggenerated Դ;
	 */
	private String houseUseage;
	/**
	 * @mbggenerated 
	 */
	private Byte wei;
	/**
	 * @mbggenerated ¥
	 */
	private String floor;
	/**
	 * @mbggenerated ¥
	 */
	private String floors;
	/**
	 * @mbggenerated װ
	 */
	private Byte houseFitment;
	/**
	 * @mbggenerated 
	 */
	private Byte houseDirect;
	/**
	 * @mbggenerated Ԣid
	 */
	private String apartmentUuid;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public String getWxId() {
		return wxId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWxId(String wxId) {
		this.wxId = wxId == null ? null : wxId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseDataType() {
		return caseDataType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseDataType(Byte caseDataType) {
		this.caseDataType = caseDataType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getResource() {
		return resource;
	}

	/**
	 * @mbggenerated
	 */
	public void setResource(Byte resource) {
		this.resource = resource;
	}

	/**
	 * @mbggenerated
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @mbggenerated
	 */
	public void setSubject(String subject) {
		this.subject = subject == null ? null : subject.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRoom() {
		return room;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoom(Integer room) {
		this.room = room;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHall() {
		return hall;
	}

	/**
	 * @mbggenerated
	 */
	public void setHall(Integer hall) {
		this.hall = hall;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getArea() {
		return area;
	}

	/**
	 * @mbggenerated
	 */
	public void setArea(BigDecimal area) {
		this.area = area;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @mbggenerated
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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
	public Integer getHasPanorama() {
		return hasPanorama;
	}

	/**
	 * @mbggenerated
	 */
	public void setHasPanorama(Integer hasPanorama) {
		this.hasPanorama = hasPanorama;
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
	public Byte getHouseStatus() {
		return houseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseStatus(Byte houseStatus) {
		this.houseStatus = houseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage == null ? null : houseUseage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWei() {
		return wei;
	}

	/**
	 * @mbggenerated
	 */
	public void setWei(Byte wei) {
		this.wei = wei;
	}

	/**
	 * @mbggenerated
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @mbggenerated
	 */
	public void setFloor(String floor) {
		this.floor = floor == null ? null : floor.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getFloors() {
		return floors;
	}

	/**
	 * @mbggenerated
	 */
	public void setFloors(String floors) {
		this.floors = floors == null ? null : floors.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseFitment() {
		return houseFitment;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseFitment(Byte houseFitment) {
		this.houseFitment = houseFitment;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseDirect() {
		return houseDirect;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseDirect(Byte houseDirect) {
		this.houseDirect = houseDirect;
	}

	/**
	 * @mbggenerated
	 */
	public String getApartmentUuid() {
		return apartmentUuid;
	}

	/**
	 * @mbggenerated
	 */
	public void setApartmentUuid(String apartmentUuid) {
		this.apartmentUuid = apartmentUuid == null ? null : apartmentUuid.trim();
	}
}