package com.myfun.erpWeb.managecenter.sysmanager.vo;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class InviteLinkVo implements EncryParamIfc {

	@ApiModelProperty(value = "链接地址")
	private String inviteLink;

	public String getInviteLink() {
		return inviteLink;
	}

	public void setInviteLink(String inviteLink) {
		this.inviteLink = inviteLink;
	}
}
