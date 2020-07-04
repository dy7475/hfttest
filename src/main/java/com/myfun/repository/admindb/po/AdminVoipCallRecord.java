package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminVoipCallRecord implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated
	 */
	private String param;
	/**
	 * @mbggenerated
	 */
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	private String describe;
	/**
	 * @mbggenerated
	 */
	private String result;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public String getParam() {
		return param;
	}

	/**
	 * @mbggenerated
	 */
	public void setParam(String param) {
		this.param = param == null ? null : param.trim();
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
	public String getDescribe() {
		return describe;
	}

	/**
	 * @mbggenerated
	 */
	public void setDescribe(String describe) {
		this.describe = describe == null ? null : describe.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @mbggenerated
	 */
	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
	}

	@Override
	public String toString() {
		return "AdminVoipCallRecord [id=" + id + ", param=" + param + ", createTime=" + createTime + ", describe=" + describe + ", result=" + result + "]";
	}
	
}