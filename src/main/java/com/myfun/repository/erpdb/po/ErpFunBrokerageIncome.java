package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class ErpFunBrokerageIncome extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 类型 101出售 102出租
	 */
	private Byte commionType;
	/**
	 * @mbggenerated 房源比例
	 */
	private BigDecimal houseRate;
	/**
	 * @mbggenerated 客源比例
	 */
	private BigDecimal customerRate;
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
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCommionType() {
		return commionType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCommionType(Byte commionType) {
		this.commionType = commionType;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getHouseRate() {
		return houseRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseRate(BigDecimal houseRate) {
		this.houseRate = houseRate;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCustomerRate() {
		return customerRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setCustomerRate(BigDecimal customerRate) {
		this.customerRate = customerRate;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBrokerageIncome() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBrokerageIncome(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}