package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunContractCategory extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分类ID")
	private Integer categoryId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分类名称")
	private String categoryName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "排序")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否已删除 1:删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "签约类型 0=线下 1=线上 2=均可")
	private Byte signType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 分类ID
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @mbggenerated 分类ID
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @mbggenerated 分类名称
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @mbggenerated 分类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	 * @mbggenerated 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 是否已删除 1:删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否已删除 1:删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 签约类型 0=线下 1=线上 2=均可
	 */
	public Byte getSignType() {
		return signType;
	}

	/**
	 * @mbggenerated 签约类型 0=线下 1=线上 2=均可
	 */
	public void setSignType(Byte signType) {
		this.signType = signType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractCategory() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractCategory(Integer shardCityId, Integer categoryId) {
		super(shardCityId);
		this.categoryId = categoryId;
	}
}