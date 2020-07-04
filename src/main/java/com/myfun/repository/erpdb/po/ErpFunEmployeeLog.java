package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunEmployeeLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "相关档案ID")
	private Integer employeeId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "日志类型 1=入职、2=组织调动、4=角色调动、5=离职、6=调店、7=调组、8=职级调整,9 =团队变动")
	private Byte logType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建人")
	private Integer createUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之前的门店")
	private Integer beforeDept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之后的门店")
	private Integer afterDept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之前的角色")
	private String beforeRole;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之后的角色")
	private String afterRole;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "内容")
	private String content;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "被修改人的档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之前的分组")
	private Integer beforeGr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之后的分组")
	private Integer afterGr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之前的职级ID")
	private Integer beforeRoleLevelId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之后的职级ID")
	private Integer afterRoleLevelId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之前的组织机构ID")
	private Integer beforeOrganizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "之后的组织机构ID")
	private Integer afterOrganizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String createUsername;
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
	 * @mbggenerated 相关档案ID
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @mbggenerated 相关档案ID
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @mbggenerated 日志类型 1=入职、2=组织调动、4=角色调动、5=离职、6=调店、7=调组、8=职级调整,9 =团队变动
	 */
	public Byte getLogType() {
		return logType;
	}

	/**
	 * @mbggenerated 日志类型 1=入职、2=组织调动、4=角色调动、5=离职、6=调店、7=调组、8=职级调整,9 =团队变动
	 */
	public void setLogType(Byte logType) {
		this.logType = logType;
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
	 * @mbggenerated 之前的门店
	 */
	public Integer getBeforeDept() {
		return beforeDept;
	}

	/**
	 * @mbggenerated 之前的门店
	 */
	public void setBeforeDept(Integer beforeDept) {
		this.beforeDept = beforeDept;
	}

	/**
	 * @mbggenerated 之后的门店
	 */
	public Integer getAfterDept() {
		return afterDept;
	}

	/**
	 * @mbggenerated 之后的门店
	 */
	public void setAfterDept(Integer afterDept) {
		this.afterDept = afterDept;
	}

	/**
	 * @mbggenerated 之前的角色
	 */
	public String getBeforeRole() {
		return beforeRole;
	}

	/**
	 * @mbggenerated 之前的角色
	 */
	public void setBeforeRole(String beforeRole) {
		this.beforeRole = beforeRole;
	}

	/**
	 * @mbggenerated 之后的角色
	 */
	public String getAfterRole() {
		return afterRole;
	}

	/**
	 * @mbggenerated 之后的角色
	 */
	public void setAfterRole(String afterRole) {
		this.afterRole = afterRole;
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
	 * @mbggenerated 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @mbggenerated 内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @mbggenerated 被修改人的档案ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 被修改人的档案ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 之前的分组
	 */
	public Integer getBeforeGr() {
		return beforeGr;
	}

	/**
	 * @mbggenerated 之前的分组
	 */
	public void setBeforeGr(Integer beforeGr) {
		this.beforeGr = beforeGr;
	}

	/**
	 * @mbggenerated 之后的分组
	 */
	public Integer getAfterGr() {
		return afterGr;
	}

	/**
	 * @mbggenerated 之后的分组
	 */
	public void setAfterGr(Integer afterGr) {
		this.afterGr = afterGr;
	}

	/**
	 * @mbggenerated 之前的职级ID
	 */
	public Integer getBeforeRoleLevelId() {
		return beforeRoleLevelId;
	}

	/**
	 * @mbggenerated 之前的职级ID
	 */
	public void setBeforeRoleLevelId(Integer beforeRoleLevelId) {
		this.beforeRoleLevelId = beforeRoleLevelId;
	}

	/**
	 * @mbggenerated 之后的职级ID
	 */
	public Integer getAfterRoleLevelId() {
		return afterRoleLevelId;
	}

	/**
	 * @mbggenerated 之后的职级ID
	 */
	public void setAfterRoleLevelId(Integer afterRoleLevelId) {
		this.afterRoleLevelId = afterRoleLevelId;
	}

	/**
	 * @mbggenerated 之前的组织机构ID
	 */
	public Integer getBeforeOrganizationId() {
		return beforeOrganizationId;
	}

	/**
	 * @mbggenerated 之前的组织机构ID
	 */
	public void setBeforeOrganizationId(Integer beforeOrganizationId) {
		this.beforeOrganizationId = beforeOrganizationId;
	}

	/**
	 * @mbggenerated 之后的组织机构ID
	 */
	public Integer getAfterOrganizationId() {
		return afterOrganizationId;
	}

	/**
	 * @mbggenerated 之后的组织机构ID
	 */
	public void setAfterOrganizationId(Integer afterOrganizationId) {
		this.afterOrganizationId = afterOrganizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCreateUsername() {
		return createUsername;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEmployeeLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEmployeeLog(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}