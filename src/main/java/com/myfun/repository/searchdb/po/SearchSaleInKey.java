package com.myfun.repository.searchdb.po;

import java.io.Serializable;
import org.apache.solr.client.solrj.beans.Field;

public class SearchSaleInKey implements Serializable {
	/**
	 * @mbggenerated 省id
	 */
	@Field(value = "PROVINCE_ID")
	private Byte provinceId;
	/**
	 * @mbggenerated 市id
	 */
	@Field(value = "CITY_ID")
	private Short cityId;
	/**
	 * @mbggenerated 房源标示唯一（crm(市id+00+id)）
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
	public Byte getProvinceId() {
		return provinceId;
	}

	/**
	 * @mbggenerated
	 */
	public void setProvinceId(Byte provinceId) {
		this.provinceId = provinceId;
	}

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

	public SearchSaleInKey() {
		super();
	}

	public SearchSaleInKey(Byte provinceId, Short cityId, Integer id) {
		super();
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.id = id;
	}

}