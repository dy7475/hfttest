package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpWdIntentionCustomer extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer intentionId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer regionId;
	/**
	 * @mbggenerated
	 */
	private String regionName;
	/**
	 * @mbggenerated
	 */
	private String sectors;
	/**
	 * @mbggenerated
	 */
	private String sectorsName;
	/**
	 * @mbggenerated
	 */
	private BigDecimal priceLowest;
	/**
	 * @mbggenerated
	 */
	private BigDecimal priceHighest;
	/**
	 * @mbggenerated
	 */
	private Byte room;
	/**
	 * @mbggenerated
	 */
	private String tags;
	/**
	 * @mbggenerated
	 */
	private String userMobile;
	/**
	 * @mbggenerated
	 */
	private String desc;
	/**
	 * @mbggenerated
	 */
	private Byte type;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * @mbggenerated
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private String custName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getIntentionId() {
		return intentionId;
	}

	/**
	 * @mbggenerated
	 */
	public void setIntentionId(Integer intentionId) {
		this.intentionId = intentionId;
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
	public Integer getRegionId() {
		return regionId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
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
	public String getSectorsName() {
		return sectorsName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSectorsName(String sectorsName) {
		this.sectorsName = sectorsName == null ? null : sectorsName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getPriceLowest() {
		return priceLowest;
	}

	/**
	 * @mbggenerated
	 */
	public void setPriceLowest(BigDecimal priceLowest) {
		this.priceLowest = priceLowest;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getPriceHighest() {
		return priceHighest;
	}

	/**
	 * @mbggenerated
	 */
	public void setPriceHighest(BigDecimal priceHighest) {
		this.priceHighest = priceHighest;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRoom() {
		return room;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoom(Byte room) {
		this.room = room;
	}

	/**
	 * @mbggenerated
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @mbggenerated
	 */
	public void setTags(String tags) {
		this.tags = tags == null ? null : tags.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @mbggenerated
	 */
	public void setDesc(String desc) {
		this.desc = desc == null ? null : desc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * @mbggenerated
	 */
	public void setType(Byte type) {
		this.type = type;
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
	public Byte getStatus() {
		return status;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @mbggenerated
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpWdIntentionCustomer() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpWdIntentionCustomer(Integer shardCityId, Integer intentionId) {
		super(shardCityId);
		this.intentionId = intentionId;
	}
}