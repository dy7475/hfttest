package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Title
 * @Author 朱科
 * @Date 2017/12/28
 * @Param
 **/
public class ErpFunEmployeeLogParam extends AbstractEncryParam{
	
	private Integer areaId; // 大区Id
	private Integer regId; //片区Id
	private Integer grId; //分店Id
	private Integer userId; //用户Id
	private Integer logType; //类型 1=入职 2=组织调动 4=角色调动 5=离职
	private String startTime; //开始时间
	private String endTime; //结束时间
	private Integer deptId; //门店Id
	@ApiModelProperty("组织机构ID")
	private Integer organizationId;
	@ApiModelProperty(hidden = true)
	private boolean newOrganization = false;

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
	public Integer getLogType() {
		return logType;
	}
	public void setLogType(Integer logType) {
		this.logType = logType;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public boolean isNewOrganization() {
		return newOrganization;
	}

	public void setNewOrganization(boolean newOrganization) {
		this.newOrganization = newOrganization;
	}
}
