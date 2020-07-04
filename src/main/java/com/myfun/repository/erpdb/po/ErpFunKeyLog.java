package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunKeyLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer keyLogId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer keyId;
	/**
	 * @mbggenerated
	 */
	private Byte logType;
	/**
	 * @mbggenerated
	 */
	private Integer borrowUser;
	/**
	 * @mbggenerated
	 */
	private Integer lendUser;
	/**
	 * @mbggenerated
	 */
	private String borrowTime;
	/**
	 * @mbggenerated
	 */
	private Integer returnUser;
	/**
	 * @mbggenerated
	 */
	private Integer confirmUser;
	/**
	 * @mbggenerated
	 */
	private String returnTime;
	/**
	 * @mbggenerated
	 */
	private String borrowDesc;
	/**
	 * @mbggenerated
	 */
	private String returnDesc;
	/**
	 * @mbggenerated
	 */
	private Byte approveFlag;
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
	public Integer getKeyLogId() {
		return keyLogId;
	}

	/**
	 * @mbggenerated
	 */
	public void setKeyLogId(Integer keyLogId) {
		this.keyLogId = keyLogId;
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
	public Integer getKeyId() {
		return keyId;
	}

	/**
	 * @mbggenerated
	 */
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLogType() {
		return logType;
	}

	/**
	 * @mbggenerated
	 */
	public void setLogType(Byte logType) {
		this.logType = logType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBorrowUser() {
		return borrowUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setBorrowUser(Integer borrowUser) {
		this.borrowUser = borrowUser;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getLendUser() {
		return lendUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setLendUser(Integer lendUser) {
		this.lendUser = lendUser;
	}

	/**
	 * @mbggenerated
	 */
	public String getBorrowTime() {
		return borrowTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime == null ? null : borrowTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getReturnUser() {
		return returnUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setReturnUser(Integer returnUser) {
		this.returnUser = returnUser;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getConfirmUser() {
		return confirmUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setConfirmUser(Integer confirmUser) {
		this.confirmUser = confirmUser;
	}

	/**
	 * @mbggenerated
	 */
	public String getReturnTime() {
		return returnTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime == null ? null : returnTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBorrowDesc() {
		return borrowDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setBorrowDesc(String borrowDesc) {
		this.borrowDesc = borrowDesc == null ? null : borrowDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getReturnDesc() {
		return returnDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setReturnDesc(String returnDesc) {
		this.returnDesc = returnDesc == null ? null : returnDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getApproveFlag() {
		return approveFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setApproveFlag(Byte approveFlag) {
		this.approveFlag = approveFlag;
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
	public ErpFunKeyLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunKeyLog(Integer shardCityId, Integer keyLogId) {
		super(shardCityId);
		this.keyLogId = keyLogId;
	}
}