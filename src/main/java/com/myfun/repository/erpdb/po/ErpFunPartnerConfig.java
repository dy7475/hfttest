package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunPartnerConfig extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "id")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源数据是否分开管控")
	private Byte houseDataApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源数据是否分开管控")
	private Byte custDataApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "交易数据是否分开管控")
	private Byte businessDataApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "自行管理组织架构")
	private Byte organizationApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同信息自行配置（合同签约主体、合同模板等）")
	private Byte dealApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "薪资管理自行配置（绩效奖罚、提成配置）")
	private Byte wageApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "考勤管理自行配置")
	private Byte attendanceApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "隐号拨打自行配置")
	private Byte implicitCallApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "转盘规则自行配置")
	private Byte transPlateRuleApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公盘抢盘规则自行配置")
	private Byte plateRangeApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "核心信息查看条数自行配置")
	private Byte coreInfoApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "策略参数自行配置")
	private Byte strategyParamApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同相关自行配置")
	private Byte dealConfigApart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除标记")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "当前月份")
	private Date currentMonth;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 房源数据是否分开管控
	 */
	public Byte getHouseDataApart() {
		return houseDataApart;
	}

	/**
	 * @mbggenerated 房源数据是否分开管控
	 */
	public void setHouseDataApart(Byte houseDataApart) {
		this.houseDataApart = houseDataApart;
	}

	/**
	 * @mbggenerated 客源数据是否分开管控
	 */
	public Byte getCustDataApart() {
		return custDataApart;
	}

	/**
	 * @mbggenerated 客源数据是否分开管控
	 */
	public void setCustDataApart(Byte custDataApart) {
		this.custDataApart = custDataApart;
	}

	/**
	 * @mbggenerated 交易数据是否分开管控
	 */
	public Byte getBusinessDataApart() {
		return businessDataApart;
	}

	/**
	 * @mbggenerated 交易数据是否分开管控
	 */
	public void setBusinessDataApart(Byte businessDataApart) {
		this.businessDataApart = businessDataApart;
	}

	/**
	 * @mbggenerated 自行管理组织架构
	 */
	public Byte getOrganizationApart() {
		return organizationApart;
	}

	/**
	 * @mbggenerated 自行管理组织架构
	 */
	public void setOrganizationApart(Byte organizationApart) {
		this.organizationApart = organizationApart;
	}

	/**
	 * @mbggenerated 合同信息自行配置（合同签约主体、合同模板等）
	 */
	public Byte getDealApart() {
		return dealApart;
	}

	/**
	 * @mbggenerated 合同信息自行配置（合同签约主体、合同模板等）
	 */
	public void setDealApart(Byte dealApart) {
		this.dealApart = dealApart;
	}

	/**
	 * @mbggenerated 薪资管理自行配置（绩效奖罚、提成配置）
	 */
	public Byte getWageApart() {
		return wageApart;
	}

	/**
	 * @mbggenerated 薪资管理自行配置（绩效奖罚、提成配置）
	 */
	public void setWageApart(Byte wageApart) {
		this.wageApart = wageApart;
	}

	/**
	 * @mbggenerated 考勤管理自行配置
	 */
	public Byte getAttendanceApart() {
		return attendanceApart;
	}

	/**
	 * @mbggenerated 考勤管理自行配置
	 */
	public void setAttendanceApart(Byte attendanceApart) {
		this.attendanceApart = attendanceApart;
	}

	/**
	 * @mbggenerated 隐号拨打自行配置
	 */
	public Byte getImplicitCallApart() {
		return implicitCallApart;
	}

	/**
	 * @mbggenerated 隐号拨打自行配置
	 */
	public void setImplicitCallApart(Byte implicitCallApart) {
		this.implicitCallApart = implicitCallApart;
	}

	/**
	 * @mbggenerated 转盘规则自行配置
	 */
	public Byte getTransPlateRuleApart() {
		return transPlateRuleApart;
	}

	/**
	 * @mbggenerated 转盘规则自行配置
	 */
	public void setTransPlateRuleApart(Byte transPlateRuleApart) {
		this.transPlateRuleApart = transPlateRuleApart;
	}

	/**
	 * @mbggenerated 公盘抢盘规则自行配置
	 */
	public Byte getPlateRangeApart() {
		return plateRangeApart;
	}

	/**
	 * @mbggenerated 公盘抢盘规则自行配置
	 */
	public void setPlateRangeApart(Byte plateRangeApart) {
		this.plateRangeApart = plateRangeApart;
	}

	/**
	 * @mbggenerated 核心信息查看条数自行配置
	 */
	public Byte getCoreInfoApart() {
		return coreInfoApart;
	}

	/**
	 * @mbggenerated 核心信息查看条数自行配置
	 */
	public void setCoreInfoApart(Byte coreInfoApart) {
		this.coreInfoApart = coreInfoApart;
	}

	/**
	 * @mbggenerated 策略参数自行配置
	 */
	public Byte getStrategyParamApart() {
		return strategyParamApart;
	}

	/**
	 * @mbggenerated 策略参数自行配置
	 */
	public void setStrategyParamApart(Byte strategyParamApart) {
		this.strategyParamApart = strategyParamApart;
	}

	/**
	 * @mbggenerated 合同相关自行配置
	 */
	public Byte getDealConfigApart() {
		return dealConfigApart;
	}

	/**
	 * @mbggenerated 合同相关自行配置
	 */
	public void setDealConfigApart(Byte dealConfigApart) {
		this.dealConfigApart = dealConfigApart;
	}

	/**
	 * @mbggenerated 删除标记
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 删除标记
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 当前月份
	 */
	public Date getCurrentMonth() {
		return currentMonth;
	}

	/**
	 * @mbggenerated 当前月份
	 */
	public void setCurrentMonth(Date currentMonth) {
		this.currentMonth = currentMonth;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPartnerConfig() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPartnerConfig(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}