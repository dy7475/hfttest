package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class ErpFunWageConfig extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "积分显示兑换额度")
	private BigDecimal exchangeAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "展示方式 1：积分 2金额   默认积分")
	private Byte showType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考核方式 1：签约应收  2：实收业绩 3：结算")
	private Byte performanceCalculateType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源公转私类型  1:客户首录 2：常规登记")
	private Byte customerPubPriType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源登记")
	private Byte houseAdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源楼盘资料转入")
	private Byte houseBuildInfo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源搜搜")
	private Byte houseSoso;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源公转私")
	private Byte housePubPri;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源抢转私")
	private Byte houseSharePri;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源转有效")
	private Byte houseToEffective;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源新增登记")
	private Byte customerAdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源公转私")
	private Byte customerPubPri;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源抢转私")
	private Byte customerSharePri;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源转有效")
	private Byte customerToEffective;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0正常 1:删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间  更新数据时判断是否是当月，")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "登记人")
	private Integer createUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源取消暂缓，默认=0 不勾选，1=勾选")
	private Byte houseCancelRespite;
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
	 * @mbggenerated 积分显示兑换额度
	 */
	public BigDecimal getExchangeAmount() {
		return exchangeAmount;
	}

	/**
	 * @mbggenerated 积分显示兑换额度
	 */
	public void setExchangeAmount(BigDecimal exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}

	/**
	 * @mbggenerated 展示方式 1：积分 2金额   默认积分
	 */
	public Byte getShowType() {
		return showType;
	}

	/**
	 * @mbggenerated 展示方式 1：积分 2金额   默认积分
	 */
	public void setShowType(Byte showType) {
		this.showType = showType;
	}

	/**
	 * @mbggenerated 考核方式 1：签约应收  2：实收业绩 3：结算
	 */
	public Byte getPerformanceCalculateType() {
		return performanceCalculateType;
	}

	/**
	 * @mbggenerated 考核方式 1：签约应收  2：实收业绩 3：结算
	 */
	public void setPerformanceCalculateType(Byte performanceCalculateType) {
		this.performanceCalculateType = performanceCalculateType;
	}

	/**
	 * @mbggenerated 公司
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 客源公转私类型  1:客户首录 2：常规登记
	 */
	public Byte getCustomerPubPriType() {
		return customerPubPriType;
	}

	/**
	 * @mbggenerated 客源公转私类型  1:客户首录 2：常规登记
	 */
	public void setCustomerPubPriType(Byte customerPubPriType) {
		this.customerPubPriType = customerPubPriType;
	}

	/**
	 * @mbggenerated 房源登记
	 */
	public Byte getHouseAdd() {
		return houseAdd;
	}

	/**
	 * @mbggenerated 房源登记
	 */
	public void setHouseAdd(Byte houseAdd) {
		this.houseAdd = houseAdd;
	}

	/**
	 * @mbggenerated 房源楼盘资料转入
	 */
	public Byte getHouseBuildInfo() {
		return houseBuildInfo;
	}

	/**
	 * @mbggenerated 房源楼盘资料转入
	 */
	public void setHouseBuildInfo(Byte houseBuildInfo) {
		this.houseBuildInfo = houseBuildInfo;
	}

	/**
	 * @mbggenerated 房源搜搜
	 */
	public Byte getHouseSoso() {
		return houseSoso;
	}

	/**
	 * @mbggenerated 房源搜搜
	 */
	public void setHouseSoso(Byte houseSoso) {
		this.houseSoso = houseSoso;
	}

	/**
	 * @mbggenerated 房源公转私
	 */
	public Byte getHousePubPri() {
		return housePubPri;
	}

	/**
	 * @mbggenerated 房源公转私
	 */
	public void setHousePubPri(Byte housePubPri) {
		this.housePubPri = housePubPri;
	}

	/**
	 * @mbggenerated 房源抢转私
	 */
	public Byte getHouseSharePri() {
		return houseSharePri;
	}

	/**
	 * @mbggenerated 房源抢转私
	 */
	public void setHouseSharePri(Byte houseSharePri) {
		this.houseSharePri = houseSharePri;
	}

	/**
	 * @mbggenerated 房源转有效
	 */
	public Byte getHouseToEffective() {
		return houseToEffective;
	}

	/**
	 * @mbggenerated 房源转有效
	 */
	public void setHouseToEffective(Byte houseToEffective) {
		this.houseToEffective = houseToEffective;
	}

	/**
	 * @mbggenerated 客源新增登记
	 */
	public Byte getCustomerAdd() {
		return customerAdd;
	}

	/**
	 * @mbggenerated 客源新增登记
	 */
	public void setCustomerAdd(Byte customerAdd) {
		this.customerAdd = customerAdd;
	}

	/**
	 * @mbggenerated 客源公转私
	 */
	public Byte getCustomerPubPri() {
		return customerPubPri;
	}

	/**
	 * @mbggenerated 客源公转私
	 */
	public void setCustomerPubPri(Byte customerPubPri) {
		this.customerPubPri = customerPubPri;
	}

	/**
	 * @mbggenerated 客源抢转私
	 */
	public Byte getCustomerSharePri() {
		return customerSharePri;
	}

	/**
	 * @mbggenerated 客源抢转私
	 */
	public void setCustomerSharePri(Byte customerSharePri) {
		this.customerSharePri = customerSharePri;
	}

	/**
	 * @mbggenerated 客源转有效
	 */
	public Byte getCustomerToEffective() {
		return customerToEffective;
	}

	/**
	 * @mbggenerated 客源转有效
	 */
	public void setCustomerToEffective(Byte customerToEffective) {
		this.customerToEffective = customerToEffective;
	}

	/**
	 * @mbggenerated 0正常 1:删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 0正常 1:删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 更新时间  更新数据时判断是否是当月，
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间  更新数据时判断是否是当月，
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 登记人
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated 登记人
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
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
	 * @mbggenerated 房源取消暂缓，默认=0 不勾选，1=勾选
	 */
	public Byte getHouseCancelRespite() {
		return houseCancelRespite;
	}

	/**
	 * @mbggenerated 房源取消暂缓，默认=0 不勾选，1=勾选
	 */
	public void setHouseCancelRespite(Byte houseCancelRespite) {
		this.houseCancelRespite = houseCancelRespite;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageConfig() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageConfig(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}