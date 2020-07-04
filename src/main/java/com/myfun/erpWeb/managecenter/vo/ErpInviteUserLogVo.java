package com.myfun.erpWeb.managecenter.vo;

import com.myfun.repository.erpdb.po.ErpInviteUserLog;

import io.swagger.annotations.ApiModelProperty;

public class ErpInviteUserLogVo extends ErpInviteUserLog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("邀请人姓名")
	private String invitUserName;
	public String getInvitUserName() {
		return invitUserName;
	}
	public void setInvitUserName(String invitUserName) {
		this.invitUserName = invitUserName;
	}

	 
	
	
	
}
