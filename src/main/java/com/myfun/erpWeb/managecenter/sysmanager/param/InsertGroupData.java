package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class InsertGroupData implements EncryParamIfc {

	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer selfDeptId;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty(hidden = true)
	private Integer nGrId;
	@ApiModelProperty("分组成员的userId,用逗号隔开")
	private String grMember;
	@ApiModelProperty("分组id,修改分组的时候才传，新增分组不传")
	private Integer grId;
	@ApiModelProperty("序号")
	private Integer seqNo;
	@ApiModelProperty("门店ID")
	private Integer deptId;
	@ApiModelProperty("分组名字")
	private String grName;
	@ApiModelProperty("分组负责人姓名")
	private String grContact;
	@ApiModelProperty("分组负责人电话")
	private String grTele;
	@ApiModelProperty("分组分组描述")
	private String grDesc;
	@ApiModelProperty("分组负责人userId")
	private Integer adminUser;
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
	public Integer getSelfDeptId() {
		return selfDeptId;
	}
	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getnGrId() {
		return nGrId;
	}
	public void setnGrId(Integer nGrId) {
		this.nGrId = nGrId;
	}
	public String getGrMember() {
		return grMember;
	}
	public void setGrMember(String grMember) {
		this.grMember = grMember;
	}
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getGrName() {
		return grName;
	}
	public void setGrName(String grName) {
		this.grName = grName;
	}
	public String getGrContact() {
		return grContact;
	}
	public void setGrContact(String grContact) {
		this.grContact = grContact;
	}
	public String getGrTele() {
		return grTele;
	}
	public void setGrTele(String grTele) {
		this.grTele = grTele;
	}
	public String getGrDesc() {
		return grDesc;
	}
	public void setGrDesc(String grDesc) {
		this.grDesc = grDesc;
	}
	public Integer getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(Integer adminUser) {
		this.adminUser = adminUser;
	}
}
