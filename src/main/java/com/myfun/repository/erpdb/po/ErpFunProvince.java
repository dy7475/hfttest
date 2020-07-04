package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunProvince extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Short provinceId;
	/**
	 * @mbggenerated
	 */
	private String provinceName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Short getProvinceId() {
		return provinceId;
	}

	/**
	 * @mbggenerated
	 */
	public void setProvinceId(Short provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @mbggenerated
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * @mbggenerated
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName == null ? null : provinceName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProvince() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProvince(Integer shardCityId, Short provinceId) {
		super(shardCityId);
		this.provinceId = provinceId;
	}
}