package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunProcessLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * @mbggenerated 1:配置 2：步骤
	 */
	private Byte influenceType;
	/**
	 * @mbggenerated
	 */
	private Integer influenceId;
	/**
	 * @mbggenerated
	 */
	private String content;
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
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getInfluenceType() {
		return influenceType;
	}

	/**
	 * @mbggenerated
	 */
	public void setInfluenceType(Byte influenceType) {
		this.influenceType = influenceType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getInfluenceId() {
		return influenceId;
	}

	/**
	 * @mbggenerated
	 */
	public void setInfluenceId(Integer influenceId) {
		this.influenceId = influenceId;
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
	public ErpFunProcessLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProcessLog(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}