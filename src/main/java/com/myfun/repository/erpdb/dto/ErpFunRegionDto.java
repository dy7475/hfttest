package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunRegion;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunRegionDto extends ErpFunRegion{
	private String deptName;
	private Integer countUser;
	@ApiModelProperty(value = "大区名字")
	private String areaName;
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getCountUser() {
		return countUser;
	}
	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
