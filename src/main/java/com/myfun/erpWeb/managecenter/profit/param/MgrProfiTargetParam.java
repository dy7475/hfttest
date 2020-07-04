package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MgrProfiTargetParam implements EncryParamIfc {
	@ApiModelProperty(value = "业绩统计方式")
	private Integer profitType;
	@ApiModelProperty(value = "组织ID")
	private Integer organizationId;
	@ApiModelProperty(value = "层级ID")
	private Integer defId;

	@ApiModelProperty(value = "日期")
	private String time;

	@ApiModelProperty(value = "用户Id")
	private Integer userId;
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	@ApiModelProperty(value = "门店Id")
	private Integer deptId;
	@ApiModelProperty(value = "片区ID")
	private Integer regId;
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;

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

	public Integer getProfitType() {
		return profitType;
	}

	public void setProfitType(Integer profitType) {
		this.profitType = profitType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
}
