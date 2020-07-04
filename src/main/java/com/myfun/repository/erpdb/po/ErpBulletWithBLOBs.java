package com.myfun.repository.erpdb.po;

import java.io.Serializable;

public class ErpBulletWithBLOBs extends ErpBullet implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String bulletContent;
	/**
	 * @mbggenerated
	 */
	private String contentBottom;
	/**
	 * @mbggenerated
	 */
	private String zanUser;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getBulletContent() {
		return bulletContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setBulletContent(String bulletContent) {
		this.bulletContent = bulletContent == null ? null : bulletContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getContentBottom() {
		return contentBottom;
	}

	/**
	 * @mbggenerated
	 */
	public void setContentBottom(String contentBottom) {
		this.contentBottom = contentBottom == null ? null : contentBottom.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getZanUser() {
		return zanUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setZanUser(String zanUser) {
		this.zanUser = zanUser == null ? null : zanUser.trim();
	}
}