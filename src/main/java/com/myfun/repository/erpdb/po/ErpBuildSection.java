package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpBuildSection extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	private Integer sectionId;
	/**
	 * @mbggenerated
	 */
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	private String houseRound;
	/**
	 * @mbggenerated
	 */
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	private String buildAddr;
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
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
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
	public String getHouseRound() {
		return houseRound;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRound(String houseRound) {
		this.houseRound = houseRound == null ? null : houseRound.trim();
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
	public String getBuildAddr() {
		return buildAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildAddr(String buildAddr) {
		this.buildAddr = buildAddr == null ? null : buildAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildSection() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildSection(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}