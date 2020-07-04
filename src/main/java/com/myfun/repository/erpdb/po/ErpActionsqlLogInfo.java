package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpActionsqlLogInfo extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private String logtime;
	/**
	 * @mbggenerated
	 */
	private String loginfo;
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
	public String getLogtime() {
		return logtime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLogtime(String logtime) {
		this.logtime = logtime == null ? null : logtime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getLoginfo() {
		return loginfo;
	}

	/**
	 * @mbggenerated
	 */
	public void setLoginfo(String loginfo) {
		this.loginfo = loginfo == null ? null : loginfo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpActionsqlLogInfo() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpActionsqlLogInfo(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}