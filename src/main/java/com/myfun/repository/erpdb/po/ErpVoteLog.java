package com.myfun.repository.erpdb.po;

import java.io.Serializable;

public class ErpVoteLog extends ErpVoteLogKey implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer bulletId;
	/**
	 * @mbggenerated
	 */
	private Integer voteId;
	/**
	 * @mbggenerated
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getBulletId() {
		return bulletId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBulletId(Integer bulletId) {
		this.bulletId = bulletId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getVoteId() {
		return voteId;
	}

	/**
	 * @mbggenerated
	 */
	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
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
}