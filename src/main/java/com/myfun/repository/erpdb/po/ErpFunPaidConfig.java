package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunPaidConfig extends ShardDb implements Serializable {
	/**
	 *
	 * @mbggenerated
	 */
	private Integer id;

	/**
	 *
	 * @mbggenerated
	公司ID
	 */
	private Integer compId;

	/**
	 *
	 * @mbggenerated
	创建时间
	 */
	private Date createTime;

	/**
	 *
	 * @mbggenerated
	修改时间
	 */
	private Date updateTime;

	/**
	 *
	 * @mbggenerated
	修改用户
	 */
	private Integer updateUid;

	/**
	 *
	 * @mbggenerated
	房增
	 */
	private Integer houseAdd;

	/**
	 *
	 * @mbggenerated
	客增
	 */
	private Integer custAdd;

	/**
	 *
	 * @mbggenerated
	房勘
	 */
	private Integer fkCount;

	/**
	 *
	 * @mbggenerated
	带看
	 */
	private Integer dkCount;

	/**
	 *
	 * @mbggenerated
	钥匙
	 */
	private Integer keyCount;

	/**
	 *
	 * @mbggenerated
	真房源
	 */
	private Integer trueHouse;

	/**
	 *
	 * @mbggenerated
	售单成交
	 */
	private Integer saleDeal;

	/**
	 *
	 * @mbggenerated
	租单成交
	 */
	private Integer rentDeal;

	/**
	 *
	 * @mbggenerated
	新盘顾问
	 */
	private Integer newHouse;

	/**
	 *
	 * @mbggenerated
	小区专家
	 */
	private Integer buildBidding;

	/**
	 *
	 * @mbggenerated
	房源置顶
	 */
	private Integer houseBidding;

	/**
	 *
	 * @mbggenerated
	执行分配规则
	 */
	private Integer isExec;

	/**
	 *
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getUpdateUid() {
		return updateUid;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setUpdateUid(Integer updateUid) {
		this.updateUid = updateUid;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getHouseAdd() {
		return houseAdd;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setHouseAdd(Integer houseAdd) {
		this.houseAdd = houseAdd;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getCustAdd() {
		return custAdd;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setCustAdd(Integer custAdd) {
		this.custAdd = custAdd;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getFkCount() {
		return fkCount;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setFkCount(Integer fkCount) {
		this.fkCount = fkCount;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getDkCount() {
		return dkCount;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setDkCount(Integer dkCount) {
		this.dkCount = dkCount;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getKeyCount() {
		return keyCount;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setKeyCount(Integer keyCount) {
		this.keyCount = keyCount;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getTrueHouse() {
		return trueHouse;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setTrueHouse(Integer trueHouse) {
		this.trueHouse = trueHouse;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getSaleDeal() {
		return saleDeal;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setSaleDeal(Integer saleDeal) {
		this.saleDeal = saleDeal;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getRentDeal() {
		return rentDeal;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setRentDeal(Integer rentDeal) {
		this.rentDeal = rentDeal;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getNewHouse() {
		return newHouse;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setNewHouse(Integer newHouse) {
		this.newHouse = newHouse;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getBuildBidding() {
		return buildBidding;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setBuildBidding(Integer buildBidding) {
		this.buildBidding = buildBidding;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getHouseBidding() {
		return houseBidding;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setHouseBidding(Integer houseBidding) {
		this.houseBidding = houseBidding;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public Integer getIsExec() {
		return isExec;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public void setIsExec(Integer isExec) {
		this.isExec = isExec;
	}

	/**
	 *
	 * @mbggenerated
	 */
	public ErpFunPaidConfig() {

	}

	/**
	 *
	 * @mbggenerated
	 */
	public ErpFunPaidConfig(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}