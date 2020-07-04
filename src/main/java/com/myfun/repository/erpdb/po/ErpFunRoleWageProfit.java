package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunRoleWageProfit extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	@ApiModelProperty("主键")
	private Integer id;
	/**
	 * @mbggenerated 角色考核方案模板ID
	 */
	@ApiModelProperty("角色考核方案模板ID")
	private Integer roleWageConfigId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty("公司ID")
	private Integer compId;
	/**
	 * @mbggenerated 业绩1
	 */
	@ApiModelProperty("业绩1")
	private BigDecimal quotaStart;
	/**
	 * @mbggenerated 业绩2
	 */
	@ApiModelProperty("业绩2")
	private BigDecimal quotaEnd;
	/**
	 * @mbggenerated 金额
	 */
	@ApiModelProperty("金额")
	private BigDecimal quotaAmount;
	/**
	 * @mbggenerated 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;
	/**
	 * @mbggenerated 1本人 2：管理
	 */
	@ApiModelProperty("1=本人 2=管理")
	private Byte checkType;
	/**
	 * @mbggenerated 1：人均 2总量
	 */
	@ApiModelProperty("1=人均 2=总量")
	private Byte checkRange;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty("考核业务 0=全部 1=买卖 2=租赁")
	private Byte checkBusiness;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty("业绩排序")
	private Integer profitSeq;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty("是否考核 1=考核 0=不考核")
	private Byte isCheck;
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
	public Integer getRoleWageConfigId() {
		return roleWageConfigId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoleWageConfigId(Integer roleWageConfigId) {
		this.roleWageConfigId = roleWageConfigId;
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
	public BigDecimal getQuotaStart() {
		return quotaStart;
	}

	/**
	 * @mbggenerated
	 */
	public void setQuotaStart(BigDecimal quotaStart) {
		this.quotaStart = quotaStart;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getQuotaEnd() {
		return quotaEnd;
	}

	/**
	 * @mbggenerated
	 */
	public void setQuotaEnd(BigDecimal quotaEnd) {
		this.quotaEnd = quotaEnd;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getQuotaAmount() {
		return quotaAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setQuotaAmount(BigDecimal quotaAmount) {
		this.quotaAmount = quotaAmount;
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
	public Byte getCheckType() {
		return checkType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckType(Byte checkType) {
		this.checkType = checkType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCheckRange() {
		return checkRange;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckRange(Byte checkRange) {
		this.checkRange = checkRange;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCheckBusiness() {
		return checkBusiness;
	}

	/**
	 * @mbggenerated
	 */
	public void setCheckBusiness(Byte checkBusiness) {
		this.checkBusiness = checkBusiness;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getProfitSeq() {
		return profitSeq;
	}

	/**
	 * @mbggenerated
	 */
	public void setProfitSeq(Integer profitSeq) {
		this.profitSeq = profitSeq;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsCheck() {
		return isCheck;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsCheck(Byte isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoleWageProfit() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoleWageProfit(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}