package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpRichTextKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer saleLease;
	/**
	 * @mbggenerated
	 */
	private Integer houseId;
	/**
	 * @mbggenerated
	 */
	private Byte houseUseage;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getSaleLease() {
		return saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleLease(Integer saleLease) {
		this.saleLease = saleLease;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHouseId() {
		return houseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getHouseUseage() {
		return houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseUseage(Byte houseUseage) {
		this.houseUseage = houseUseage;
	}

	/**
	 * @mbggenerated
	 */
	public ErpRichTextKey() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpRichTextKey(Integer shardCityId, Integer saleLease, Integer houseId, Byte houseUseage) {
		super(shardCityId);
		this.saleLease = saleLease;
		this.houseId = houseId;
		this.houseUseage = houseUseage;
	}
}