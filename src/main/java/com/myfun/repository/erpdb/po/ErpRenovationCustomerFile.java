package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpRenovationCustomerFile extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 文件类型 1=客户资料 2=其他资料
	 */
	private Integer fileType;
	/**
	 * @mbggenerated 文件地址
	 */
	private String fileAddr;
	/**
	 * @mbggenerated 客户主键ID
	 */
	private Integer renovationCustomerId;
	/**
	 * @mbggenerated 上传人
	 */
	private Integer uploadUser;
	/**
	 * @mbggenerated 上传时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 删除标记
	 */
	private Integer isDel;
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
	public Integer getFileType() {
		return fileType;
	}

	/**
	 * @mbggenerated
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

	/**
	 * @mbggenerated
	 */
	public String getFileAddr() {
		return fileAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setFileAddr(String fileAddr) {
		this.fileAddr = fileAddr == null ? null : fileAddr.trim();
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
	public Integer getUploadUser() {
		return uploadUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setUploadUser(Integer uploadUser) {
		this.uploadUser = uploadUser;
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
	public Integer getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated
	 */
	public ErpRenovationCustomerFile() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpRenovationCustomerFile(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}