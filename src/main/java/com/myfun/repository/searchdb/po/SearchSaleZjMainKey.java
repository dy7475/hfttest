package com.myfun.repository.searchdb.po;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class SearchSaleZjMainKey implements Serializable {

	@Field(value = "SALE_ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

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

	@Field(value = "CITY_ID")
	private Short cityId;
}