package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LI XIAO TONG
 * @since 2019年8月29日 上午10:43:27
 * Modified XXX Li Xiao Tong 2019年8月29日
 */
public class GetCompNotInviteUserRoleVo {

	@ApiModelProperty(value = "用户ID，自增序列")
	private Integer userId;
	@ApiModelProperty(value = "邀请表主键Id")
	private Integer inviteId;
	@ApiModelProperty(value = "经纪人姓名")
	private String userName;
	@ApiModelProperty(value = "担任角色，From:FUN_ROLES")
	private String userPosition;

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
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
	public String getUserPosition() {
	
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
	
		this.userPosition = userPosition;
	}
	
	
	
}

