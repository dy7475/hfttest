package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpUserRolesKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private String roleId;
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
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId == null ? null : roleId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpUserRolesKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpUserRolesKey(Integer shardCityId, Integer userId, String roleId) {
		super(shardCityId);
		this.userId = userId;
		this.roleId = roleId;
	}
}