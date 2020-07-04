package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("门店基本信息")
public class ErpFunDeptsBaseInfoVO {

	@ApiModelProperty("门店名称")
	private String deptName;
	@ApiModelProperty("门店Id")
	private Integer deptId;
	@ApiModelProperty("公司编号")
	private String compNo;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
}
