package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpTrackUsersKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private String trackTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

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
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

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
	public String getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackTime(String trackTime) {
		this.trackTime = trackTime == null ? null : trackTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpTrackUsersKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpTrackUsersKey(Integer shardCityId, Integer compId, Integer trackId, Integer userId, String trackTime) {
		super(shardCityId);
		this.compId = compId;
		this.trackId = trackId;
		this.userId = userId;
		this.trackTime = trackTime;
	}
}