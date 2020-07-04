package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunVoipLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer voipId;
	/**
	 * @mbggenerated
	 */
	private Integer paidId;
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
	private Byte targetType;
	/**
	 * @mbggenerated
	 */
	private Integer targetId;
	/**
	 * @mbggenerated
	 */
	private Integer targetDept;
	/**
	 * @mbggenerated
	 */
	private Byte plateType;
	/**
	 * @mbggenerated
	 */
	private Integer ownerId;
	/**
	 * @mbggenerated
	 */
	private Integer callUser;
	/**
	 * @mbggenerated
	 */
	private String callPhone;
	/**
	 * @mbggenerated
	 */
	private String calledPhone;
	/**
	 * @mbggenerated
	 */
	private String callTime;
	/**
	 * @mbggenerated
	 */
	private Integer callLength;
	/**
	 * @mbggenerated
	 */
	private BigDecimal callFee;
	/**
	 * @mbggenerated
	 */
	private String callRecord;
	/**
	 * @mbggenerated
	 */
	private Byte cutReason;
	/**
	 * @mbggenerated
	 */
	private Byte reasonDesc;
	/**
	 * @mbggenerated
	 */
	private Byte logSource;
	/**
	 * @mbggenerated
	 */
	private Byte callRecordDownload;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private String callId;
	/**
	 * @mbggenerated
	 */
	private String targetNo;
	/**
	 * @mbggenerated
	 */
	private Date startTime;
	/**
	 * @mbggenerated
	 */
	private Date stopTime;
	/**
	 * @mbggenerated
	 */
	private Integer targetUseage;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getVoipId() {
		return voipId;
	}

	/**
	 * @mbggenerated
	 */
	public void setVoipId(Integer voipId) {
		this.voipId = voipId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPaidId() {
		return paidId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaidId(Integer paidId) {
		this.paidId = paidId;
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
	public Byte getTargetType() {
		return targetType;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetId() {
		return targetId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetDept() {
		return targetDept;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetDept(Integer targetDept) {
		this.targetDept = targetDept;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPlateType() {
		return plateType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPlateType(Byte plateType) {
		this.plateType = plateType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getOwnerId() {
		return ownerId;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCallUser() {
		return callUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallUser(Integer callUser) {
		this.callUser = callUser;
	}

	/**
	 * @mbggenerated
	 */
	public String getCallPhone() {
		return callPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallPhone(String callPhone) {
		this.callPhone = callPhone == null ? null : callPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCalledPhone() {
		return calledPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setCalledPhone(String calledPhone) {
		this.calledPhone = calledPhone == null ? null : calledPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getCallTime() {
		return callTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallTime(String callTime) {
		this.callTime = callTime == null ? null : callTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCallLength() {
		return callLength;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallLength(Integer callLength) {
		this.callLength = callLength;
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getCallFee() {
		return callFee;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallFee(BigDecimal callFee) {
		this.callFee = callFee;
	}

	/**
	 * @mbggenerated
	 */
	public String getCallRecord() {
		return callRecord;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallRecord(String callRecord) {
		this.callRecord = callRecord == null ? null : callRecord.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCutReason() {
		return cutReason;
	}

	/**
	 * @mbggenerated
	 */
	public void setCutReason(Byte cutReason) {
		this.cutReason = cutReason;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getReasonDesc() {
		return reasonDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setReasonDesc(Byte reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLogSource() {
		return logSource;
	}

	/**
	 * @mbggenerated
	 */
	public void setLogSource(Byte logSource) {
		this.logSource = logSource;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCallRecordDownload() {
		return callRecordDownload;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallRecordDownload(Byte callRecordDownload) {
		this.callRecordDownload = callRecordDownload;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public String getCallId() {
		return callId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCallId(String callId) {
		this.callId = callId == null ? null : callId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTargetNo() {
		return targetNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo == null ? null : targetNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getStopTime() {
		return stopTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getTargetUseage() {
		return targetUseage;
	}

	/**
	 * @mbggenerated
	 */
	public void setTargetUseage(Integer targetUseage) {
		this.targetUseage = targetUseage;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunVoipLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunVoipLog(Integer shardCityId, Integer voipId) {
		super(shardCityId);
		this.voipId = voipId;
	}
}