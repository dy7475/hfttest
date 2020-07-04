package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminSolrCoreScannerStatus implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private String coreName;
	/**
	 * @mbggenerated
	 */
	private String threadClass;
	/**
	 * @mbggenerated
	 */
	private String dbName;
	/**
	 * @mbggenerated
	 */
	private String tbName;
	/**
	 * @mbggenerated
	 */
	private Integer queueSize;
	/**
	 * @mbggenerated
	 */
	private String extField;
	/**
	 * @mbggenerated
	 */
	private Integer syncCount;
	/**
	 * @mbggenerated
	 */
	private Date lastSyncTime;
	/**
	 * @mbggenerated
	 */
	private Byte status;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
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
	public String getCoreName() {
		return coreName;
	}

	/**
	 * @mbggenerated
	 */
	public void setCoreName(String coreName) {
		this.coreName = coreName == null ? null : coreName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getThreadClass() {
		return threadClass;
	}

	/**
	 * @mbggenerated
	 */
	public void setThreadClass(String threadClass) {
		this.threadClass = threadClass == null ? null : threadClass.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @mbggenerated
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName == null ? null : dbName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTbName() {
		return tbName;
	}

	/**
	 * @mbggenerated
	 */
	public void setTbName(String tbName) {
		this.tbName = tbName == null ? null : tbName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getQueueSize() {
		return queueSize;
	}

	/**
	 * @mbggenerated
	 */
	public void setQueueSize(Integer queueSize) {
		this.queueSize = queueSize;
	}

	/**
	 * @mbggenerated
	 */
	public String getExtField() {
		return extField;
	}

	/**
	 * @mbggenerated
	 */
	public void setExtField(String extField) {
		this.extField = extField == null ? null : extField.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSyncCount() {
		return syncCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncCount(Integer syncCount) {
		this.syncCount = syncCount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getLastSyncTime() {
		return lastSyncTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setLastSyncTime(Date lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
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
}