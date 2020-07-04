package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunEarbestMoneyrecord extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司id
	 */
	private Integer compId;
	/**
	 * @mbggenerated 诚意金id
	 */
	private Integer earbestId;
	/**
	 * @mbggenerated 日志创建人
	 */
	private Integer createUser;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 跟进内容
	 */
	private String logContent;
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
	public Integer getEarbestId() {
		return earbestId;
	}

	/**
	 * @mbggenerated
	 */
	public void setEarbestId(Integer earbestId) {
		this.earbestId = earbestId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUser() {
		return createUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
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
	public String getLogContent() {
		return logContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setLogContent(String logContent) {
		this.logContent = logContent == null ? null : logContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEarbestMoneyrecord() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEarbestMoneyrecord(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}