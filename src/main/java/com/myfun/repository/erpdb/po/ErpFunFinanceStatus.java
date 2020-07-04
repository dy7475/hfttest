package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunFinanceStatus extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer financStatusId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "财务状态名称")
	private String financName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "排序NO")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "能否删除")
	private Byte canDel;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getFinancStatusId() {
		return financStatusId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setFinancStatusId(Integer financStatusId) {
		this.financStatusId = financStatusId;
	}

	/**
	 * @mbggenerated 财务状态名称
	 */
	public String getFinancName() {
		return financName;
	}

	/**
	 * @mbggenerated 财务状态名称
	 */
	public void setFinancName(String financName) {
		this.financName = financName == null ? null : financName.trim();
	}

	/**
	 * @mbggenerated 排序NO
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 排序NO
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
	 * @mbggenerated 是否删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 能否删除
	 */
	public Byte getCanDel() {
		return canDel;
	}

	/**
	 * @mbggenerated 能否删除
	 */
	public void setCanDel(Byte canDel) {
		this.canDel = canDel;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunFinanceStatus() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunFinanceStatus(Integer shardCityId, Integer financStatusId) {
		super(shardCityId);
		this.financStatusId = financStatusId;
	}
}