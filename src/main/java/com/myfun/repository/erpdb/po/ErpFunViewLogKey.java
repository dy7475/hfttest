package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunViewLogKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer viewId;
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
	public Integer getViewId() {
		return viewId;
	}

	/**
	 * @mbggenerated
	 */
	public void setViewId(Integer viewId) {
		this.viewId = viewId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunViewLogKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunViewLogKey(Integer shardCityId, Integer compId, Integer viewId) {
		super(shardCityId);
		this.compId = compId;
		this.viewId = viewId;
	}
}