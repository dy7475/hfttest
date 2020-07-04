package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunMlTaskTime extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="定时任务ID") private Integer taskTimeId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="关联接收任务ID") private Integer recieveTaskId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createdTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="接收人就是执行人") private Integer recieveUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer recieveArchiveId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="执行时间") private Date recieveTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 定时任务ID
	 */
	public Integer getTaskTimeId() {
		return taskTimeId;
	}

	/**
	 * @mbggenerated 定时任务ID
	 */
	public void setTaskTimeId(Integer taskTimeId) {
		this.taskTimeId = taskTimeId;
	}

	/**
	 * @mbggenerated 关联接收任务ID
	 */
	public Integer getRecieveTaskId() {
		return recieveTaskId;
	}

	/**
	 * @mbggenerated 关联接收任务ID
	 */
	public void setRecieveTaskId(Integer recieveTaskId) {
		this.recieveTaskId = recieveTaskId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @mbggenerated 接收人就是执行人
	 */
	public Integer getRecieveUserId() {
		return recieveUserId;
	}

	/**
	 * @mbggenerated 接收人就是执行人
	 */
	public void setRecieveUserId(Integer recieveUserId) {
		this.recieveUserId = recieveUserId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getRecieveArchiveId() {
		return recieveArchiveId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setRecieveArchiveId(Integer recieveArchiveId) {
		this.recieveArchiveId = recieveArchiveId;
	}

	/**
	 * @mbggenerated 执行时间
	 */
	public Date getRecieveTime() {
		return recieveTime;
	}

	/**
	 * @mbggenerated 执行时间
	 */
	public void setRecieveTime(Date recieveTime) {
		this.recieveTime = recieveTime;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMlTaskTime() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMlTaskTime(Integer shardCityId, Integer taskTimeId) {
		super(shardCityId);
		this.taskTimeId = taskTimeId;
	}
}