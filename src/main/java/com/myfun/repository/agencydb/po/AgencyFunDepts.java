package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyFunDepts extends AgencyFunDeptsKey implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer devloperId;
	/**
	 * @mbggenerated
	 */
	private Short bCityId;
	/**
	 * @mbggenerated
	 */
	private Integer buildId;
	/**
	 * @mbggenerated
	 */
	private Short seqNo;
	/**
	 * @mbggenerated
	 */
	private String deptName;
	/**
	 * @mbggenerated
	 */
	private String deptCode;
	/**
	 * @mbggenerated
	 */
	private String deptTele;
	/**
	 * @mbggenerated
	 */
	private String deptContact;
	/**
	 * @mbggenerated
	 */
	private String contactTele;
	/**
	 * @mbggenerated
	 */
	private Boolean isSaleDept;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getDevloperId() {
		return devloperId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDevloperId(Integer devloperId) {
		this.devloperId = devloperId;
	}

	/**
	 * @mbggenerated
	 */
	public Short getbCityId() {
		return bCityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setbCityId(Short bCityId) {
		this.bCityId = bCityId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public Short getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeqNo(Short seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode == null ? null : deptCode.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptTele() {
		return deptTele;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptTele(String deptTele) {
		this.deptTele = deptTele == null ? null : deptTele.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptContact() {
		return deptContact;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptContact(String deptContact) {
		this.deptContact = deptContact == null ? null : deptContact.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getContactTele() {
		return contactTele;
	}

	/**
	 * @mbggenerated
	 */
	public void setContactTele(String contactTele) {
		this.contactTele = contactTele == null ? null : contactTele.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsSaleDept() {
		return isSaleDept;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsSaleDept(Boolean isSaleDept) {
		this.isSaleDept = isSaleDept;
	}
}