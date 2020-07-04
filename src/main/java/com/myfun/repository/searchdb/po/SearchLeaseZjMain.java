package com.myfun.repository.searchdb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

import com.myfun.utils.StringUtil;

public class SearchLeaseZjMain extends SearchLeaseZjMainKey implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String sectors;

	/**
	 * @mbggenerated
	 */
	private Integer chu;

	/**
	 * @mbggenerated
	 */
	private Integer yang;

	/**
	 * @mbggenerated
	 */
	private Byte filterFlag;

	/**
	 * @mbggenerated
	 */
	private Boolean syncFlag;

	/**
	 * @mbggenerated
	 */
	private Integer repeatFlag;

	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Date getInTime() {
		return inTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @mbggenerated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
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
	public String getUseage() {
		return useage;
	}

	public void setUseage(String useage) {
		this.useage = StringUtil.isEmpty(useage) ? null : useage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSectors() {
		return sectors;
	}

	/**
	 * @mbggenerated
	 */
	public void setSectors(String sectors) {
		this.sectors = sectors == null ? null : sectors.trim();
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
	public Integer getFloor() {
		return floor;
	}

	/**
	 * @mbggenerated
	 */
	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	/**
	 * @mbggenerated
	 */
	public String getFitment() {
		return fitment;
	}

	public void setFitment(String fitment) {
		this.fitment = StringUtil.isEmpty(fitment) ? null : fitment.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDirect() {
		return direct;
	}

	/**
	 * @mbggenerated
	 */
	public void setDirect(String direct) {
		this.direct = StringUtil.isEmpty(direct) ? null : direct.trim();
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
	public String getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = null;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getImgFlag() {
		return imgFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setImgFlag(Byte imgFlag) {
		this.imgFlag = imgFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getStatusFlag() {
		return statusFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatusFlag(Byte statusFlag) {
		this.statusFlag = statusFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getSmallPic() {
		return smallPic;
	}

	/**
	 * @mbggenerated
	 */
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic == null ? null : smallPic.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwner(String owner) {
		this.owner = owner == null ? null : owner.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegion(String region) {
		this.region = region == null ? null : region.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRound() {
		return round;
	}

	/**
	 * @mbggenerated
	 */
	public void setRound(String round) {
		this.round = StringUtil.isEmpty(round) ? null : round.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @mbggenerated
	 */
	public void setSection(String section) {
		this.section = section == null ? null : section.trim();
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
	public Integer getWei() {
		return wei;
	}

	/**
	 * @mbggenerated
	 */
	public void setWei(Integer wei) {
		this.wei = wei;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getChu() {
		return chu;
	}

	/**
	 * @mbggenerated
	 */
	public void setChu(Integer chu) {
		this.chu = chu;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getYang() {
		return yang;
	}

	/**
	 * @mbggenerated
	 */
	public void setYang(Integer yang) {
		this.yang = yang;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFloors() {
		return floors;
	}

	/**
	 * @mbggenerated
	 */
	public void setFloors(Integer floors) {
		this.floors = floors;
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
	public String getCharact() {
		return charact;
	}

	/**
	 * @mbggenerated
	 */
	public void setCharact(String charact) {
		this.charact = charact == null ? null : charact.trim();
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
	public Byte getFilterFlag() {
		return filterFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setFilterFlag(Byte filterFlag) {
		this.filterFlag = filterFlag;
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
	public Boolean getSyncFlag() {
		return syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncFlag(Boolean syncFlag) {
		this.syncFlag = syncFlag;
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
	public Integer getRepeatFlag() {
		return repeatFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setRepeatFlag(Integer repeatFlag) {
		this.repeatFlag = repeatFlag;
	}

	@Field(value = "CREATION_TIME")
	private Date inTime;

	@Field(value = "LEASE_SUBJECT")
	private String title;

	@Field(value = "BUILD_NAME")
	private String buildName;

	@Field(value = "LEASE_USEAGE")
	private String useage;

	@Field(value = "LEASE_ROOM")
	private Integer room;

	@Field(value = "UNIT_FLOOR")
	private Integer floor;

	@Field(value = "LEASE_FITMENT")
	private String fitment;

	@Field(value = "LEASE_DIRECT")
	private String direct;

	@Field(value = "UG_AREA")
	private BigDecimal area;

	@Field(value = "LEASE_TOTAL_PRICE")
	private BigDecimal totalPrice;

	@Field(value = "PRICE_UNIT")
	private String priceUnit;

	@Field(value = "LEASE_MAP")
	private Byte imgFlag;

	@Field(value = "LEASE_STATUS")
	private Byte statusFlag;

	@Field(value = "THUMB_URL")
	private String smallPic;

	@Field(value = "LEASE_OWNER")
	private String owner;

	@Field(value = "REGION_NAME")
	private String region;

	@Field(value = "LEASE_ROUND")
	private String round;

	@Field(value = "SECTION_NAME")
	private String section;

	@Field(value = "LEASE_HALL")
	private Integer hall;

	@Field(value = "LEASE_WEI")
	private Integer wei;

	@Field(value = "LEASE_FLOORS")
	private Integer floors;

	@Field(value = "BUILD_ID")
	private Integer buildId;

	@Field(value = "LEASE_CHARACT")
	private String charact;

	@Field(value = "REG_ID")
	private Integer regId;

	@Field(value = "UPDATE_TIME")
	private Date updateTime;

	@Field(value = "SECTION_ID")
	private Integer sectionId;
}