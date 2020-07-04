package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpAuditUserRuntime extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键自增ID") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="运行时模板ID，AUDIT_RUNTIME") private Integer auditId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="指定的审核人用户ID") private Integer auditUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核顺序，由小到大") private Integer auditSeq;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核方式，0=依次审核 1=会签 2=或签") private Byte examineType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date creationTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核状态，0=初始 1=待我审核 2=审核通过 3=或签自动通过 4=超期自动通过 5=未通过 6撤销") private Byte auditStatus;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核时间") private Date auditTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核方类型，1=指定用户 2=申请方 3=信息所属方 4=钥匙所在门店 5=直接上级 6=信息所属方有权限的人 7=钥匙所在门店有权限的人（6、7自动配置时才用）") private Integer auditUserType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核方角色，例：区域经理（而且管理着A门店）") private String auditRoleId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核时写的跟进内容") private String trackContent;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核来源，0=erp端 1=手机端") private Byte auditSource;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店ID") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="1=自动审核") private Byte isAudit;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房源投诉类型时,选择的处理方案 0=撤销房堪 1=撤销钥匙 2=撤销委托 0,1,2表示三个都撤销") private String houseComplaintDealType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer organizationDefinitionId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte transmitFlag;
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
	 * @mbggenerated 运行时模板ID，AUDIT_RUNTIME
	 */
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @mbggenerated 运行时模板ID，AUDIT_RUNTIME
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @mbggenerated 指定的审核人用户ID
	 */
	public Integer getAuditUserId() {
		return auditUserId;
	}

	/**
	 * @mbggenerated 指定的审核人用户ID
	 */
	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
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
	 * @mbggenerated 审核状态，0=初始 1=待我审核 2=审核通过 3=或签自动通过 4=超期自动通过 5=未通过 6撤销
	 */
	public Byte getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated 审核状态，0=初始 1=待我审核 2=审核通过 3=或签自动通过 4=超期自动通过 5=未通过 6撤销
	 */
	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public Date getAuditTime() {
		return auditTime;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @mbggenerated 审核方类型，1=指定用户 2=申请方 3=信息所属方 4=钥匙所在门店 5=直接上级 6=信息所属方有权限的人 7=钥匙所在门店有权限的人（6、7自动配置时才用）
	 */
	public Integer getAuditUserType() {
		return auditUserType;
	}

	/**
	 * @mbggenerated 审核方类型，1=指定用户 2=申请方 3=信息所属方 4=钥匙所在门店 5=直接上级 6=信息所属方有权限的人 7=钥匙所在门店有权限的人（6、7自动配置时才用）
	 */
	public void setAuditUserType(Integer auditUserType) {
		this.auditUserType = auditUserType;
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
	 * @mbggenerated 审核时写的跟进内容
	 */
	public String getTrackContent() {
		return trackContent;
	}

	/**
	 * @mbggenerated 审核时写的跟进内容
	 */
	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}

	/**
	 * @mbggenerated 审核来源，0=erp端 1=手机端
	 */
	public Byte getAuditSource() {
		return auditSource;
	}

	/**
	 * @mbggenerated 审核来源，0=erp端 1=手机端
	 */
	public void setAuditSource(Byte auditSource) {
		this.auditSource = auditSource;
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
	 * @mbggenerated 门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 1=自动审核
	 */
	public Byte getIsAudit() {
		return isAudit;
	}

	/**
	 * @mbggenerated 1=自动审核
	 */
	public void setIsAudit(Byte isAudit) {
		this.isAudit = isAudit;
	}

	/**
	 * @mbggenerated 房源投诉类型时,选择的处理方案 0=撤销房堪 1=撤销钥匙 2=撤销委托 0,1,2表示三个都撤销
	 */
	public String getHouseComplaintDealType() {
		return houseComplaintDealType;
	}

	/**
	 * @mbggenerated 房源投诉类型时,选择的处理方案 0=撤销房堪 1=撤销钥匙 2=撤销委托 0,1,2表示三个都撤销
	 */
	public void setHouseComplaintDealType(String houseComplaintDealType) {
		this.houseComplaintDealType = houseComplaintDealType;
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
	 * @mbggenerated -
	 */
	public Byte getTransmitFlag() {
		return transmitFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTransmitFlag(Byte transmitFlag) {
		this.transmitFlag = transmitFlag;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditUserRuntime() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditUserRuntime(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}