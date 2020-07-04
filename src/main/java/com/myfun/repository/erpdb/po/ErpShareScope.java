package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpShareScope extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private String compIds;
	/**
	 * @mbggenerated
	 */
	private String shareSubject;
	/**
	 * @mbggenerated
	 */
	private Integer scopeId;
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
	public String getCompIds() {
		return compIds;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompIds(String compIds) {
		this.compIds = compIds == null ? null : compIds.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getShareSubject() {
		return shareSubject;
	}

	/**
	 * @mbggenerated
	 */
	public void setShareSubject(String shareSubject) {
		this.shareSubject = shareSubject == null ? null : shareSubject.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getScopeId() {
		return scopeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpShareScope() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpShareScope(Integer shardCityId, Integer compId) {
		super(shardCityId);
		this.compId = compId;
	}
}