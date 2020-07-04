package com.myfun.erpWeb.homepage.vo;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class AppAchieveMonthStatisticsRankDto extends AbstractEncryParam{

	@ApiModelProperty(value = "完成总量")
	private String completeTotal;
	@ApiModelProperty(value = "userId", hidden = true)
	private Integer userId;
	@ApiModelProperty(value = "用户名")
	private String userName;
	@ApiModelProperty(value = "门店名")
	private String deptName;
	@ApiModelProperty(value = "用户头像")
	private String userPhoto;
	@ApiModelProperty(value = "2=按大区3=按片区4=按门店5=按分组6按员工")
	private Integer lookType;
	@ApiModelProperty(value = "lookType对应lookTypeId,如2=lookType为按大区，则lookTypeId就为areaId")
	private Integer lookTypeId;
	@ApiModelProperty(value = "lookType为5是传对应的deptId")
	private Integer deptId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getLookTypeId() {
		return lookTypeId;
	}
	public void setLookTypeId(Integer lookTypeId) {
		this.lookTypeId = lookTypeId;
	}
	public Integer getLookType() {
		return lookType;
	}
	public void setLookType(Integer lookType) {
		this.lookType = lookType;
	}
	public String getCompleteTotal() {
		return completeTotal;
	}
	public void setCompleteTotal(String completeTotal) {
		this.completeTotal = completeTotal;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
}
