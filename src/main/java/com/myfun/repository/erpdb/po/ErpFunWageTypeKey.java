package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunWageTypeKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer wagetypeId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getWagetypeId() {
		return wagetypeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWagetypeId(Integer wagetypeId) {
		this.wagetypeId = wagetypeId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageTypeKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageTypeKey(Integer shardCityId, Integer wagetypeId, Integer compId) {
		super(shardCityId);
		this.wagetypeId = wagetypeId;
		this.compId = compId;
	}
}