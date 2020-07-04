package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LI XIAO TONG
 * @since 2019年8月29日 上午10:58:42
 * Modified XXX Li Xiao Tong 2019年8月29日
 */
public class GetAllCompUserVo {

	@ApiModelProperty(value = "用户ID，自增序列")
	private Integer userId;
	@ApiModelProperty(value = "经纪人姓名")
	private String userName;
	@ApiModelProperty(value = "经纪人门店ID")
	private Integer deptId;
	@ApiModelProperty(value = "经纪人分组ID")
	private Integer grId;


	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
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
	
	
	
}

