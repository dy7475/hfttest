package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunFriendKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private Integer friendArchiveId;
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
	public Integer getFriendArchiveId() {
		return friendArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setFriendArchiveId(Integer friendArchiveId) {
		this.friendArchiveId = friendArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunFriendKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunFriendKey(Integer shardCityId, Integer archiveId, Integer friendArchiveId) {
		super(shardCityId);
		this.archiveId = archiveId;
		this.friendArchiveId = friendArchiveId;
	}
}