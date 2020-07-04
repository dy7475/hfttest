package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年7月1日 上午9:20:32
 * Modified XXX HuangJiang 2019年7月1日
 */
@ApiModel
public class ZtGetAppLoginLogsParam extends AbstractEncryParam {

	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;
	@ApiModelProperty(value = "片区ID")
	private Integer regId;
	@ApiModelProperty(value = "部门ID")
	private Integer deptId;
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	@ApiModelProperty(value = "查询的开始时间")
	private String startTime;
	@ApiModelProperty(value = "查询的结束时间")
	private String endTime;
	@ApiModelProperty(value = "设备类型，传0表示电脑 不传表示手机")
	private Integer deviceType;
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public Integer getAreaId() {
	
		return areaId;
	}
	public void setAreaId(Integer areaId) {
	
		this.areaId = areaId;
	}
	public Integer getRegId() {
	
		return regId;
	}
	public void setRegId(Integer regId) {
	
		this.regId = regId;
	}
	public Integer getDeptId() {
	
		return deptId;
	}
	public void setDeptId(Integer deptId) {
	
		this.deptId = deptId;
	}
	public Integer getGrId() {
	
		return grId;
	}
	public void setGrId(Integer grId) {
	
		this.grId = grId;
	}
	public Integer getUserId() {
	
		return userId;
	}
	public void setUserId(Integer userId) {
	
		this.userId = userId;
	}
	public String getStartTime() {
	
		return startTime;
	}
	public void setStartTime(String startTime) {
	
		this.startTime = startTime;
	}
	public String getEndTime() {
	
		return endTime;
	}
	public void setEndTime(String endTime) {
	
		this.endTime = endTime;
	}
	public Integer getDeviceType() {
	
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
	
		this.deviceType = deviceType;
	}
	
}