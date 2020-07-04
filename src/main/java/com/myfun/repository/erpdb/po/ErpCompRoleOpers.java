package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpCompRoleOpers extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键id")
	private Integer autoId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色ID")
	private String roleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限ID")
	private String operId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否高级权限，1=是")
	private Integer operType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限作用范围的门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限作用范围的片区id")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限作用范围的大区id")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限作用范围的公司id")
	private Integer sourceCompId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限作用范围的分组id")
	private Integer groupId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用")
	private Byte partnerOper;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织机构定义ID")
	private Integer organizationDefinitionId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键id
	 */
	public Integer getAutoId() {
		return autoId;
	}

	/**
	 * @mbggenerated 主键id
	 */
	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @mbggenerated 权限ID
	 */
	public String getOperId() {
		return operId;
	}

	/**
	 * @mbggenerated 权限ID
	 */
	public void setOperId(String operId) {
		this.operId = operId;
	}

	/**
	 * @mbggenerated 是否高级权限，1=是
	 */
	public Integer getOperType() {
		return operType;
	}

	/**
	 * @mbggenerated 是否高级权限，1=是
	 */
	public void setOperType(Integer operType) {
		this.operType = operType;
	}

	/**
	 * @mbggenerated 权限作用范围的门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 权限作用范围的门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 权限作用范围的片区id
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 权限作用范围的片区id
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 权限作用范围的大区id
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 权限作用范围的大区id
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 权限作用范围的公司id
	 */
	public Integer getSourceCompId() {
		return sourceCompId;
	}

	/**
	 * @mbggenerated 权限作用范围的公司id
	 */
	public void setSourceCompId(Integer sourceCompId) {
		this.sourceCompId = sourceCompId;
	}

	/**
	 * @mbggenerated 权限作用范围的分组id
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * @mbggenerated 权限作用范围的分组id
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * @mbggenerated 0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
	 */
	public Byte getPartnerOper() {
		return partnerOper;
	}

	/**
	 * @mbggenerated 0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
	 */
	public void setPartnerOper(Byte partnerOper) {
		this.partnerOper = partnerOper;
	}

	/**
	 * @mbggenerated 组织机构定义ID
	 */
	public Integer getOrganizationDefinitionId() {
		return organizationDefinitionId;
	}

	/**
	 * @mbggenerated 组织机构定义ID
	 */
	public void setOrganizationDefinitionId(Integer organizationDefinitionId) {
		this.organizationDefinitionId = organizationDefinitionId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpCompRoleOpers() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpCompRoleOpers(Integer shardCityId, Integer autoId) {
		super(shardCityId);
		this.autoId = autoId;
	}
}