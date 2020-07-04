package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class UpdateRangeData implements EncryParamIfc {
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty("片区Id")
	private Integer regId;
	@ApiModelProperty("片区所属大区Id")
	private Integer areaId;
	@ApiModelProperty("片区序号")
	private Integer seqNo;
	@ApiModelProperty("片区区域负责人ID")
	private Integer adminUser;
	@ApiModelProperty("片区姓名")
	private String regName;
	@ApiModelProperty("片区负责人电话姓名")
	private String regAdmin;
	@ApiModelProperty("片区描述")
	private String regDesc;
	@ApiModelProperty("片区负责人电话")
	private String regTele;
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
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
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
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegAdmin() {
		return regAdmin;
	}
	public void setRegAdmin(String regAdmin) {
		this.regAdmin = regAdmin;
	}
	public String getRegDesc() {
		return regDesc;
	}
	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}
	public String getRegTele() {
		return regTele;
	}
	public void setRegTele(String regTele) {
		this.regTele = regTele;
	}
}
