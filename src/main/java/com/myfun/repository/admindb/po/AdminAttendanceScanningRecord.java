package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdminAttendanceScanningRecord implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer attId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte dealType;
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
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	public Integer getAttId() {
		return attId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAttId(Integer attId) {
		this.attId = attId;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getDealType() {
		return dealType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}
}