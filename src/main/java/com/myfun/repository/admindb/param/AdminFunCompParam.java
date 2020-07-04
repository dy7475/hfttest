package com.myfun.repository.admindb.param;

import com.myfun.repository.admindb.po.AdminFunComp;

public class AdminFunCompParam extends AdminFunComp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer shareId;
	private String joinCompany;
	private String joinCompanyText;
	private String position;
	private String transparent;
	private String brandNameId;

	public Integer getShareId() {
		return shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}

	public String getJoinCompany() {
		return joinCompany;
	}

	public void setJoinCompany(String joinCompany) {
		this.joinCompany = joinCompany;
	}

	public String getJoinCompanyText() {
		return joinCompanyText;
	}

	public void setJoinCompanyText(String joinCompanyText) {
		this.joinCompanyText = joinCompanyText;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTransparent() {
		return transparent;
	}

	public void setTransparent(String transparent) {
		this.transparent = transparent;
	}

	public String getBrandNameId() {
		return brandNameId;
	}

	public void setBrandNameId(String brandNameId) {
		this.brandNameId = brandNameId;
	}

}
