package com.myfun.repository.erpdb.po;

import java.io.Serializable;

public class ErpFunDealRecordWithBLOBs extends ErpFunDealRecord implements Serializable {

	/**
	 * @mbggenerated
	 */
	private String updateContent;
	/**
	 * @mbggenerated
	 */
	private String proContent;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public String getUpdateContent() {
		return updateContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent == null ? null : updateContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getProContent() {
		return proContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setProContent(String proContent) {
		this.proContent = proContent == null ? null : proContent.trim();
	}
}