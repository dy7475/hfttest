package com.myfun.erpWeb.managecenter.userOpers.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月23日
 */
public class GetCrossCompUserVO {

	@ApiModelProperty("用户id")
	private Integer userId;
	@ApiModelProperty("用户姓名")
	private String userName;
	@ApiModelProperty("头像")
	private String userPhoto;
	@ApiModelProperty("角色名")
	private String roleName;
	@ApiModelProperty("公司id")
	private Integer compId;
	@ApiModelProperty("公司名")
	private String compName;
	
	
	public String getUserPhoto() {
	
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
	
		this.userPhoto = userPhoto;
	}
	public String getCompName() {
	
		return compName;
	}
	public void setCompName(String compName) {
	
		this.compName = compName;
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
	public String getRoleName() {
	
		return roleName;
	}
	public void setRoleName(String roleName) {
	
		this.roleName = roleName;
	}
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	
	
}

