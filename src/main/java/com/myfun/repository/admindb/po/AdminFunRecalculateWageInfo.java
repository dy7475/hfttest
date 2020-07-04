package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class AdminFunRecalculateWageInfo implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色ID")
	private String roleId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "结算月份")
	private String assessmentMonth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否是关联管理查询")
	private Byte manageCaculate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "定制模式 1=房基地管理模式")
	private Integer customizedType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	 * @mbggenerated 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	 * @mbggenerated 结算月份
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated 结算月份
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
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
	 * @mbggenerated 是否是关联管理查询
	 */
	public Byte getManageCaculate() {
		return manageCaculate;
	}

	/**
	 * @mbggenerated 是否是关联管理查询
	 */
	public void setManageCaculate(Byte manageCaculate) {
		this.manageCaculate = manageCaculate;
	}

	/**
	 * @mbggenerated 定制模式 1=房基地管理模式
	 */
	public Integer getCustomizedType() {
		return customizedType;
	}

	/**
	 * @mbggenerated 定制模式 1=房基地管理模式
	 */
	public void setCustomizedType(Integer customizedType) {
		this.customizedType = customizedType;
	}
}