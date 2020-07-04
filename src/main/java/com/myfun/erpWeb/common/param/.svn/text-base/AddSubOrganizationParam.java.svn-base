package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddSubOrganizationParam implements EncryParamIfc {

	@ApiModelProperty(value = "城市ID，后面跨库使用")
	private Integer cityId;
	@ApiModelProperty(value = "erp公司ID")
	private Integer compId;
	@ApiModelProperty(value = "组织名字")
	private String organizationName;
	@ApiModelProperty(value = "父级组织ID")
	private Integer pid;
	@ApiModelProperty(value = "组织联系电话 组织公盘房客源展示使用")
	private String contactNumber;
	@ApiModelProperty(value = "组织地址")
	private String organizationAddr;
	// @ApiModelProperty(value = "序号")
	// private Integer organizationSeq;

	@ApiModelProperty(value = "经纪人(主管)ID，多个用英文逗号隔开")
	private String adminUserId;

	@ApiModelProperty(hidden = true, value = "经纪人(操作者)ID")
	private Integer userId;

	@ApiModelProperty(value = "组织定义层级的id")
	private Integer definitionId;
	@ApiModelProperty(value = "美联专用：组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门")
	private Integer organizationBussinessType;
	@ApiModelProperty(value = "组织定义层级的id", hidden = true)
	private Integer compType;
	@ApiModelProperty(value = "公司编号", hidden = true)
	private String compNo;
	// modify lcb 修改于 2020/5/26 美联人事系统的主键
	private String mlOrgId;
	private Integer qxType;

	public String getMlOrgId() {
		return mlOrgId;
	}

	public void setMlOrgId(String mlOrgId) {
		this.mlOrgId = mlOrgId;
	}

	public Integer getOrganizationBussinessType() {

		return organizationBussinessType;
	}

	public void setOrganizationBussinessType(Integer organizationBussinessType) {

		this.organizationBussinessType = organizationBussinessType;
	}

	public Integer getCompType() {
		return compType;
	}

	public void setCompType(Integer compType) {
		this.compType = compType;
	}

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public Integer getDefinitionId() {

		return definitionId;
	}

	public void setDefinitionId(Integer definitionId) {

		this.definitionId = definitionId;
	}

	public String getAdminUserId() {

		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {

		this.adminUserId = adminUserId;
	}

	public Integer getUserId() {

		return userId;
	}

	public void setUserId(Integer userId) {

		this.userId = userId;
	}

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

	public String getOrganizationName() {

		return organizationName;
	}

	public void setOrganizationName(String organizationName) {

		this.organizationName = organizationName;
	}

	public Integer getPid() {

		return pid;
	}

	public void setPid(Integer pid) {

		this.pid = pid;
	}

	public String getContactNumber() {

		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {

		this.contactNumber = contactNumber;
	}

	public String getOrganizationAddr() {

		return organizationAddr;
	}

	public void setOrganizationAddr(String organizationAddr) {

		this.organizationAddr = organizationAddr;
	}

	public Integer getQxType() {
		return qxType;
	}

	public void setQxType(Integer qxType) {
		this.qxType = qxType;
	}

}
