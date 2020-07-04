package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdminBankDetailInfo implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "行号")
	private String bankCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "地址号")
	private String drecCode;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "银行全称")
	private String bankDetailName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 行号
	 */
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * @mbggenerated 行号
	 */
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @mbggenerated 地址号
	 */
	public String getDrecCode() {
		return drecCode;
	}

	/**
	 * @mbggenerated 地址号
	 */
	public void setDrecCode(String drecCode) {
		this.drecCode = drecCode;
	}

	/**
	 * @mbggenerated 银行全称
	 */
	public String getBankDetailName() {
		return bankDetailName;
	}

	/**
	 * @mbggenerated 银行全称
	 */
	public void setBankDetailName(String bankDetailName) {
		this.bankDetailName = bankDetailName;
	}
}