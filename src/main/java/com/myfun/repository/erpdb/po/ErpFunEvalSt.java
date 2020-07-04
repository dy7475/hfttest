package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class ErpFunEvalSt extends ErpFunEvalStKey implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String stName;
	/**
	 * @mbggenerated
	 */
	private BigDecimal stScore;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getStName() {
		return stName;
	}

	/**
	 * @mbggenerated
	 */
	public void setStName(String stName) {
		this.stName = stName == null ? null : stName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public BigDecimal getStScore() {
		return stScore;
	}

	/**
	 * @mbggenerated
	 */
	public void setStScore(BigDecimal stScore) {
		this.stScore = stScore;
	}
}