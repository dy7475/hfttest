package com.myfun.erpWeb.homepage.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class AppWorkAchieveParam implements EncryParamIfc {

	@ApiModelProperty(value = "管理范围，1:公司 2:大区3：片区 4：门店 5：分组 6：到人", required = true)
	private Integer rangeType;
	@ApiModelProperty(value = "范围id（如rangeType为1,则rangeId为对应的compId,多个Id,用逗号隔开）", required = true)
	private String rangeIds;
	@ApiModelProperty(value = "开始时间,如:2018-12-11", required = true)
	private String startDate;
	@ApiModelProperty(value = "结束时间,如:2018-12-11", required = true)
	private String endDate;
	@ApiModelProperty(value = "查询分组的情况把deptId带上，其他情况不传")
	private  Integer deptId;
	@ApiModelProperty(value = "考核类型，1=日考核2=周考核3=月考核")
	private  Integer dateType;
	@ApiModelProperty(value = "公司id")
	private  Integer compId;
	@ApiModelProperty(value = "用户id")
	private  Integer userId;
	@ApiModelProperty(value = "城市id")
	private  Integer cityId;
	@ApiModelProperty(value = "层级主键ID   (员工:-2),(全公司：0)")
	private Integer defId;
	@ApiModelProperty(value = "管理范围Ids")
	private Integer organizationId;
	@ApiModelProperty(hidden = true,value = "查询维度")
	private String dimension;
	
	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}
	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getRangeType() {
		return rangeType;
	}
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
	public String getRangeIds() {
		return rangeIds;
	}
	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getDateType() {
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
}
