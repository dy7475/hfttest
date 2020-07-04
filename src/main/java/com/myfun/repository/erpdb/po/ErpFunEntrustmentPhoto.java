package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunEntrustmentPhoto extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 信息ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated 信息类型
	 */
	private Byte caseType;
	/**
	 * @mbggenerated 地址
	 */
	private String photoAddr;
	/**
	 * @mbggenerated 0委托书、1附件
	 */
	private Byte photoType;
	/**
	 * @mbggenerated 上传人-erp库 USER_ID
	 */
	private Integer uploadUser;
	/**
	 * @mbggenerated 上传时间
	 */
	private String uploadDate;
	/**
	 * @mbggenerated 图片状态：0有效、1无效、默认值：0
	 */
	private Byte photoStatus;
	/**
	 * @mbggenerated 跟进ID
	 */
	private Integer trackId;
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
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public String getPhotoAddr() {
		return photoAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr == null ? null : photoAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPhotoType() {
		return photoType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoType(Byte photoType) {
		this.photoType = photoType;
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
	public String getUploadDate() {
		return uploadDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate == null ? null : uploadDate.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPhotoStatus() {
		return photoStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoStatus(Byte photoStatus) {
		this.photoStatus = photoStatus;
	}

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
	public ErpFunEntrustmentPhoto() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEntrustmentPhoto(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}