package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpBuildLog extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键自增（楼盘跟进日志记录表）") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进时间") private Date trackTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进内容") private String trackConten;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="操作人") private String updateUser;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="操作人ID") private Integer updateUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date creationTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘Id") private Integer buildId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司Id") private Integer compId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增（楼盘跟进日志记录表）
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增（楼盘跟进日志记录表）
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 跟进时间
	 */
	public Date getTrackTime() {
		return trackTime;
	}

	/**
	 * @mbggenerated 跟进时间
	 */
	public void setTrackTime(Date trackTime) {
		this.trackTime = trackTime;
	}

	/**
	 * @mbggenerated 跟进内容
	 */
	public String getTrackConten() {
		return trackConten;
	}

	/**
	 * @mbggenerated 跟进内容
	 */
	public void setTrackConten(String trackConten) {
		this.trackConten = trackConten == null ? null : trackConten.trim();
	}

	/**
	 * @mbggenerated 操作人
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @mbggenerated 操作人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	/**
	 * @mbggenerated 操作人ID
	 */
	public Integer getUpdateUserId() {
		return updateUserId;
	}

	/**
	 * @mbggenerated 操作人ID
	 */
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 楼盘Id
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘Id
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated 公司Id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司Id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildLog() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpBuildLog(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}