package com.myfun.erpWeb.common.vo;

import java.util.Date;
import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunUsers;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunOrganizationVO {

	@ApiModelProperty(value = "序列主键  序列是admin库的SEQ_ERP_FUN_DEPTS_DEPT_ID")
	private Integer organizationId;
	
	@ApiModelProperty(value = "组织名字")
	private String organizationName;
	
	@ApiModelProperty(value = "城市ID，后面跨库使用")
	private Integer cityId;
	
	@ApiModelProperty(value = "城市名称")
	private String cityName;
	
	@ApiModelProperty(value = "erp公司ID")
	private Integer compId;
	
	@ApiModelProperty(value = "erp公司名称")
	private String compName;
	
	@ApiModelProperty(value = "组织机构定义ID 关联FUN_ORGANIZATION_DEFINITION表主键")
	private Integer organizationDefinitionId;
	
	@ApiModelProperty(value = "父级组织ID")
	private Integer pid;
	
	@ApiModelProperty(value = "组织综合查询字段")
	private String organizationPath;
	
	@ApiModelProperty(value = "组织联系电话 组织公盘房客源展示使用")
	private String contactNumber;
	
	@ApiModelProperty(value = "组织地址")
	private String organizationAddr;
	
	@ApiModelProperty(value = "组织创建时间")
	private Date creationTime;
	
	@ApiModelProperty(value = "序号")
	private Integer organizationSeq;
	
	@ApiModelProperty(value = "当前组织人数")
	private Integer organizationUserNum;
	
	@ApiModelProperty(value = "当前组织的子级组织数")
	private Integer childOrganizationNum;
	
	@ApiModelProperty(value = "组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门")
	private Byte organizationBussinessType;
	
	@ApiModelProperty(value = "加盟商id")
	private Integer partnerId;
	
	@ApiModelProperty(value = "路由MAC")
	private String routemac;
	
	@ApiModelProperty(value = "组织编号（类似门店编号）")
	private String organizationNo;
	
	@ApiModelProperty(value = "组织的主管信息")
	private List<OrgManagerVO> managerList;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Integer getOrganizationDefinitionId() {
		return organizationDefinitionId;
	}

	public void setOrganizationDefinitionId(Integer organizationDefinitionId) {
		this.organizationDefinitionId = organizationDefinitionId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getOrganizationPath() {
		return organizationPath;
	}

	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
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

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getOrganizationSeq() {
		return organizationSeq;
	}

	public void setOrganizationSeq(Integer organizationSeq) {
		this.organizationSeq = organizationSeq;
	}

	public Integer getOrganizationUserNum() {
		return organizationUserNum;
	}

	public void setOrganizationUserNum(Integer organizationUserNum) {
		this.organizationUserNum = organizationUserNum;
	}

	public Integer getChildOrganizationNum() {
		return childOrganizationNum;
	}

	public void setChildOrganizationNum(Integer childOrganizationNum) {
		this.childOrganizationNum = childOrganizationNum;
	}

	public Byte getOrganizationBussinessType() {
		return organizationBussinessType;
	}

	public void setOrganizationBussinessType(Byte organizationBussinessType) {
		this.organizationBussinessType = organizationBussinessType;
	}

	public Integer getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public String getRoutemac() {
		return routemac;
	}

	public void setRoutemac(String routemac) {
		this.routemac = routemac;
	}

	public String getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	public List<OrgManagerVO> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<OrgManagerVO> managerList) {
		this.managerList = managerList;
	}
}
