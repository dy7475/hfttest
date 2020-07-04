package com.myfun.repository.agencydb.dto;

import java.util.Date;

import com.myfun.repository.agencydb.po.AgencyFunCustDeal;

public class AgencyFunCustDealDto extends AgencyFunCustDeal{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer custId;
	private Date commissionTime;
	private String custMobile;
	private String custStatus;
	private Boolean systemflag;
	private Integer memoCount;
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Date getCommissionTime() {
		return commissionTime;
	}
	public void setCommissionTime(Date commissionTime) {
		this.commissionTime = commissionTime;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public Boolean getSystemflag() {
		return systemflag;
	}
	public void setSystemflag(Boolean systemflag) {
		this.systemflag = systemflag;
	}
	public Integer getMemoCount() {
		return memoCount;
	}
	public void setMemoCount(Integer memoCount) {
		this.memoCount = memoCount;
	}
	
	
}
