package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFielddocument extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private String tablename;
	/**
	 * @mbggenerated
	 */
	private String field;
	/**
	 * @mbggenerated
	 */
	private String description;
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
	public String getTablename() {
		return tablename;
	}

	/**
	 * @mbggenerated
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename == null ? null : tablename.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getField() {
		return field;
	}

	/**
	 * @mbggenerated
	 */
	public void setField(String field) {
		this.field = field == null ? null : field.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @mbggenerated
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFielddocument() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFielddocument(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}