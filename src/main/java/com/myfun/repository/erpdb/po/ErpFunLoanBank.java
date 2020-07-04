package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunLoanBank extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "银行名称")
	private String bankName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "状态 1:正常  0:删除")
	private Byte bankStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "排序")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "系统模板")
	private Byte systemSet;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 银行名称
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @mbggenerated 银行名称
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName == null ? null : bankName.trim();
	}

	/**
	 * @mbggenerated 状态 1:正常  0:删除
	 */
	public Byte getBankStatus() {
		return bankStatus;
	}

	/**
	 * @mbggenerated 状态 1:正常  0:删除
	 */
	public void setBankStatus(Byte bankStatus) {
		this.bankStatus = bankStatus;
	}

	/**
	 * @mbggenerated 排序
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 排序
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 系统模板
	 */
	public Byte getSystemSet() {
		return systemSet;
	}

	/**
	 * @mbggenerated 系统模板
	 */
	public void setSystemSet(Byte systemSet) {
		this.systemSet = systemSet;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunLoanBank() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunLoanBank(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}