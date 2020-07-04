package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunAudit extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer auditId;
	/**
	 * @mbggenerated
	 */
	private Integer dealId;
	/**
	 * @mbggenerated
	 */
	private String updateContent;
	/**
	 * @mbggenerated
	 */
	private String proContent;
	/**
	 * @mbggenerated
	 */
	private String auditDate;
	/**
	 * @mbggenerated
	 */
	private Integer auditUser;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

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
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated
	 */
	public String getUpdateContent() {
		return updateContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent == null ? null : updateContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getProContent() {
		return proContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setProContent(String proContent) {
		this.proContent = proContent == null ? null : proContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getAuditDate() {
		return auditDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate == null ? null : auditDate.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditUser() {
		return auditUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditUser(Integer auditUser) {
		this.auditUser = auditUser;
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
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAudit() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAudit(Integer shardCityId, Integer auditId) {
		super(shardCityId);
		this.auditId = auditId;
	}
}