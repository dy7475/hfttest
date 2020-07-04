package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunReceiptType extends ShardDb implements Serializable {

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
	@ApiModelProperty(value = "收费类型")
	private String receiptType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除标记 0=未删除 1=删除")
	private Byte delFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "排序")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "	创建时间")
	private Date createTime;
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
	 * @mbggenerated 收费类型
	 */
	public String getReceiptType() {
		return receiptType;
	}

	/**
	 * @mbggenerated 收费类型
	 */
	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType == null ? null : receiptType.trim();
	}

	/**
	 * @mbggenerated 删除标记 0=未删除 1=删除
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated 删除标记 0=未删除 1=删除
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
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
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunReceiptType() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunReceiptType(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}