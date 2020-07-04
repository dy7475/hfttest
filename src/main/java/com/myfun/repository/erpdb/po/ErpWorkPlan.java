package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpWorkPlan extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer wpId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer wlId;
	/**
	 * @mbggenerated
	 */
	private String wpTime;
	/**
	 * @mbggenerated
	 */
	private String wpProject;
	/**
	 * @mbggenerated
	 */
	private String wpFinally;
	/**
	 * @mbggenerated
	 */
	private Integer creatorUid;
	/**
	 * @mbggenerated
	 */
	private String creationTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getWpId() {
		return wpId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWpId(Integer wpId) {
		this.wpId = wpId;
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
	public Integer getWlId() {
		return wlId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWlId(Integer wlId) {
		this.wlId = wlId;
	}

	/**
	 * @mbggenerated
	 */
	public String getWpTime() {
		return wpTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setWpTime(String wpTime) {
		this.wpTime = wpTime == null ? null : wpTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWpProject() {
		return wpProject;
	}

	/**
	 * @mbggenerated
	 */
	public void setWpProject(String wpProject) {
		this.wpProject = wpProject == null ? null : wpProject.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWpFinally() {
		return wpFinally;
	}

	/**
	 * @mbggenerated
	 */
	public void setWpFinally(String wpFinally) {
		this.wpFinally = wpFinally == null ? null : wpFinally.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreatorUid() {
		return creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime == null ? null : creationTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpWorkPlan() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpWorkPlan(Integer shardCityId, Integer wpId) {
		super(shardCityId);
		this.wpId = wpId;
	}
}