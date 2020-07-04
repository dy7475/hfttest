package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpFunCompRolesPermissionTemplateRelate extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键id自增")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色id")
	private String roleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限模板id，来自FUN_COMP_PERMISSION_TEMPLATE的主键id")
	private Integer templateId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private String creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键id自增
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键id自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 角色id
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated 角色id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @mbggenerated 权限模板id，来自FUN_COMP_PERMISSION_TEMPLATE的主键id
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @mbggenerated 权限模板id，来自FUN_COMP_PERMISSION_TEMPLATE的主键id
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunCompRolesPermissionTemplateRelate() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunCompRolesPermissionTemplateRelate(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}