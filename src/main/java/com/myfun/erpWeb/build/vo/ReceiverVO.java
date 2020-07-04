package com.myfun.erpWeb.build.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReceiverVO implements Serializable {

	@ApiModelProperty("经纪人id")
	private Integer userId;
	
	@ApiModelProperty("经纪人名字")
	private String userName;
	
	@ApiModelProperty("archiveid")
	private Integer archiveId;
	
	@ApiModelProperty("大区id")
	private Integer areaId;
	
	@ApiModelProperty("片区id")
	private Integer regId;
	
	@ApiModelProperty("门店id")
	private Integer deptId;
	
	@ApiModelProperty("分组id")
	private Integer grId;
	
	@ApiModelProperty("组织id")
	private Integer organizationId;

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

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

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

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
}
