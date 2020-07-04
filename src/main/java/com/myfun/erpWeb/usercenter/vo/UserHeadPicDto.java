package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UserHeadPicDto {
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "用户头像")
	private String userPhoto;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
}
