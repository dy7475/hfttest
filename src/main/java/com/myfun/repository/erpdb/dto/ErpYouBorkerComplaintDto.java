package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpYouBorkerComplaint;

public class ErpYouBorkerComplaintDto extends ErpYouBorkerComplaint {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sourceUserName;
	private String sourceUserMobile;
	private String targetUserName;
	private String complainTypeName;
	private String crmUserName;
	private Integer shareId;

	public Integer getShareId() {
		return shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}

	public String getComplainTypeName() {
		return complainTypeName;
	}

	public void setComplainTypeName(String complainTypeName) {
		this.complainTypeName = complainTypeName;
	}

	public String getCrmUserName() {
		return crmUserName;
	}

	public void setCrmUserName(String crmUserName) {
		this.crmUserName = crmUserName;
	}

	public String getSourceUserName() {
		return sourceUserName;
	}

	public void setSourceUserName(String sourceUserName) {
		this.sourceUserName = sourceUserName;
	}

	public String getSourceUserMobile() {
		return sourceUserMobile;
	}

	public void setSourceUserMobile(String sourceUserMobile) {
		this.sourceUserMobile = sourceUserMobile;
	}

	public String getTargetUserName() {
		return targetUserName;
	}

	public void setTargetUserName(String targetUserName) {
		this.targetUserName = targetUserName;
	}

}
