package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunEmployeeFile extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 档案表id
	 */
	private Integer employeeDocId;
	/**
	 * @mbggenerated 档案ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 修改时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 文件类型，1=身份证 2=学历证书 3=荣誉证书 4=档案资料 5=其他资料
	 */
	private Byte fileType;
	/**
	 * @mbggenerated 文件地址
	 */
	private String fileUrl;
	/**
	 * @mbggenerated 文件状态
	 */
	private Byte fileStatus;
	/**
	 * @mbggenerated 创建人ID
	 */
	private Integer creatorUid;
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
	public Integer getEmployeeDocId() {
		return employeeDocId;
	}

	/**
	 * @mbggenerated
	 */
	public void setEmployeeDocId(Integer employeeDocId) {
		this.employeeDocId = employeeDocId;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFileType() {
		return fileType;
	}

	/**
	 * @mbggenerated
	 */
	public void setFileType(Byte fileType) {
		this.fileType = fileType;
	}

	/**
	 * @mbggenerated
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * @mbggenerated
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl == null ? null : fileUrl.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getFileStatus() {
		return fileStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setFileStatus(Byte fileStatus) {
		this.fileStatus = fileStatus;
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
	public ErpFunEmployeeFile() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEmployeeFile(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}