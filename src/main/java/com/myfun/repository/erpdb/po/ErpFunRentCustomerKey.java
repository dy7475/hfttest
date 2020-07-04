package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunRentCustomerKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 求租ID，自增序列
	 */
	private Integer rentCustId;
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
	public Integer getRentCustId() {
		return rentCustId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentCustId(Integer rentCustId) {
		this.rentCustId = rentCustId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRentCustomerKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRentCustomerKey(Integer shardCityId, Integer compId, Integer rentCustId) {
		super(shardCityId);
		this.compId = compId;
		this.rentCustId = rentCustId;
	}
}