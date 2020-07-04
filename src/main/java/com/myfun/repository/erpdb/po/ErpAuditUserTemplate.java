package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ErpAuditUserTemplate extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "模板ID")
	private Integer auditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核方类型，1=指定用户 2=申请方 3=房客源所属方 4=钥匙所在门店 5=直接上级 6=信息归属方有权限的人 7=钥匙归属方有权限的人（6、7自动配置时才用）")
	private Integer auditUserType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "指定的审核人用户ID（指定用户时才有）")
	private Integer auditUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核方角色，例：区域经理（而且管理着A门店）")
	private String auditRoleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核顺序，由小到大")
	private Integer auditSeq;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核方式，0=依次审核 1=会签 2=或签")
	private Byte examineType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "环节id")
	private Integer classId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "条件天 默认0，")
	private BigDecimal conditionDay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer auditProcessId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationDefinitionId;
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
	 * @mbggenerated 模板ID
	 */
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @mbggenerated 模板ID
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @mbggenerated 审核方类型，1=指定用户 2=申请方 3=房客源所属方 4=钥匙所在门店 5=直接上级 6=信息归属方有权限的人 7=钥匙归属方有权限的人（6、7自动配置时才用）
	 */
	public Integer getAuditUserType() {
		return auditUserType;
	}

	/**
	 * @mbggenerated 审核方类型，1=指定用户 2=申请方 3=房客源所属方 4=钥匙所在门店 5=直接上级 6=信息归属方有权限的人 7=钥匙归属方有权限的人（6、7自动配置时才用）
	 */
	public void setAuditUserType(Integer auditUserType) {
		this.auditUserType = auditUserType;
	}

	/**
	 * @mbggenerated 指定的审核人用户ID（指定用户时才有）
	 */
	public Integer getAuditUserId() {
		return auditUserId;
	}

	/**
	 * @mbggenerated 指定的审核人用户ID（指定用户时才有）
	 */
	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}

	/**
	 * @mbggenerated 审核方角色，例：区域经理（而且管理着A门店）
	 */
	public String getAuditRoleId() {
		return auditRoleId;
	}

	/**
	 * @mbggenerated 审核方角色，例：区域经理（而且管理着A门店）
	 */
	public void setAuditRoleId(String auditRoleId) {
		this.auditRoleId = auditRoleId;
	}

	/**
	 * @mbggenerated 审核顺序，由小到大
	 */
	public Integer getAuditSeq() {
		return auditSeq;
	}

	/**
	 * @mbggenerated 审核顺序，由小到大
	 */
	public void setAuditSeq(Integer auditSeq) {
		this.auditSeq = auditSeq;
	}

	/**
	 * @mbggenerated 审核方式，0=依次审核 1=会签 2=或签
	 */
	public Byte getExamineType() {
		return examineType;
	}

	/**
	 * @mbggenerated 审核方式，0=依次审核 1=会签 2=或签
	 */
	public void setExamineType(Byte examineType) {
		this.examineType = examineType;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 环节id
	 */
	public Integer getClassId() {
		return classId;
	}

	/**
	 * @mbggenerated 环节id
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	/**
	 * @mbggenerated 条件天 默认0，
	 */
	public BigDecimal getConditionDay() {
		return conditionDay;
	}

	/**
	 * @mbggenerated 条件天 默认0，
	 */
	public void setConditionDay(BigDecimal conditionDay) {
		this.conditionDay = conditionDay;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getAuditProcessId() {
		return auditProcessId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAuditProcessId(Integer auditProcessId) {
		this.auditProcessId = auditProcessId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationDefinitionId() {
		return organizationDefinitionId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationDefinitionId(Integer organizationDefinitionId) {
		this.organizationDefinitionId = organizationDefinitionId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditUserTemplate() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditUserTemplate(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}