package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunPhoto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunPhotoDto extends ErpFunPhoto{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "图片num")
	private String picNum;
	
	@ApiModelProperty(value = "图片类型0室内图1户型图2委托书类型3=小区图片")
	private String picType;
	
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	
	@ApiModelProperty(value = "用户名称")
	private String userName;
	
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	
	@ApiModelProperty(value = "门店名称")
	private String deptName;
	
	@ApiModelProperty(value = "删除人门店id")
	private Integer deldeptId ;
	
	@ApiModelProperty(value = "删除人名称")
	private String deluserName;
	
	@ApiModelProperty(value = "删除人门店名称")
	private String deldeptName;
	
	@ApiModelProperty(value = "图片操作人")
	private Integer uploadSourceUser;
	@ApiModelProperty(value = "图片操作人名称")
	private String uploadSourceUserName;
	@ApiModelProperty(value = "能否删除 0.否 1.是")
	private Integer delFlag = 0;

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getUploadSourceUser() {
		return uploadSourceUser;
	}

	public void setUploadSourceUser(Integer uploadSourceUser) {
		this.uploadSourceUser = uploadSourceUser;
	}

	public String getUploadSourceUserName() {
		return uploadSourceUserName;
	}

	public void setUploadSourceUserName(String uploadSourceUserName) {
		this.uploadSourceUserName = uploadSourceUserName;
	}

	public String getPicNum() {
		return picNum;
	}

	public void setPicNum(String picNum) {
		this.picNum = picNum;
	}

	public String getPicType() {
		return picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
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

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeldeptId() {
		return deldeptId;
	}

	public void setDeldeptId(Integer deldeptId) {
		this.deldeptId = deldeptId;
	}

	public String getDeluserName() {
		return deluserName;
	}

	public void setDeluserName(String deluserName) {
		this.deluserName = deluserName;
	}

	public String getDeldeptName() {
		return deldeptName;
	}

	public void setDeldeptName(String deldeptName) {
		this.deldeptName = deldeptName;
	}
}
