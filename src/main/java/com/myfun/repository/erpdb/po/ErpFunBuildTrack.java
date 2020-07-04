package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunBuildTrack extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer buildRuleId;
	/**
	 * @mbggenerated
	 */
	private String trackContent;
	/**
	 * @mbggenerated
	 */
	private String trackTime;
	/**
	 * @mbggenerated
	 */
	private Integer createUid;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
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
	public Integer getBuildRuleId() {
		return buildRuleId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildRuleId(Integer buildRuleId) {
		this.buildRuleId = buildRuleId;
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
	public String getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackTime(String trackTime) {
		this.trackTime = trackTime == null ? null : trackTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuildTrack() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunBuildTrack(Integer shardCityId, Integer trackId) {
		super(shardCityId);
		this.trackId = trackId;
	}
}