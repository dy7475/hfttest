package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunProcessOld extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String dealNo;
	/**
	 * @mbggenerated
	 */
	private Integer proType;
	/**
	 * @mbggenerated
	 */
	private String content;
	/**
	 * @mbggenerated
	 */
	private Integer warmFlag;
	/**
	 * @mbggenerated
	 */
	private Date warmTime;
	/**
	 * @mbggenerated
	 */
	private String warmContent;
	/**
	 * @mbggenerated
	 */
	private String updateUserno;
	/**
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getDealNo() {
		return dealNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealNo(String dealNo) {
		this.dealNo = dealNo == null ? null : dealNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getProType() {
		return proType;
	}

	/**
	 * @mbggenerated
	 */
	public void setProType(Integer proType) {
		this.proType = proType;
	}

	/**
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWarmFlag() {
		return warmFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setWarmFlag(Integer warmFlag) {
		this.warmFlag = warmFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Date getWarmTime() {
		return warmTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setWarmTime(Date warmTime) {
		this.warmTime = warmTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getWarmContent() {
		return warmContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setWarmContent(String warmContent) {
		this.warmContent = warmContent == null ? null : warmContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getUpdateUserno() {
		return updateUserno;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateUserno(String updateUserno) {
		this.updateUserno = updateUserno == null ? null : updateUserno.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	public ErpFunProcessOld() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProcessOld(Integer shardCityId) {
		super(shardCityId);
	}
}