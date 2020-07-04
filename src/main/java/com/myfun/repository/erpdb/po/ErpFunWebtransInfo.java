package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunWebtransInfo extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Long id;
	/**
	 * @mbggenerated
	 */
	private String dbName;
	/**
	 * @mbggenerated
	 */
	private String tableName;
	/**
	 * @mbggenerated
	 */
	private String caseId;
	/**
	 * @mbggenerated
	 */
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	private Integer dealType;
	/**
	 * @mbggenerated
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private Integer processFlag;
	/**
	 * @mbggenerated
	 */
	private String caseIdOld;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @mbggenerated
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName == null ? null : dbName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @mbggenerated
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId == null ? null : caseId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealType() {
		return dealType;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
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
	public Integer getProcessFlag() {
		return processFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setProcessFlag(Integer processFlag) {
		this.processFlag = processFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getCaseIdOld() {
		return caseIdOld;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseIdOld(String caseIdOld) {
		this.caseIdOld = caseIdOld == null ? null : caseIdOld.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWebtransInfo() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWebtransInfo(Integer shardCityId, Long id) {
		super(shardCityId);
		this.id = id;
	}
}