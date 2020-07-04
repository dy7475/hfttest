package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunAttendanceScopeBiz extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 本表的主键ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 考勤地点的主键ID
	 */
	private Integer attScopeId;
	/**
	 * @mbggenerated 关联选择类型的ID
	 */
	private Integer bizId;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 1：门店 2：分组 3：个体人
	 */
	private Integer chooseType;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 0未删除 1：已删除
	 */
	private Byte isDel;
	/**
	 * @mbggenerated 删除时间
	 */
	private Date delTime;
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
	public Integer getAttScopeId() {
		return attScopeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAttScopeId(Integer attScopeId) {
		this.attScopeId = attScopeId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBizId() {
		return bizId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBizId(Integer bizId) {
		this.bizId = bizId;
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
	public Integer getChooseType() {
		return chooseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setChooseType(Integer chooseType) {
		this.chooseType = chooseType;
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
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceScopeBiz() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAttendanceScopeBiz(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}