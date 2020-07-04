package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModelProperty;

public class AdminRentDeptsDto extends AbstractEncryParam{

	@ApiModelProperty(value = "租用门店的名字")
	private String rentDeptName;
	@ApiModelProperty(value = "租用到期时间")
	private String rentEndTime;
	@ApiModelProperty(value = "公司编号")
	private String compNo;
	@ApiModelProperty(value = "erp库租用门店编号")
	private String deptNo;
	@ApiModelProperty(value = "erp库租用门店id")
	private Integer deptId;
	@ApiModelProperty(value = "账号总数")
	private Integer totalUserNum;
	@ApiModelProperty(value = "已用账号")
	private Integer usedUserNum;
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getRentDeptName() {
		return rentDeptName;
	}
	public void setRentDeptName(String rentDeptName) {
		this.rentDeptName = rentDeptName;
	}
	public String getRentEndTime() {
		return rentEndTime;
	}
	public void setRentEndTime(String rentEndTime) {
		this.rentEndTime = rentEndTime;
	}
	public Integer getTotalUserNum() {
		return totalUserNum;
	}
	public void setTotalUserNum(Integer totalUserNum) {
		this.totalUserNum = totalUserNum;
	}
	public Integer getUsedUserNum() {
		return usedUserNum;
	}
	public void setUsedUserNum(Integer usedUserNum) {
		this.usedUserNum = usedUserNum;
	}
	
}
