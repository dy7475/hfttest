package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunRoleWageWorkcount extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键id
	 */
	@ApiModelProperty("主键id")
	private Integer id;
	/**
	 * @mbggenerated 角色模板id
	 */
	@ApiModelProperty("角色模板id")
	private Integer roleWageConfigId;
	/**
	 * @mbggenerated 公司id
	 */
	@ApiModelProperty("公司id")
	private Integer compId;
	/**
	 * @mbggenerated 考核项的名字
	 */
	@ApiModelProperty("考核项的名字")
	private String workcountDicName;
	/**
	 * @mbggenerated DD ：WAGE_CONFIG_WORKCOUNT_OPTIONS 的dic_val
	 */
	@ApiModelProperty("")
	private String workcountDicValue;
	/**
	 * @mbggenerated 创建时间
	 */
	@ApiModelProperty("创建时间")
	private Date createTime;
	/**
	 * @mbggenerated 目标量
	 */
	@ApiModelProperty("目标量")
	private Integer targetCount;
	/**
	 * @mbggenerated 单条金额
	 */
	@ApiModelProperty("单条金额")
	private BigDecimal singleAmount;
	/**
	 * @mbggenerated 上限
	 */
	@ApiModelProperty("上限")
	private BigDecimal amountLimit;
	/**
	 * @mbggenerated 1本人 2：管理
	 */
	@ApiModelProperty("1=本人 2=管理")
	private Byte checkType;
	/**
	 * @mbggenerated 考核范围 1：总量 2：均量
	 */
	@ApiModelProperty("考核范围 1=总量 2=均量")
	private Byte checkRange;
	/**
	 * @mbggenerated 0全部 1买卖 2租赁
	 */
	@ApiModelProperty("0=全部 1=买卖 2=租赁")
	private Byte checkBusiness;
	/**
	 * @mbggenerated 1：考核 0：不考核
	 */
	@ApiModelProperty("1=考核 0=不考核")
	private Byte isCheck;
	/**
	 * @mbggenerated 排序
	 */
	@ApiModelProperty("排序")
	private Integer workcountSeq;
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
	public String getWorkcountDicName() {
		return workcountDicName;
	}

	/**
	 * @mbggenerated
	 */
	public void setWorkcountDicName(String workcountDicName) {
		this.workcountDicName = workcountDicName == null ? null : workcountDicName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWorkcountDicValue() {
		return workcountDicValue;
	}

	/**
	 * @mbggenerated
	 */
	public void setWorkcountDicValue(String workcountDicValue) {
		this.workcountDicValue = workcountDicValue == null ? null : workcountDicValue.trim();
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
	public Integer getTargetCount() {
		return targetCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetCount(Integer targetCount) {
		this.targetCount = targetCount;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getSingleAmount() {
		return singleAmount;
	}

	/**
	 * @mbggenerated
	 */
	public void setSingleAmount(BigDecimal singleAmount) {
		this.singleAmount = singleAmount;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getAmountLimit() {
		return amountLimit;
	}

	/**
	 * @mbggenerated
	 */
	public void setAmountLimit(BigDecimal amountLimit) {
		this.amountLimit = amountLimit;
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
	public Integer getWorkcountSeq() {
		return workcountSeq;
	}

	/**
	 * @mbggenerated
	 */
	public void setWorkcountSeq(Integer workcountSeq) {
		this.workcountSeq = workcountSeq;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoleWageWorkcount() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunRoleWageWorkcount(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}