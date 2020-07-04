package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.support.generator.shard.ShardDb;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunRoleWageConfig extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键自增ID") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="基本薪资") private BigDecimal baseWage;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="角色ID") private String roleId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="更新时间") private Date updateTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="管理范围") private Byte manageLevel;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建人") private Integer createUid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否考核 0不考核 1考核  和是否作废一个意思") private Byte isCheck;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="薪资月份") private String assessmentMonth;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="角色职级ID，默认为0。为0相当于没有配置职级薪资，直接使用基本配置") private Integer roleLevelId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="数据绩效") private BigDecimal dataWage;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩绩效") private BigDecimal salesWage;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 基本薪资
	 */
	public BigDecimal getBaseWage() {
		return baseWage;
	}

	/**
	 * @mbggenerated 基本薪资
	 */
	public void setBaseWage(BigDecimal baseWage) {
		this.baseWage = baseWage;
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
	 * @mbggenerated 角色ID
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
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
	 * @mbggenerated 管理范围
	 */
	public Byte getManageLevel() {
		return manageLevel;
	}

	/**
	 * @mbggenerated 管理范围
	 */
	public void setManageLevel(Byte manageLevel) {
		this.manageLevel = manageLevel;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/**
	 * @mbggenerated 是否考核 0不考核 1考核  和是否作废一个意思
	 */
	public Byte getIsCheck() {
		return isCheck;
	}

	/**
	 * @mbggenerated 是否考核 0不考核 1考核  和是否作废一个意思
	 */
	public void setIsCheck(Byte isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * @mbggenerated 薪资月份
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated 薪资月份
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}

	/**
	 * @mbggenerated 角色职级ID，默认为0。为0相当于没有配置职级薪资，直接使用基本配置
	 */
	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	/**
	 * @mbggenerated 角色职级ID，默认为0。为0相当于没有配置职级薪资，直接使用基本配置
	 */
	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	/**
	 * @mbggenerated 数据绩效
	 */
	public BigDecimal getDataWage() {
		return dataWage;
	}

	/**
	 * @mbggenerated 数据绩效
	 */
	public void setDataWage(BigDecimal dataWage) {
		this.dataWage = dataWage;
	}

	/**
	 * @mbggenerated 业绩绩效
	 */
	public BigDecimal getSalesWage() {
		return salesWage;
	}

	/**
	 * @mbggenerated 业绩绩效
	 */
	public void setSalesWage(BigDecimal salesWage) {
		this.salesWage = salesWage;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoleWageConfig() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoleWageConfig(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}