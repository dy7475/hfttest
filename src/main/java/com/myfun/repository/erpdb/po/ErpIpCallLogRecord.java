package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpIpCallLogRecord extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer recordId;
	/**
	 * @mbggenerated 拨号类型
	 */
	private Integer caseType;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 大区ID
	 */
	private Integer caseAreaId;
	/**
	 * @mbggenerated 数据所属的片区ID
	 */
	private Integer caseRegId;
	/**
	 * @mbggenerated 数据所属的门店ID
	 */
	private Integer caseDeptId;
	/**
	 * @mbggenerated 数据所属的分组ID
	 */
	private Integer caseGrId;
	/**
	 * @mbggenerated 数据所属的用户ID
	 */
	private Integer caseUserId;
	/**
	 * @mbggenerated 用户ID
	 */
	private Integer callUserId;
	/**
	 * @mbggenerated 拨打次数-一天一条
	 */
	private Integer callCount;
	/**
	 * @mbggenerated 创建日期
	 */
	private Date createDate;
	/**
	 * @mbggenerated 房源ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated merge into 的条件组合
	 */
	private String mergeKey;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getRecordId() {
		return recordId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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
	public Integer getCaseAreaId() {
		return caseAreaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseAreaId(Integer caseAreaId) {
		this.caseAreaId = caseAreaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseRegId() {
		return caseRegId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseRegId(Integer caseRegId) {
		this.caseRegId = caseRegId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseDeptId() {
		return caseDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseDeptId(Integer caseDeptId) {
		this.caseDeptId = caseDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseGrId() {
		return caseGrId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseGrId(Integer caseGrId) {
		this.caseGrId = caseGrId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseUserId() {
		return caseUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseUserId(Integer caseUserId) {
		this.caseUserId = caseUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCallUserId() {
		return callUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallUserId(Integer callUserId) {
		this.callUserId = callUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCallCount() {
		return callCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallCount(Integer callCount) {
		this.callCount = callCount;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public String getMergeKey() {
		return mergeKey;
	}

	/**
	 * @mbggenerated
	 */
	public void setMergeKey(String mergeKey) {
		this.mergeKey = mergeKey == null ? null : mergeKey.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpIpCallLogRecord() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpIpCallLogRecord(Integer shardCityId, Integer recordId) {
		super(shardCityId);
		this.recordId = recordId;
	}
}