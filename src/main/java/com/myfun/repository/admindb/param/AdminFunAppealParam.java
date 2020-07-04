package com.myfun.repository.admindb.param;

import com.myfun.repository.support.param.PageParam;

public class AdminFunAppealParam extends PageParam{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time1;
	private String time2;
	private String times;
	private Integer apStatus;
	private String userName;
	private String userMobile;
	private String apNo;
	
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getApNo() {
		return apNo;
	}
	public void setApNo(String apNo) {
		this.apNo = apNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getApStatus() {
		return apStatus;
	}
	public void setApStatus(Integer apStatus) {
		this.apStatus = apStatus;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	
}
