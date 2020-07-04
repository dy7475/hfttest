package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class ErpFunGenerationPaymentClass extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 类别名
	 */
	private String className;
	/**
	 * @mbggenerated 排序
	 */
	private Integer classSeq;
	/**
	 * @mbggenerated 是否删除 1：已删除 0 未删除
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
	 * @mbggenerated 个人承担
	 */
	private BigDecimal personAmount;
	/**
	 * @mbggenerated 公司承担
	 */
	private BigDecimal compAmount;
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
	public BigDecimal getPersonAmount() {
		return personAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setPersonAmount(BigDecimal personAmount) {
		this.personAmount = personAmount;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCompAmount() {
		return compAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompAmount(BigDecimal compAmount) {
		this.compAmount = compAmount;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunGenerationPaymentClass() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunGenerationPaymentClass(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}