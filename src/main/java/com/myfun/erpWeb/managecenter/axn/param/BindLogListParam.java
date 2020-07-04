package com.myfun.erpWeb.managecenter.axn.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BindLogListParam extends AbstractEncryParam {

	@ApiModelProperty(value = "0 = 绑定日志, 1 = 解绑日志")
	private Byte bindFlag;
	
	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "员工id")
	private Integer userId;
	
	@ApiModelProperty(value = "号池名")
	private String numberPoolName;
	
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	
	@ApiModelProperty(value = "结束时间")
	private String endTime;

	@ApiModelProperty(value = "是否是导出，导出就不页 1=是")
	private Byte isExport;
	
	@ApiModelProperty(hidden = true)
	private String numberPoolKey;
	
	@ApiModelProperty(hidden = true)
	private Integer compId;

	public Byte getBindFlag() {
		return bindFlag;
	}

	public void setBindFlag(Byte bindFlag) {
		this.bindFlag = bindFlag;
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

	public String getNumberPoolName() {
		return numberPoolName;
	}

	public void setNumberPoolName(String numberPoolName) {
		this.numberPoolName = numberPoolName;
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

	public Byte getIsExport() {
		return isExport;
	}

	public void setIsExport(Byte isExport) {
		this.isExport = isExport;
	}

	public String getNumberPoolKey() {
		return numberPoolKey;
	}

	public void setNumberPoolKey(String numberPoolKey) {
		this.numberPoolKey = numberPoolKey;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	
}
