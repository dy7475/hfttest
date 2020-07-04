package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpVote extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer voteId;
	/**
	 * @mbggenerated
	 */
	private Integer bulletId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer bound;
	/**
	 * @mbggenerated
	 */
	private Byte voteType;
	/**
	 * @mbggenerated
	 */
	private String voteContent;
	/**
	 * @mbggenerated
	 */
	private Integer count;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getVoteId() {
		return voteId;
	}

	/**
	 * @mbggenerated
	 */
	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
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
	public Byte getVoteType() {
		return voteType;
	}

	/**
	 * @mbggenerated
	 */
	public void setVoteType(Byte voteType) {
		this.voteType = voteType;
	}

	/**
	 * @mbggenerated
	 */
	public String getVoteContent() {
		return voteContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setVoteContent(String voteContent) {
		this.voteContent = voteContent == null ? null : voteContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @mbggenerated
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @mbggenerated
	 */
	public ErpVote() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpVote(Integer shardCityId, Integer voteId) {
		super(shardCityId);
		this.voteId = voteId;
	}
}