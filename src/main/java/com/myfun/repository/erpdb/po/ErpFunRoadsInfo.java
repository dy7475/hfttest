package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunRoadsInfo extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键自增
	 */
	private Integer id;
	/**
	 * @mbggenerated 干道名称
	 */
	private String roadsName;
	/**
	 * @mbggenerated 第三方干道ID 
	 */
	private String thirdRoadsId;
	/**
	 * @mbggenerated
	 */
	private String roadsCode;
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
	public String getRoadsName() {
		return roadsName;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoadsName(String roadsName) {
		this.roadsName = roadsName == null ? null : roadsName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getThirdRoadsId() {
		return thirdRoadsId;
	}

	/**
	 * @mbggenerated
	 */
	public void setThirdRoadsId(String thirdRoadsId) {
		this.thirdRoadsId = thirdRoadsId == null ? null : thirdRoadsId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRoadsCode() {
		return roadsCode;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoadsCode(String roadsCode) {
		this.roadsCode = roadsCode == null ? null : roadsCode.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoadsInfo() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoadsInfo(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}