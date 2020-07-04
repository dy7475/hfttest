package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunHousePublishStatus extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer pubId;
	/**
	 * @mbggenerated
	 */
	private Integer houseId;
	/**
	 * @mbggenerated
	 */
	private Byte saleLease;
	/**
	 * @mbggenerated
	 */
	private Byte houseUseage;
	/**
	 * @mbggenerated
	 */
	private Integer publishSite;
	/**
	 * @mbggenerated
	 */
	private Byte checkStatus;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private Integer siteId;
	/**
	 * @mbggenerated
	 */
	private Integer fatherId;
	/**
	 * @mbggenerated
	 */
	private Integer sId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer checkUser;
	/**
	 * @mbggenerated
	 */
	private Integer syncFlag;
	/**
	 * @mbggenerated
	 */
	private Byte syncFlagBaidu;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getPubId() {
		return pubId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHouseId() {
		return houseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSaleLease() {
		return saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleLease(Byte saleLease) {
		this.saleLease = saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPublishSite() {
		return publishSite;
	}

	/**
	 * @mbggenerated
	 */
	public void setPublishSite(Integer publishSite) {
		this.publishSite = publishSite;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCheckStatus() {
		return checkStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckStatus(Byte checkStatus) {
		this.checkStatus = checkStatus;
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
	public Integer getSiteId() {
		return siteId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFatherId() {
		return fatherId;
	}

	/**
	 * @mbggenerated
	 */
	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getsId() {
		return sId;
	}

	/**
	 * @mbggenerated
	 */
	public void setsId(Integer sId) {
		this.sId = sId;
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
	public Integer getCheckUser() {
		return checkUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckUser(Integer checkUser) {
		this.checkUser = checkUser;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSyncFlag() {
		return syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSyncFlagBaidu() {
		return syncFlagBaidu;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncFlagBaidu(Byte syncFlagBaidu) {
		this.syncFlagBaidu = syncFlagBaidu;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunHousePublishStatus() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunHousePublishStatus(Integer shardCityId, Integer pubId) {
		super(shardCityId);
		this.pubId = pubId;
	}
}