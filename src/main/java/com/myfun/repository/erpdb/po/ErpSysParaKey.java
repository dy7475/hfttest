package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ErpSysParaKey extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private String paramId;

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商ID")
	private Integer partnerId = 0;
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
	public String getParamId() {
		return paramId;
	}

	/**
	 * @mbggenerated
	 */
	public void setParamId(String paramId) {
		this.paramId = paramId == null ? null : paramId.trim();
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

}