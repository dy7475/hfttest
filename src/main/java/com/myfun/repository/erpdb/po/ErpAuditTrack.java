package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class ErpAuditTrack extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键自增ID
	 */
	@ApiModelProperty("主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated 运行时模板ID，AUDIT_RUNTIME
	 */
	
	@ApiModelProperty("模板ID，AUDIT_RUNTIME")
	private Integer auditId;
	/**
	 * @mbggenerated 跟进人用户ID
	 */
	
	@ApiModelProperty("跟进人用户ID")
	private Integer trackUserId;
	/**
	 * @mbggenerated 跟进类型，0=普通跟进 1=发起申请 2=通过 3=拒绝 4=已撤回 5=已超期
	 */
	
	@ApiModelProperty("跟进类型，0=普通跟进 1=发起申请 2=通过 3=拒绝 4=已撤回 5=已超期")
	private Byte trackType;
	/**
	 * @mbggenerated 跟进内容
	 */
	
	@ApiModelProperty("跟进内容")
	private String trackContent;
	/**
	 * @mbggenerated 创建时间
	 */
	
	@ApiModelProperty("创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	
	@ApiModelProperty("审核序列")
	private Integer auditSeq;
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
	public Integer getTrackUserId() {
		return trackUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackUserId(Integer trackUserId) {
		this.trackUserId = trackUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getTrackType() {
		return trackType;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackType(Byte trackType) {
		this.trackType = trackType;
	}

	/**
	 * @mbggenerated
	 */
	public String getTrackContent() {
		return trackContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent == null ? null : trackContent.trim();
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
	public Integer getAuditSeq() {
		return auditSeq;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditSeq(Integer auditSeq) {
		this.auditSeq = auditSeq;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditTrack() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditTrack(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}