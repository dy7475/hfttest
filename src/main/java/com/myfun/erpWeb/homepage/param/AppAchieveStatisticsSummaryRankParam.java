package com.myfun.erpWeb.homepage.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class AppAchieveStatisticsSummaryRankParam implements EncryParamIfc {
	
	@ApiModelProperty(value = "管理范围，1:公司 2:大区3：片区 4：门店 5：分组 6：到人", required = true)
	private  Integer rangeType;
	@ApiModelProperty(value = "范围id（如rangeType为1,则rangeId为对应的compId,多个Id,用逗号隔开）", required = true)
	private  String rangeIds;
	@ApiModelProperty(value = "查询分组的情况把deptId带上，其他情况不传")
	private  Integer deptId;
	@ApiModelProperty(value = "开始时间,如:2019-01-01", required = true)
	private String startDate;
	@ApiModelProperty(value = "结束时间,如:2019-01-01", required = true)
	private String endDate;
	@ApiModelProperty(value = "考核类型，1=日考核2=周考核3=月考核")
	private  Integer dateType;
	@ApiModelProperty(value = "层级主键ID   (员工:-2),(全公司：0)")
	private Integer defId;
	@ApiModelProperty(value = "本组织机构ID")
	private Integer organizationId;
	@ApiModelProperty(value = "经纪人id")
	private Integer userId;

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDateType() {
		return dateType;
	}
	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
