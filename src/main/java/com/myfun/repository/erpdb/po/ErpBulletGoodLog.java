package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpBulletGoodLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private Integer bound;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer bulletId;
	/**
	 * @mbggenerated
	 */
	private Integer replayId;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
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
	public Integer getBound() {
		return bound;
	}

	/**
	 * @mbggenerated
	 */
	public void setBound(Integer bound) {
		this.bound = bound;
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
	public Integer getReplayId() {
		return replayId;
	}

	/**
	 * @mbggenerated
	 */
	public void setReplayId(Integer replayId) {
		this.replayId = replayId;
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
	public ErpBulletGoodLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBulletGoodLog(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}