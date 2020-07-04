package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpUserOpersKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private String operId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public String getOperId() {
		return operId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOperId(String operId) {
		this.operId = operId == null ? null : operId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpUserOpersKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpUserOpersKey(Integer shardCityId, Integer userId, String operId) {
		super(shardCityId);
		this.userId = userId;
		this.operId = operId;
	}
}