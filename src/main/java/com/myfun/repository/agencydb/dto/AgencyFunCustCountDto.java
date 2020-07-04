package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyFunCust;

/**
 * 数据统计对象
 * **/
public class AgencyFunCustCountDto extends AgencyFunCust{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer custCount;
	private Integer checkCount;
	private Integer sawCount;
	private Integer dealCount;
	private Integer commissionCount;
	private Integer commissionSum;
	private Integer agentCount;
	private Integer deptCount;
	
	private Integer cdId;
	private String roomText;
	private String userName;
	private String userMobile;
	private Integer userStatus;
	private String userPosition;
	
	public Integer getCdId() {
		return cdId;
	}
	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}
	public String getRoomText() {
		return roomText;
	}
	public void setRoomText(String roomText) {
		this.roomText = roomText;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public Integer getCustCount() {
		return custCount;
	}
	public void setCustCount(Integer custCount) {
		this.custCount = custCount;
	}
	public Integer getCheckCount() {
		return checkCount;
	}
	public void setCheckCount(Integer checkCount) {
		this.checkCount = checkCount;
	}
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
	public Integer getCommissionSum() {
		return commissionSum;
	}
	public void setCommissionSum(Integer commissionSum) {
		this.commissionSum = commissionSum;
	}
	public Integer getAgentCount() {
		return agentCount;
	}
	public void setAgentCount(Integer agentCount) {
		this.agentCount = agentCount;
	}
	public Integer getDeptCount() {
		return deptCount;
	}
	public void setDeptCount(Integer deptCount) {
		this.deptCount = deptCount;
	}
	
	
}
