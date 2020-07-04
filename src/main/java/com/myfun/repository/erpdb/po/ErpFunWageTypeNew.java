package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class ErpFunWageTypeNew extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键ID") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="原有的提成方案id") private Integer wagetypeId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店Id") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="新增方案名称") private String wageTypeName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="编号") private Byte seq;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private String createDate;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="	薪资的计算方式 1.阶梯计算 2.通提计算") private Byte wageCountType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融") private Byte performanceType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司") private Byte royaltyRange;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩范围，0=人均 1店均 2总业绩") private Byte profitRange;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="保底比例，当前提成方式等于通提的时候") private BigDecimal baseProportion;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="提成方案说明") private String wageTypeDesc;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="提成类型 0=业务1=管理") private Byte managePlan;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="结算月  用于自然月") private String assessmentMonth;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否在用 1：再用 0 表示往月的配置") private Byte isCheck;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="角色方案配置ID(ROLE_WAGETYPE_RELATIVE表主键)") private Integer roleWagetypeRelativeId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 原有的提成方案id
	 */
	public Integer getWagetypeId() {
		return wagetypeId;
	}

	/**
	 * @mbggenerated 原有的提成方案id
	 */
	public void setWagetypeId(Integer wagetypeId) {
		this.wagetypeId = wagetypeId;
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
	 * @mbggenerated 门店Id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店Id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 新增方案名称
	 */
	public String getWageTypeName() {
		return wageTypeName;
	}

	/**
	 * @mbggenerated 新增方案名称
	 */
	public void setWageTypeName(String wageTypeName) {
		this.wageTypeName = wageTypeName == null ? null : wageTypeName.trim();
	}

	/**
	 * @mbggenerated 编号
	 */
	public Byte getSeq() {
		return seq;
	}

	/**
	 * @mbggenerated 编号
	 */
	public void setSeq(Byte seq) {
		this.seq = seq;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}

	/**
	 * @mbggenerated 薪资的计算方式 1.阶梯计算 2.通提计算
	 */
	public Byte getWageCountType() {
		return wageCountType;
	}

	/**
	 * @mbggenerated 薪资的计算方式 1.阶梯计算 2.通提计算
	 */
	public void setWageCountType(Byte wageCountType) {
		this.wageCountType = wageCountType;
	}

	/**
	 * @mbggenerated 业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
	 */
	public Byte getPerformanceType() {
		return performanceType;
	}

	/**
	 * @mbggenerated 业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
	 */
	public void setPerformanceType(Byte performanceType) {
		this.performanceType = performanceType;
	}

	/**
	 * @mbggenerated 提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司
	 */
	public Byte getRoyaltyRange() {
		return royaltyRange;
	}

	/**
	 * @mbggenerated 提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司
	 */
	public void setRoyaltyRange(Byte royaltyRange) {
		this.royaltyRange = royaltyRange;
	}

	/**
	 * @mbggenerated 业绩范围，0=人均 1店均 2总业绩
	 */
	public Byte getProfitRange() {
		return profitRange;
	}

	/**
	 * @mbggenerated 业绩范围，0=人均 1店均 2总业绩
	 */
	public void setProfitRange(Byte profitRange) {
		this.profitRange = profitRange;
	}

	/**
	 * @mbggenerated 保底比例，当前提成方式等于通提的时候
	 */
	public BigDecimal getBaseProportion() {
		return baseProportion;
	}

	/**
	 * @mbggenerated 保底比例，当前提成方式等于通提的时候
	 */
	public void setBaseProportion(BigDecimal baseProportion) {
		this.baseProportion = baseProportion;
	}

	/**
	 * @mbggenerated 提成方案说明
	 */
	public String getWageTypeDesc() {
		return wageTypeDesc;
	}

	/**
	 * @mbggenerated 提成方案说明
	 */
	public void setWageTypeDesc(String wageTypeDesc) {
		this.wageTypeDesc = wageTypeDesc == null ? null : wageTypeDesc.trim();
	}

	/**
	 * @mbggenerated 提成类型 0=业务1=管理
	 */
	public Byte getManagePlan() {
		return managePlan;
	}

	/**
	 * @mbggenerated 提成类型 0=业务1=管理
	 */
	public void setManagePlan(Byte managePlan) {
		this.managePlan = managePlan;
	}

	/**
	 * @mbggenerated 结算月  用于自然月
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated 结算月  用于自然月
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth == null ? null : assessmentMonth.trim();
	}

	/**
	 * @mbggenerated 是否在用 1：再用 0 表示往月的配置
	 */
	public Byte getIsCheck() {
		return isCheck;
	}

	/**
	 * @mbggenerated 是否在用 1：再用 0 表示往月的配置
	 */
	public void setIsCheck(Byte isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * @mbggenerated 角色方案配置ID(ROLE_WAGETYPE_RELATIVE表主键)
	 */
	public Integer getRoleWagetypeRelativeId() {
		return roleWagetypeRelativeId;
	}

	/**
	 * @mbggenerated 角色方案配置ID(ROLE_WAGETYPE_RELATIVE表主键)
	 */
	public void setRoleWagetypeRelativeId(Integer roleWagetypeRelativeId) {
		this.roleWagetypeRelativeId = roleWagetypeRelativeId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageTypeNew() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWageTypeNew(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}