package com.myfun.repository.admindb.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class AdminFunDeptsDistri implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer devloperId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte distriType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer currDeptid;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getDevloperId() {
		return devloperId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDevloperId(Integer devloperId) {
		this.devloperId = devloperId;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getDistriType() {
		return distriType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDistriType(Byte distriType) {
		this.distriType = distriType;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCurrDeptid() {
		return currDeptid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCurrDeptid(Integer currDeptid) {
		this.currDeptid = currDeptid;
	}
}