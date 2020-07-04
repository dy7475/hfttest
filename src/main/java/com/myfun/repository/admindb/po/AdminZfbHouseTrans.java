package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminZfbHouseTrans implements Serializable {

	/**
	 * @mbggenerated 主键
	 */
	private Integer id;
	/**
	 * @mbggenerated 房源ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated 房源类型
	 */
	private Integer caseType;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date creationTime;
	/**
	 * @mbggenerated 0:待审核。1审核通过。2：处理成功 3：作废房源
	 */
	private Integer auditStatus;
	/**
	 * @mbggenerated 门店编号
	 */
	private String deptNo;
	/**
	 * @mbggenerated 公司编号
	 */
	private String compNo;
	/**
	 * @mbggenerated 用户姓名
	 */
	private String userName;
	/**
	 * @mbggenerated 用户电话
	 */
	private String userMobile;
	/**
	 * @mbggenerated 房源标题
	 */
	private String houseTitile;
	/**
	 * @mbggenerated 审核人CRM的ID
	 */
	private Integer auditorId;
	/**
	 * @mbggenerated 审核人姓名
	 */
	private Date aduitTime;
	/**
	 * @mbggenerated
	 */
	private String caseNo;
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
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
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
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * @mbggenerated
	 */
	public String getHouseTitile() {
		return houseTitile;
	}

	/**
	 * @mbggenerated
	 */
	public void setHouseTitile(String houseTitile) {
		this.houseTitile = houseTitile;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAuditorId() {
		return auditorId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuditorId(Integer auditorId) {
		this.auditorId = auditorId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getAduitTime() {
		return aduitTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setAduitTime(Date aduitTime) {
		this.aduitTime = aduitTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
}