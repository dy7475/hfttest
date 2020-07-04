package com.myfun.repository.erpdb.po;

import java.io.Serializable;

public class ErpFunDealWithBLOBs extends ErpFunDeal implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String tradeRemarkExplain;
	/**
	 * @mbggenerated
	 */
	private String remark;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getTradeRemarkExplain() {
		return tradeRemarkExplain;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradeRemarkExplain(String tradeRemarkExplain) {
		this.tradeRemarkExplain = tradeRemarkExplain == null ? null : tradeRemarkExplain.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @mbggenerated
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}