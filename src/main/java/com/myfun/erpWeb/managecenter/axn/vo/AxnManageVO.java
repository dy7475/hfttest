package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AxnManageVO implements Serializable{

	@ApiModelProperty(value = "userId")
	private Integer userId;
	
	@ApiModelProperty(value = "组织")
	private Integer organizationId;
	
	@ApiModelProperty(value = "角色")
	private String userPosition;
	
	@ApiModelProperty(value = "经纪人手机号")
	private String userMobile;
	
	@ApiModelProperty(value = "姓名")
	private String userName;
	
	@ApiModelProperty(value = "绑定手机号")
	private String bindX;
	
	@ApiModelProperty(value = "绑定状态 1=已绑定")
	private Byte numberState;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBindX() {
		return bindX;
	}

	public void setBindX(String bindX) {
		this.bindX = bindX;
	}

	public Byte getNumberState() {
		return numberState;
	}

	public void setNumberState(Byte numberState) {
		this.numberState = numberState;
	}
	
}
