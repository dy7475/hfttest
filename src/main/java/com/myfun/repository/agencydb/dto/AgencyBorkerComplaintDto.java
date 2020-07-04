package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyBorkerComplaint;

public class AgencyBorkerComplaintDto extends AgencyBorkerComplaint{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hasrRefund;
	private String refundTime;
	private String pbMoney;
	private String refundFlag;
	private String refundUser;
	public String getHasrRefund() {
		return hasrRefund;
	}
	public void setHasrRefund(String hasrRefund) {
		this.hasrRefund = hasrRefund;
	}
	public String getRefundTime() {
		return refundTime;
	}
	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}
	public String getPbMoney() {
		return pbMoney;
	}
	public void setPbMoney(String pbMoney) {
		this.pbMoney = pbMoney;
	}
	public String getRefundFlag() {
		return refundFlag;
	}
	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}
	public String getRefundUser() {
		return refundUser;
	}
	public void setRefundUser(String refundUser) {
		this.refundUser = refundUser;
	}
	
	
}
