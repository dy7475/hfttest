package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencySpreadPhoto implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer photoId;
	/**
	 * @mbggenerated
	 */
	private Integer spreadId;
	/**
	 * @mbggenerated
	 */
	private String photoAddr;
	/**
	 * @mbggenerated
	 */
	private Date creationTime;
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
	public Integer getSpreadId() {
		return spreadId;
	}

	/**
	 * @mbggenerated
	 */
	public void setSpreadId(Integer spreadId) {
		this.spreadId = spreadId;
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
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
}