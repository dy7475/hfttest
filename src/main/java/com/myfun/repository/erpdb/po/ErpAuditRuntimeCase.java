package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpAuditRuntimeCase extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键自增
	 */
	private Integer id;
	/**
	 * @mbggenerated 审核记录的ID
	 */
	private Integer auditId;
	/**
	 * @mbggenerated 房客源ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated 房客源类型
	 */
	private Integer caseType;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
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
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
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
	public ErpAuditRuntimeCase() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditRuntimeCase(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}