package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyFunUsers;

public class AgencyFunUsersDto extends AgencyFunUsers{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer sawCount;
	
	private Integer dealCount;
	
	private Integer commissionCount;

	public Integer getSawCount() {
		return sawCount;
	}

	public void setSawCount(Integer sawCount) {
		this.sawCount = sawCount;
	}

	public Integer getDealCount() {
		return dealCount;
	}

	public void setDealCount(Integer dealCount) {
		this.dealCount = dealCount;
	}

	public Integer getCommissionCount() {
		return commissionCount;
	}

	public void setCommissionCount(Integer commissionCount) {
		this.commissionCount = commissionCount;
	}
	
	
	
}
	
	
