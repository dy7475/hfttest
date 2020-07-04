package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunDealTaxesFather extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 分类ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 分类名称
	 */
	private String name;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 排序
	 */
	private Integer seqNo;
	/**
	 * @mbggenerated 是否已删除
	 */
	private Byte isDel;
	/**
	 * @mbggenerated 0=买方，1=卖方
	 */
	private Byte payType;
	/**
	 * @mbggenerated 能否删除
	 */
	private Byte canDel;
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
	public String getName() {
		return name;
	}

	/**
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
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
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
	public Byte getPayType() {
		return payType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCanDel() {
		return canDel;
	}

	/**
	 * @mbggenerated
	 */
	public void setCanDel(Byte canDel) {
		this.canDel = canDel;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealTaxesFather() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealTaxesFather(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}