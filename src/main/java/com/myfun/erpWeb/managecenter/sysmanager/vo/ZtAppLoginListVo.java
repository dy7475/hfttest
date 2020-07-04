package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年7月1日 上午10:44:16
 * Modified XXX HuangJiang 2019年7月1日
 */
public class ZtAppLoginListVo {

	@ApiModelProperty(value="主键ID")
	private Integer id;
	@ApiModelProperty(value="公司ID")
	private Integer compId;
	@ApiModelProperty(value="门店ID")
	private Integer deptId;
	@ApiModelProperty(value="用户ID")
	private Integer userId;
	@ApiModelProperty(value="用户名")
	private String userName;
	@ApiModelProperty(value="登录时间")
	private String logtime;
	@ApiModelProperty("工作台机器ID")
	private String pcid;
	@ApiModelProperty("登录地址")
	private String loginAddress;
	@ApiModelProperty(value="用户角色")
	private String userPosition;
	@ApiModelProperty(value="手机品牌")
	private String mobileBrand;
	@ApiModelProperty(value="用户头像")
	private String userPhoto;
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
	
		this.id = id;
	}
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public Integer getDeptId() {
	
		return deptId;
	}
	public void setDeptId(Integer deptId) {
	
		this.deptId = deptId;
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
	public String getLogtime() {
	
		return logtime;
	}
	public void setLogtime(String logtime) {
	
		this.logtime = logtime;
	}
	public String getPcid() {
	
		return pcid;
	}
	public void setPcid(String pcid) {
	
		this.pcid = pcid;
	}
	public String getLoginAddress() {
	
		return loginAddress;
	}
	public void setLoginAddress(String loginAddress) {
	
		this.loginAddress = loginAddress;
	}
	public String getUserPosition() {
	
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
	
		this.userPosition = userPosition;
	}
	public String getMobileBrand() {
	
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
	
		this.mobileBrand = mobileBrand;
	}
	public String getUserPhoto() {
	
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
	
		this.userPhoto = userPhoto;
	}
	
}

