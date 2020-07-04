package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class UpdateAreaData implements EncryParamIfc {

	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty("片区所属大区Id")
	private Integer areaId;
	@ApiModelProperty("片区序号")
	private Integer seqNo;
	@ApiModelProperty("片区区域负责人ID")
	private Integer adminUser;
	@ApiModelProperty("大区姓名")
	private String areaName;
	@ApiModelProperty("打区负责人电话姓名")
	private String areaAdmin;
	@ApiModelProperty("大区描述")
	private String areaDesc;
	@ApiModelProperty("大区负责人电话")
	private String areaTele;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public Integer getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(Integer adminUser) {
		this.adminUser = adminUser;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaAdmin() {
		return areaAdmin;
	}
	public void setAreaAdmin(String areaAdmin) {
		this.areaAdmin = areaAdmin;
	}
	public String getAreaDesc() {
		return areaDesc;
	}
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	public String getAreaTele() {
		return areaTele;
	}
	public void setAreaTele(String areaTele) {
		this.areaTele = areaTele;
	}
}
