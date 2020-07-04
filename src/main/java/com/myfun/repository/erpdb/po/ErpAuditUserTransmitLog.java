package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpAuditUserTransmitLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer logId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer auditId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer auditSeq;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer sourceUserid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer sourceDeptid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer acceptUserid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer acceptDeptid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String transmitContent;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String transmitPhoto;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String sourceUsername;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String sourceDeptname;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String acceptUsername;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String acceptDeptname;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Date creationTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getLogId() {
		return logId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getAuditSeq() {
		return auditSeq;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAuditSeq(Integer auditSeq) {
		this.auditSeq = auditSeq;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getSourceUserid() {
		return sourceUserid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSourceUserid(Integer sourceUserid) {
		this.sourceUserid = sourceUserid;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getSourceDeptid() {
		return sourceDeptid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSourceDeptid(Integer sourceDeptid) {
		this.sourceDeptid = sourceDeptid;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getAcceptUserid() {
		return acceptUserid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAcceptUserid(Integer acceptUserid) {
		this.acceptUserid = acceptUserid;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getAcceptDeptid() {
		return acceptDeptid;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAcceptDeptid(Integer acceptDeptid) {
		this.acceptDeptid = acceptDeptid;
	}

	/**
	 * @mbggenerated -
	 */
	public String getTransmitContent() {
		return transmitContent;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTransmitContent(String transmitContent) {
		this.transmitContent = transmitContent;
	}

	/**
	 * @mbggenerated -
	 */
	public String getTransmitPhoto() {
		return transmitPhoto;
	}

	/**
	 * @mbggenerated -
	 */
	public void setTransmitPhoto(String transmitPhoto) {
		this.transmitPhoto = transmitPhoto;
	}

	/**
	 * @mbggenerated -
	 */
	public String getSourceUsername() {
		return sourceUsername;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSourceUsername(String sourceUsername) {
		this.sourceUsername = sourceUsername;
	}

	/**
	 * @mbggenerated -
	 */
	public String getSourceDeptname() {
		return sourceDeptname;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSourceDeptname(String sourceDeptname) {
		this.sourceDeptname = sourceDeptname;
	}

	/**
	 * @mbggenerated -
	 */
	public String getAcceptUsername() {
		return acceptUsername;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAcceptUsername(String acceptUsername) {
		this.acceptUsername = acceptUsername;
	}

	/**
	 * @mbggenerated -
	 */
	public String getAcceptDeptname() {
		return acceptDeptname;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAcceptDeptname(String acceptDeptname) {
		this.acceptDeptname = acceptDeptname;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditUserTransmitLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditUserTransmitLog(Integer shardCityId, Integer logId) {
		super(shardCityId);
		this.logId = logId;
	}
}