package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpTraceXeActionMap extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Short traceColumnId;
	/**
	 * @mbggenerated
	 */
	private String packageName;
	/**
	 * @mbggenerated
	 */
	private String xeActionName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Short getTraceColumnId() {
		return traceColumnId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTraceColumnId(Short traceColumnId) {
		this.traceColumnId = traceColumnId;
	}

	/**
	 * @mbggenerated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @mbggenerated
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName == null ? null : packageName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getXeActionName() {
		return xeActionName;
	}

	/**
	 * @mbggenerated
	 */
	public void setXeActionName(String xeActionName) {
		this.xeActionName = xeActionName == null ? null : xeActionName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpTraceXeActionMap() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpTraceXeActionMap(Integer shardCityId) {
		super(shardCityId);
	}
}