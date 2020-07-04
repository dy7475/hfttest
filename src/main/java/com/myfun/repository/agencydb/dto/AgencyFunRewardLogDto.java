package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyFunRewardLog;

public class AgencyFunRewardLogDto extends AgencyFunRewardLog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer paidStatus;
	
	private String custName;
	
	private String custMobile;
	
	private String buildName;
	
	private Integer custStatus;

	public Integer getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(Integer paidStatus) {
		this.paidStatus = paidStatus;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Integer getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(Integer custStatus) {
		this.custStatus = custStatus;
	}
	
	
}
