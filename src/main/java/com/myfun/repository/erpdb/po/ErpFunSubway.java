package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunSubway extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer swId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private String swName;
	/**
	 * @mbggenerated
	 */
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getSwId() {
		return swId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSwId(Integer swId) {
		this.swId = swId;
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
	public String getSwName() {
		return swName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSwName(String swName) {
		this.swName = swName == null ? null : swName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSubway() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSubway(Integer shardCityId, Integer swId) {
		super(shardCityId);
		this.swId = swId;
	}
}