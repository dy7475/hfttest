package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpAuditClass extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分类名称")
	private String className;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客源类型")
	private Integer caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer delUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0 没有删 1=删")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核资源，1=跟进类审核 2=请假 3=外出审核  4=权证合同类的审批  5=房基地投诉审核")
	private Byte auditResource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "-默认0 不能删除 1能删除")
	private Byte canDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0=不需要审核 1=需要审核")
	private Byte needAudit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核流程大类ID")
	private Integer auditProcessId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "共享中心ID")
	private Integer deptId;
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
	 * @mbggenerated 分类名称
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @mbggenerated 分类名称
	 */
	public void setClassName(String className) {
		this.className = className;
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
	 * @mbggenerated 修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 房客源类型
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房客源类型
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
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
	 * @mbggenerated -
	 */
	public Integer getDelUser() {
		return delUser;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDelUser(Integer delUser) {
		this.delUser = delUser;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated 0 没有删 1=删
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 0 没有删 1=删
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 审核资源，1=跟进类审核 2=请假 3=外出审核  4=权证合同类的审批  5=房基地投诉审核
	 */
	public Byte getAuditResource() {
		return auditResource;
	}

	/**
	 * @mbggenerated 审核资源，1=跟进类审核 2=请假 3=外出审核  4=权证合同类的审批  5=房基地投诉审核
	 */
	public void setAuditResource(Byte auditResource) {
		this.auditResource = auditResource;
	}

	/**
	 * @mbggenerated -默认0 不能删除 1能删除
	 */
	public Byte getCanDel() {
		return canDel;
	}

	/**
	 * @mbggenerated -默认0 不能删除 1能删除
	 */
	public void setCanDel(Byte canDel) {
		this.canDel = canDel;
	}

	/**
	 * @mbggenerated 0=不需要审核 1=需要审核
	 */
	public Byte getNeedAudit() {
		return needAudit;
	}

	/**
	 * @mbggenerated 0=不需要审核 1=需要审核
	 */
	public void setNeedAudit(Byte needAudit) {
		this.needAudit = needAudit;
	}

	/**
	 * @mbggenerated 审核流程大类ID
	 */
	public Integer getAuditProcessId() {
		return auditProcessId;
	}

	/**
	 * @mbggenerated 审核流程大类ID
	 */
	public void setAuditProcessId(Integer auditProcessId) {
		this.auditProcessId = auditProcessId;
	}

	/**
	 * @mbggenerated 共享中心ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 共享中心ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditClass() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditClass(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}