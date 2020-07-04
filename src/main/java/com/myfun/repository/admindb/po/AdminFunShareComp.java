package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunShareComp implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 共享圈名
	 */
	private String sname;
	/**
	 * @mbggenerated 所属公司
	 */
	private String compNo;
	/**
	 * @mbggenerated 是否有效  0=否 1=是
	 */
	private Integer flag;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 更新时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 创建人
	 */
	private Integer createUid;
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
	public String getSname() {
		return sname;
	}

	/**
	 * @mbggenerated
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @mbggenerated
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFlag() {
		return flag;
	}

	/**
	 * @mbggenerated
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}
}