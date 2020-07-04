package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
@ApiModel
public class ErpFunBrokerage extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated 为0时表示为模版数据
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated 收取佣金比例
	 */
	@ApiModelProperty(value = "收取佣金比例")
	private BigDecimal brokerageRate;
	/**
	 * @mbggenerated 收取佣金计算方式1:百分比计算 2:按月租金计算
	 */
	@ApiModelProperty(value = "收取佣金计算方式1:百分比计算 2:按月租金计算")
	private Integer brokerageCountType;
	/**
	 * @mbggenerated 租售类型 1:售 2:租，DD:CASE_TYPE
	 */
	@ApiModelProperty(value = "租售类型 1:售 2:租，DD:CASE_TYPE")
	private Integer saleLease;
	/**
	 * @mbggenerated 房源方(房东)收取佣金比例
	 */
	@ApiModelProperty(value = "房源方(房东)收取佣金比例")
	private BigDecimal chargeHouseRate;
	/**
	 * @mbggenerated 客户方收取佣金比例
	 */
	@ApiModelProperty(value = "客户方收取佣金比例")
	private BigDecimal chargeCustRate;
	/**
	 * @mbggenerated 房源经纪人发放佣金比例
	 */
	@ApiModelProperty(value = "房源经纪人发放佣金比例")
	private BigDecimal brokerHouseRate;
	/**
	 * @mbggenerated 客源经纪人发放佣金比例
	 */
	@ApiModelProperty(value = "客源经纪人发放佣金比例")
	private BigDecimal brokerCustRate;
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
	public BigDecimal getBrokerageRate() {
		return brokerageRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerageRate(BigDecimal brokerageRate) {
		this.brokerageRate = brokerageRate;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBrokerageCountType() {
		return brokerageCountType;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerageCountType(Integer brokerageCountType) {
		this.brokerageCountType = brokerageCountType;
	}

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
	public BigDecimal getChargeHouseRate() {
		return chargeHouseRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setChargeHouseRate(BigDecimal chargeHouseRate) {
		this.chargeHouseRate = chargeHouseRate;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getChargeCustRate() {
		return chargeCustRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setChargeCustRate(BigDecimal chargeCustRate) {
		this.chargeCustRate = chargeCustRate;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getBrokerHouseRate() {
		return brokerHouseRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerHouseRate(BigDecimal brokerHouseRate) {
		this.brokerHouseRate = brokerHouseRate;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getBrokerCustRate() {
		return brokerCustRate;
	}

	/**
	 * @mbggenerated
	 */
	public void setBrokerCustRate(BigDecimal brokerCustRate) {
		this.brokerCustRate = brokerCustRate;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBrokerage() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBrokerage(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}