package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunSalaryStatistical extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键自增ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司id
	 */
	private Integer compId;
	/**
	 * @mbggenerated 大区id
	 */
	private Integer areaId;
	/**
	 * @mbggenerated 片区id
	 */
	private Integer regId;
	/**
	 * @mbggenerated 门店id
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 人员id
	 */
	private Integer userId;
	/**
	 * @mbggenerated 房源新增数量
	 */
	private Integer houseAddCount;
	/**
	 * @mbggenerated 客源新增数量
	 */
	private Integer custAddCount;
	/**
	 * @mbggenerated 房勘新增数量
	 */
	private Integer fankanCount;
	/**
	 * @mbggenerated 带看新增数量
	 */
	private Integer daikanCount;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
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
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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
	public Integer getHouseAddCount() {
		return houseAddCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseAddCount(Integer houseAddCount) {
		this.houseAddCount = houseAddCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCustAddCount() {
		return custAddCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setCustAddCount(Integer custAddCount) {
		this.custAddCount = custAddCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFankanCount() {
		return fankanCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setFankanCount(Integer fankanCount) {
		this.fankanCount = fankanCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDaikanCount() {
		return daikanCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setDaikanCount(Integer daikanCount) {
		this.daikanCount = daikanCount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSalaryStatistical() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunSalaryStatistical(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}