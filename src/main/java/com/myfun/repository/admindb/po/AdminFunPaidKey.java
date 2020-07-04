package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunPaidKey implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer paidId;
	/**
	 * @mbggenerated 资金账户ID
	 */
	private Integer uaId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getPaidId() {
		return paidId;
	}

	/**
	 * @mbggenerated
	 */
	public void setPaidId(Integer paidId) {
		this.paidId = paidId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUaId() {
		return uaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUaId(Integer uaId) {
		this.uaId = uaId;
	}
}