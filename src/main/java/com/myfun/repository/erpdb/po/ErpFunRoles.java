package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunRoles extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String roleId;
	/**
	 * @mbggenerated
	 */
	private String roleName;
	/**
	 * @mbggenerated
	 */
	private Byte seqNo;
	/**
	 * @mbggenerated
	 */
	private Byte manageFlag;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

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
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeqNo(Byte seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getManageFlag() {
		return manageFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setManageFlag(Byte manageFlag) {
		this.manageFlag = manageFlag;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoles() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoles(Integer shardCityId, String roleId) {
		super(shardCityId);
		this.roleId = roleId;
	}
}