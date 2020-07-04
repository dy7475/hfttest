package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpRenovationCustomerTrack extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated userID
	 */
	private Integer userId;
	/**
	 * @mbggenerated archiveId
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 跟进类型，0=普通跟进 1=带访 2=有效 3=暂缓 4=无效 5=已装修
	 */
	private Byte trackType;
	/**
	 * @mbggenerated 跟进内容
	 */
	private String trackContent;
	/**
	 * @mbggenerated 跟进时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 装修客户主键ID
	 */
	private Integer renovationCustomerId;
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
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Integer getRenovationCustomerId() {
		return renovationCustomerId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRenovationCustomerId(Integer renovationCustomerId) {
		this.renovationCustomerId = renovationCustomerId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpRenovationCustomerTrack() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpRenovationCustomerTrack(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}