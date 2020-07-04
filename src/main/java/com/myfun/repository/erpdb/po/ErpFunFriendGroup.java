package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunFriendGroup extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer groupId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private String groupName;
	/**
	 * @mbggenerated
	 */
	private String createTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * @mbggenerated
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @mbggenerated
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunFriendGroup() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunFriendGroup(Integer shardCityId, Integer groupId) {
		super(shardCityId);
		this.groupId = groupId;
	}
}