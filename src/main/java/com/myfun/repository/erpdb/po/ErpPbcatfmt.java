package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpPbcatfmt extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String pbfName;
	/**
	 * @mbggenerated
	 */
	private String pbfFrmt;
	/**
	 * @mbggenerated
	 */
	private Short pbfType;
	/**
	 * @mbggenerated
	 */
	private Integer pbfCntr;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getPbfName() {
		return pbfName;
	}

	/**
	 * @mbggenerated
	 */
	public void setPbfName(String pbfName) {
		this.pbfName = pbfName == null ? null : pbfName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPbfFrmt() {
		return pbfFrmt;
	}

	/**
	 * @mbggenerated
	 */
	public void setPbfFrmt(String pbfFrmt) {
		this.pbfFrmt = pbfFrmt == null ? null : pbfFrmt.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Short getPbfType() {
		return pbfType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPbfType(Short pbfType) {
		this.pbfType = pbfType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPbfCntr() {
		return pbfCntr;
	}

	/**
	 * @mbggenerated
	 */
	public void setPbfCntr(Integer pbfCntr) {
		this.pbfCntr = pbfCntr;
	}

	/**
	 * @mbggenerated
	 */
	public ErpPbcatfmt() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpPbcatfmt(Integer shardCityId) {
		super(shardCityId);
	}
}