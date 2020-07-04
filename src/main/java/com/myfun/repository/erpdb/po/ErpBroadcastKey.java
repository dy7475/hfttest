package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpBroadcastKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private Integer bulletId;
	/**
	 * @mbggenerated
	 */
	private Integer bcType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

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
	public Integer getBulletId() {
		return bulletId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBulletId(Integer bulletId) {
		this.bulletId = bulletId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBcType() {
		return bcType;
	}

	/**
	 * @mbggenerated
	 */
	public void setBcType(Integer bcType) {
		this.bcType = bcType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBroadcastKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBroadcastKey(Integer shardCityId, Integer archiveId, Integer userId, Integer bulletId, Integer bcType) {
		super(shardCityId);
		this.archiveId = archiveId;
		this.userId = userId;
		this.bulletId = bulletId;
		this.bcType = bcType;
	}
}