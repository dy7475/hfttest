package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminBulletReplyWithBLOBs extends AdminBulletReply implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String contents;
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
	public String getContents() {
		return contents;
	}

	/**
	 * @mbggenerated
	 */
	public void setContents(String contents) {
		this.contents = contents == null ? null : contents.trim();
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