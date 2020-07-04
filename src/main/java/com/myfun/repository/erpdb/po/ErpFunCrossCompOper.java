package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpFunCrossCompOper extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String operId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String operName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte operValue;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业务管理=1、人事管理=2")
	private Byte operType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated -
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOperId() {
		return operId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOperId(String operId) {
		this.operId = operId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOperName() {
		return operName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOperName(String operName) {
		this.operName = operName;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getOperValue() {
		return operValue;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOperValue(Byte operValue) {
		this.operValue = operValue;
	}

	/**
	 * @mbggenerated 业务管理=1、人事管理=2
	 */
	public Byte getOperType() {
		return operType;
	}

	/**
	 * @mbggenerated 业务管理=1、人事管理=2
	 */
	public void setOperType(Byte operType) {
		this.operType = operType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunCrossCompOper() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunCrossCompOper(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}