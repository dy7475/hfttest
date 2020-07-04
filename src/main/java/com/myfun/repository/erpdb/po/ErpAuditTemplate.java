package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpAuditTemplate extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客源类型")
	private Integer caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核类型，DD：TRACK_TYPE、OA_LEAVE_TYPE、OA_OUT_TYPE、DEAL_AUDIT_TYPE、COMPLAINT_TYPE")
	private Integer auditType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "超期自动审核时间，分钟")
	private Integer overdueAuditTime;
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
	@ApiModelProperty(value = "是否需要审核，0=不需要 1=要审核")
	private Byte needAudit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核资源，1=跟进类审核 2=请假 3=外出审核 4=权证合同类的审批  5=房基地投诉审核 6=通用审批")
	private Byte auditResource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分类ID")
	private Integer classId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "增加角色类型 0=房源所属方 1=钥匙存放方")
	private Byte roleType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "通审批时业务类型的名称")
	private String templateName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer auditProcessId;
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
	 * @mbggenerated 审核类型，DD：TRACK_TYPE、OA_LEAVE_TYPE、OA_OUT_TYPE、DEAL_AUDIT_TYPE、COMPLAINT_TYPE
	 */
	public Integer getAuditType() {
		return auditType;
	}

	/**
	 * @mbggenerated 审核类型，DD：TRACK_TYPE、OA_LEAVE_TYPE、OA_OUT_TYPE、DEAL_AUDIT_TYPE、COMPLAINT_TYPE
	 */
	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

	/**
	 * @mbggenerated 超期自动审核时间，分钟
	 */
	public Integer getOverdueAuditTime() {
		return overdueAuditTime;
	}

	/**
	 * @mbggenerated 超期自动审核时间，分钟
	 */
	public void setOverdueAuditTime(Integer overdueAuditTime) {
		this.overdueAuditTime = overdueAuditTime;
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
	 * @mbggenerated 是否需要审核，0=不需要 1=要审核
	 */
	public Byte getNeedAudit() {
		return needAudit;
	}

	/**
	 * @mbggenerated 是否需要审核，0=不需要 1=要审核
	 */
	public void setNeedAudit(Byte needAudit) {
		this.needAudit = needAudit;
	}

	/**
	 * @mbggenerated 审核资源，1=跟进类审核 2=请假 3=外出审核 4=权证合同类的审批  5=房基地投诉审核 6=通用审批
	 */
	public Byte getAuditResource() {
		return auditResource;
	}

	/**
	 * @mbggenerated 审核资源，1=跟进类审核 2=请假 3=外出审核 4=权证合同类的审批  5=房基地投诉审核 6=通用审批
	 */
	public void setAuditResource(Byte auditResource) {
		this.auditResource = auditResource;
	}

	/**
	 * @mbggenerated 分类ID
	 */
	public Integer getClassId() {
		return classId;
	}

	/**
	 * @mbggenerated 分类ID
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	/**
	 * @mbggenerated 增加角色类型 0=房源所属方 1=钥匙存放方
	 */
	public Byte getRoleType() {
		return roleType;
	}

	/**
	 * @mbggenerated 增加角色类型 0=房源所属方 1=钥匙存放方
	 */
	public void setRoleType(Byte roleType) {
		this.roleType = roleType;
	}

	/**
	 * @mbggenerated 通审批时业务类型的名称
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @mbggenerated 通审批时业务类型的名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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
	 * @mbggenerated
	 */
	public ErpAuditTemplate() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditTemplate(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}