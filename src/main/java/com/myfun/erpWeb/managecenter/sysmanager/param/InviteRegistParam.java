package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class InviteRegistParam  extends AbstractEncryParam {
	@ApiModelProperty(value = "部门id")
	private Integer deptId;
	@ApiModelProperty(value = "用户性别")
	private Integer userSex;
	@ApiModelProperty(value = "分组id")
	private Integer groupId;
	@ApiModelProperty(value = "用户电话")
	private String userMobile;
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	@ApiModelProperty(value = "用户角色")
	private String userPosition;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
}
