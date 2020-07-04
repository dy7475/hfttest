package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpAliyunPhone;

public class AliyunPhoneDto extends ErpAliyunPhone {

	private Integer userId;
	
	private String userName;
	
	private Integer organizationId;
	
	private String userPosition;
	
	private String userMobile;
	
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

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
}
