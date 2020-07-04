package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetSysLoginLogsParam extends AbstractEncryParam {
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "设备类型 0电脑ERP 1安卓 2IOS")
	private Integer deviceType;
	@ApiModelProperty(value = "部门ID")
	private Integer deptId;
	@ApiModelProperty(value = "查询的开始时间")
	private String date1;
	@ApiModelProperty(value = "查询的结束时间")
	private String date2;
	@ApiModelProperty(hidden = true)
	private Integer loginStatus;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty(hidden = true)
	private Integer grId;
	@ApiModelProperty(value = "1 导出 0 不到出")
	private Byte isExport;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
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

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public Byte getIsExport() {
		return isExport;
	}

	public void setIsExport(Byte isExport) {
		this.isExport = isExport;
	}
}
