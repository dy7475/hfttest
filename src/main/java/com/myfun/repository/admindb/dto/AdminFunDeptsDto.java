package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunDepts;

public class AdminFunDeptsDto extends AdminFunDepts{
	private static final long serialVersionUID = 1L;
	/**
	 * @mbggenerated 支付状态 0=已缴纳 1=申请提现 2=提现中 3=提现成功
	 */
	private Byte payStatus;
	/**
	 * @mbggenerated 缴纳金额
	 */
	private Long paidAmount;
	
	/**
	 * 以下信息来源于CRM_USER
	 */
	private Integer userId;
	private String userName;
	private String userFixedph;
	private String userQq;
	private String userMobile;
	
	public Byte getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Byte payStatus) {
		this.payStatus = payStatus;
	}
	public Long getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserFixedph() {
		return userFixedph;
	}
	
	public void setUserFixedph(String userFixedph) {
		this.userFixedph = userFixedph;
	}
	
	public String getUserQq() {
		return userQq;
	}
	
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	
	public String getUserMobile() {
		return userMobile;
	}
	
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
	
}
