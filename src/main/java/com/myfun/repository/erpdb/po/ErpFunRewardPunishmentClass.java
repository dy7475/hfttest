package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class ErpFunRewardPunishmentClass extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键id
	 */
	private Integer id;
	/**
	 * @mbggenerated 类名
	 */
	private String className;
	/**
	 * @mbggenerated 排序
	 */
	private Integer classSeq;
	/**
	 * @mbggenerated 0 正常 1已删除
	 */
	private Byte isDel;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 1：奖励 2惩罚
	 */
	private Byte rewardPunishmentType;
	/**
	 * @mbggenerated 金额
	 */
	private BigDecimal amount;
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
	public String getClassName() {
		return className;
	}

	/**
	 * @mbggenerated
	 */
	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getClassSeq() {
		return classSeq;
	}

	/**
	 * @mbggenerated
	 */
	public void setClassSeq(Integer classSeq) {
		this.classSeq = classSeq;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
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
	public Byte getRewardPunishmentType() {
		return rewardPunishmentType;
	}

	/**
	 * @mbggenerated
	 */
	public void setRewardPunishmentType(Byte rewardPunishmentType) {
		this.rewardPunishmentType = rewardPunishmentType;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @mbggenerated
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRewardPunishmentClass() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRewardPunishmentClass(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}