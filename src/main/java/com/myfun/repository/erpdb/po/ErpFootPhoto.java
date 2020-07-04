package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFootPhoto extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer photoId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private String photoAddr;
	/**
	 * @mbggenerated
	 */
	private String smallPhoto;
	/**
	 * @mbggenerated
	 */
	private String photoName;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	private Integer footId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getPhotoId() {
		return photoId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
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
	public String getSmallPhoto() {
		return smallPhoto;
	}

	/**
	 * @mbggenerated
	 */
	public void setSmallPhoto(String smallPhoto) {
		this.smallPhoto = smallPhoto == null ? null : smallPhoto.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPhotoName() {
		return photoName;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName == null ? null : photoName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFootId() {
		return footId;
	}

	/**
	 * @mbggenerated
	 */
	public void setFootId(Integer footId) {
		this.footId = footId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFootPhoto() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFootPhoto(Integer shardCityId, Integer photoId) {
		super(shardCityId);
		this.photoId = photoId;
	}
}