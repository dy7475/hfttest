package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class GetUsersSortedParam extends AbstractEncryParam {
	@ApiModelProperty(value = "1=按公司2=按大区3=按片区4=按门店5=按分组6按员工", required = true)
	private Integer rangeType;
	@ApiModelProperty(value = "rangeType对应rangeId,如1=rangeType为按公司，则rangeId就为compId")
	private Integer rangeId;
	@ApiModelProperty(value = "查分组的时候才传deptId，其他情况不传")
	private Integer deptId;
	@ApiModelProperty(value = "1=按姓名2=按角色3=按入职时间4=按离职时间5=按员工状态")
	private Integer sortType;
	public Integer getRangeType() {
		return rangeType;
	}
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
	public Integer getRangeId() {
		return rangeId;
	}
	public void setRangeId(Integer rangeId) {
		this.rangeId = rangeId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getSortType() {
		return sortType;
	}
	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}
}
