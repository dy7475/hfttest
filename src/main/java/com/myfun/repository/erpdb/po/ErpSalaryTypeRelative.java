package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpSalaryTypeRelative extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "大区id")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "区域id")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组id")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "	薪资方案id")
	private Integer salaryTypeId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "人员Id")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色id")
	private String roleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除标记 0有效 1已删除")
	private Integer delFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除时间")
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增ID
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
	 * @mbggenerated 大区id
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区id
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 区域id
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 区域id
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 分组id
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组id
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 薪资方案id
	 */
	public Integer getSalaryTypeId() {
		return salaryTypeId;
	}

	/**
	 * @mbggenerated 薪资方案id
	 */
	public void setSalaryTypeId(Integer salaryTypeId) {
		this.salaryTypeId = salaryTypeId;
	}

	/**
	 * @mbggenerated 人员Id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 人员Id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
		this.roleId = roleId == null ? null : roleId.trim();
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 删除标记 0有效 1已删除
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * @mbggenerated 删除标记 0有效 1已删除
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpSalaryTypeRelative() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpSalaryTypeRelative(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}