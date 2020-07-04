package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpFunMlTaskFile extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="附件ID") private Integer taskFileId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="发送任务ID") private Integer taskId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="附件名") private String fileName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="附件地址") private String fileAddr;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="附件大小") private String fileSize;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 附件ID
	 */
	public Integer getTaskFileId() {
		return taskFileId;
	}

	/**
	 * @mbggenerated 附件ID
	 */
	public void setTaskFileId(Integer taskFileId) {
		this.taskFileId = taskFileId;
	}

	/**
	 * @mbggenerated 发送任务ID
	 */
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * @mbggenerated 发送任务ID
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * @mbggenerated 附件名
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @mbggenerated 附件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @mbggenerated 附件地址
	 */
	public String getFileAddr() {
		return fileAddr;
	}

	/**
	 * @mbggenerated 附件地址
	 */
	public void setFileAddr(String fileAddr) {
		this.fileAddr = fileAddr;
	}

	/**
	 * @mbggenerated 附件大小
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * @mbggenerated 附件大小
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMlTaskFile() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMlTaskFile(Integer shardCityId, Integer taskFileId) {
		super(shardCityId);
		this.taskFileId = taskFileId;
	}
}