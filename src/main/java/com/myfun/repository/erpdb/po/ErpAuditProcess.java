package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpAuditProcess extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分类名称")
	private String processName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客源类型")
	private Integer caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核类型")
	private Byte auditResource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0=共享中心配置 1=统一配置")
	private Byte shareFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0=没有删除 1=已删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除人")
	private Integer delUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除时间")
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "-默认0 不能删除 1能删除")
	private Byte canDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "编辑时间")
	private Date updateTime;
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
	 * @mbggenerated 分类名称
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * @mbggenerated 分类名称
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
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
	 * @mbggenerated 审核类型
	 */
	public Byte getAuditResource() {
		return auditResource;
	}

	/**
	 * @mbggenerated 审核类型
	 */
	public void setAuditResource(Byte auditResource) {
		this.auditResource = auditResource;
	}

	/**
	 * @mbggenerated 0=共享中心配置 1=统一配置
	 */
	public Byte getShareFlag() {
		return shareFlag;
	}

	/**
	 * @mbggenerated 0=共享中心配置 1=统一配置
	 */
	public void setShareFlag(Byte shareFlag) {
		this.shareFlag = shareFlag;
	}

	/**
	 * @mbggenerated 0=没有删除 1=已删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 0=没有删除 1=已删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 删除人
	 */
	public Integer getDelUser() {
		return delUser;
	}

	/**
	 * @mbggenerated 删除人
	 */
	public void setDelUser(Integer delUser) {
		this.delUser = delUser;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
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
	 * @mbggenerated 编辑时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 编辑时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditProcess() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditProcess(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}