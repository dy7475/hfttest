package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunMenual extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer muId;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Byte menualType;
	/**
	 * @mbggenerated
	 */
	private String menualName;
	/**
	 * @mbggenerated
	 */
	private String menualSourse;
	/**
	 * @mbggenerated
	 */
	private String menualNo;
	/**
	 * @mbggenerated
	 */
	private String department;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	private String createTime;
	/**
	 * @mbggenerated
	 */
	private Byte encodeFlag;
	/**
	 * @mbggenerated
	 */
	private String menualContent;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getMuId() {
		return muId;
	}

	/**
	 * @mbggenerated
	 */
	public void setMuId(Integer muId) {
		this.muId = muId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getMenualType() {
		return menualType;
	}

	/**
	 * @mbggenerated
	 */
	public void setMenualType(Byte menualType) {
		this.menualType = menualType;
	}

	/**
	 * @mbggenerated
	 */
	public String getMenualName() {
		return menualName;
	}

	/**
	 * @mbggenerated
	 */
	public void setMenualName(String menualName) {
		this.menualName = menualName == null ? null : menualName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMenualSourse() {
		return menualSourse;
	}

	/**
	 * @mbggenerated
	 */
	public void setMenualSourse(String menualSourse) {
		this.menualSourse = menualSourse == null ? null : menualSourse.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMenualNo() {
		return menualNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setMenualNo(String menualNo) {
		this.menualNo = menualNo == null ? null : menualNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @mbggenerated
	 */
	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getEncodeFlag() {
		return encodeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setEncodeFlag(Byte encodeFlag) {
		this.encodeFlag = encodeFlag;
	}

	/**
	 * @mbggenerated
	 */
	public String getMenualContent() {
		return menualContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setMenualContent(String menualContent) {
		this.menualContent = menualContent == null ? null : menualContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMenual() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunMenual(Integer shardCityId, Integer muId) {
		super(shardCityId);
		this.muId = muId;
	}
}