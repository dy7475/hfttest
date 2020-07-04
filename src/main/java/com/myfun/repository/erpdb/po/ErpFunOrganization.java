package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunOrganization extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "序列主键  序列是admin库的SEQ_ERP_FUN_DEPTS_DEPT_ID")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID，后面跨库使用")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "erp公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织名字")
	private String organizationName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除")
	private Byte delFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织机构定义ID 关联FUN_ORGANIZATION_DEFINITION表主键")
	private Integer organizationDefinitionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "父级组织ID")
	private Integer pid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织综合查询字段")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织联系电话 组织公盘房客源展示使用")
	private String contactNumber;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织地址")
	private String organizationAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织更新/删除时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "序号")
	private Integer organizationSeq;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织人数")
	private Integer organizationUserNum;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门")
	private Byte organizationBussinessType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟商id")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "路由MAC")
	private String routemac;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织编号（类似门店编号）")
	private String organizationNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String positionX;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String positionY;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer qxType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String mlOrgId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 序列主键  序列是admin库的SEQ_ERP_FUN_DEPTS_DEPT_ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated 序列主键  序列是admin库的SEQ_ERP_FUN_DEPTS_DEPT_ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated 城市ID，后面跨库使用
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID，后面跨库使用
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated erp公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated erp公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 组织名字
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @mbggenerated 组织名字
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @mbggenerated 是否删除
	 */
	public Byte getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated 是否删除
	 */
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @mbggenerated 组织机构定义ID 关联FUN_ORGANIZATION_DEFINITION表主键
	 */
	public Integer getOrganizationDefinitionId() {
		return organizationDefinitionId;
	}

	/**
	 * @mbggenerated 组织机构定义ID 关联FUN_ORGANIZATION_DEFINITION表主键
	 */
	public void setOrganizationDefinitionId(Integer organizationDefinitionId) {
		this.organizationDefinitionId = organizationDefinitionId;
	}

	/**
	 * @mbggenerated 父级组织ID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * @mbggenerated 父级组织ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * @mbggenerated 组织综合查询字段
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated 组织综合查询字段
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated 组织联系电话 组织公盘房客源展示使用
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @mbggenerated 组织联系电话 组织公盘房客源展示使用
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @mbggenerated 组织地址
	 */
	public String getOrganizationAddr() {
		return organizationAddr;
	}

	/**
	 * @mbggenerated 组织地址
	 */
	public void setOrganizationAddr(String organizationAddr) {
		this.organizationAddr = organizationAddr;
	}

	/**
	 * @mbggenerated 组织创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 组织创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 组织更新/删除时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 组织更新/删除时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 序号
	 */
	public Integer getOrganizationSeq() {
		return organizationSeq;
	}

	/**
	 * @mbggenerated 序号
	 */
	public void setOrganizationSeq(Integer organizationSeq) {
		this.organizationSeq = organizationSeq;
	}

	/**
	 * @mbggenerated 组织人数
	 */
	public Integer getOrganizationUserNum() {
		return organizationUserNum;
	}

	/**
	 * @mbggenerated 组织人数
	 */
	public void setOrganizationUserNum(Integer organizationUserNum) {
		this.organizationUserNum = organizationUserNum;
	}

	/**
	 * @mbggenerated 组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门
	 */
	public Byte getOrganizationBussinessType() {
		return organizationBussinessType;
	}

	/**
	 * @mbggenerated 组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门
	 */
	public void setOrganizationBussinessType(Byte organizationBussinessType) {
		this.organizationBussinessType = organizationBussinessType;
	}

	/**
	 * @mbggenerated 加盟商id
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @mbggenerated 加盟商id
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @mbggenerated 路由MAC
	 */
	public String getRoutemac() {
		return routemac;
	}

	/**
	 * @mbggenerated 路由MAC
	 */
	public void setRoutemac(String routemac) {
		this.routemac = routemac;
	}

	/**
	 * @mbggenerated 组织编号（类似门店编号）
	 */
	public String getOrganizationNo() {
		return organizationNo;
	}

	/**
	 * @mbggenerated 组织编号（类似门店编号）
	 */
	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	/**
	 * @mbggenerated -
	 */
	public String getPositionX() {
		return positionX;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	/**
	 * @mbggenerated -
	 */
	public String getPositionY() {
		return positionY;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getQxType() {
		return qxType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setQxType(Integer qxType) {
		this.qxType = qxType;
	}

	/**
	 * @mbggenerated -
	 */
	public String getMlOrgId() {
		return mlOrgId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setMlOrgId(String mlOrgId) {
		this.mlOrgId = mlOrgId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunOrganization() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunOrganization(Integer shardCityId, Integer organizationId) {
		super(shardCityId);
		this.organizationId = organizationId;
	}
}