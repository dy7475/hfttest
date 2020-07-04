package com.myfun.erpWeb.usercenter.vo;


import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "好房豆量化配置VO")
public class ErpFunPaidConfigVo implements Serializable {
	/**
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 *
	 * @mbggenerated
	公司ID
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;

	/**
	 *
	 * @mbggenerated
	创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 *
	 * @mbggenerated
	修改时间
	 */
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;

	/**
	 *
	 * @mbggenerated
	修改用户
	 */
	@ApiModelProperty(value = "修改用户")
	private Integer updateUid;

	/**
	 *
	 * @mbggenerated
	房增
	 */
	@ApiModelProperty(value = "房增")
	private Integer houseAdd;

	/**
	 *
	 * @mbggenerated
	客增
	 */
	@ApiModelProperty(value = "客增")
	private Integer custAdd;

	/**
	 *
	 * @mbggenerated
	房勘
	 */
	@ApiModelProperty(value = "房勘")
	private Integer fkCount;

	/**
	 *
	 * @mbggenerated
	带看
	 */
	@ApiModelProperty(value = "带看")
	private Integer dkCount;

	/**
	 *
	 * @mbggenerated
	钥匙
	 */
	@ApiModelProperty(value = "钥匙")
	private Integer keyCount;

	/**
	 *
	 * @mbggenerated
	真房源
	 */
	@ApiModelProperty(value = "真房源")
	private Integer trueHouse;

	/**
	 *
	 * @mbggenerated
	售单成交
	 */
	@ApiModelProperty(value = "售单成交")
	private Integer saleDeal;

	/**
	 *
	 * @mbggenerated
	租单成交
	 */
	@ApiModelProperty(value = "租单成交")
	private Integer rentDeal;

	/**
	 *
	 * @mbggenerated
	新盘顾问
	 */
	@ApiModelProperty(value = "新盘顾问")
	private Integer newHouse;

	/**
	 *
	 * @mbggenerated
	小区专家
	 */
	@ApiModelProperty(value = "小区专家")
	private Integer buildBidding;

	/**
	 *
	 * @mbggenerated
	房源置顶
	 */
	@ApiModelProperty(value = "房源置顶")
	private Integer houseBidding;

	/**
	 *
	 * @mbggenerated
	执行分配规则
	 */
	@ApiModelProperty(value = "执行分配规则")
	private Integer isExec;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUid() {
		return updateUid;
	}

	public void setUpdateUid(Integer updateUid) {
		this.updateUid = updateUid;
	}

	public Integer getHouseAdd() {
		return houseAdd;
	}

	public void setHouseAdd(Integer houseAdd) {
		this.houseAdd = houseAdd;
	}

	public Integer getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(Integer custAdd) {
		this.custAdd = custAdd;
	}

	public Integer getFkCount() {
		return fkCount;
	}

	public void setFkCount(Integer fkCount) {
		this.fkCount = fkCount;
	}

	public Integer getDkCount() {
		return dkCount;
	}

	public void setDkCount(Integer dkCount) {
		this.dkCount = dkCount;
	}

	public Integer getKeyCount() {
		return keyCount;
	}

	public void setKeyCount(Integer keyCount) {
		this.keyCount = keyCount;
	}

	public Integer getTrueHouse() {
		return trueHouse;
	}

	public void setTrueHouse(Integer trueHouse) {
		this.trueHouse = trueHouse;
	}

	public Integer getSaleDeal() {
		return saleDeal;
	}

	public void setSaleDeal(Integer saleDeal) {
		this.saleDeal = saleDeal;
	}

	public Integer getRentDeal() {
		return rentDeal;
	}

	public void setRentDeal(Integer rentDeal) {
		this.rentDeal = rentDeal;
	}

	public Integer getNewHouse() {
		return newHouse;
	}

	public void setNewHouse(Integer newHouse) {
		this.newHouse = newHouse;
	}

	public Integer getBuildBidding() {
		return buildBidding;
	}

	public void setBuildBidding(Integer buildBidding) {
		this.buildBidding = buildBidding;
	}

	public Integer getHouseBidding() {
		return houseBidding;
	}

	public void setHouseBidding(Integer houseBidding) {
		this.houseBidding = houseBidding;
	}

	public Integer getIsExec() {
		return isExec;
	}

	public void setIsExec(Integer isExec) {
		this.isExec = isExec;
	}
}

