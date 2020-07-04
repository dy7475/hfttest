package com.myfun.repository.search2db.po;

import java.io.Serializable;
import org.apache.solr.client.solrj.beans.Field;

public class Search2ShopMainKey implements Serializable {

	/**
	 * @mbggenerated 城市ID
	 */
	@Field(value = "CITY_ID")
	private Short cityId;
	/**
	 * @mbggenerated 唯一序列
	 */
	@Field(value = "ID")
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
}