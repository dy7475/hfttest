package com.myfun.erpWeb.managecenter.axn.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CallRecordListParam extends AbstractEncryParam {

	@ApiModelProperty(hidden = true)
	private Integer compId;
	
	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	
	@ApiModelProperty(value = "拨打开始时间")
	private String startTime;
	
	@ApiModelProperty(value = "拨打结束时间")
	private String endTime;
	
	@ApiModelProperty(value = "类型 1=去电 2=来电")
	private Byte callSource;
	
	@ApiModelProperty(value = "来源 1=出售 2=出租 3=求购 4=求租")
	private Byte callType;
	
	@ApiModelProperty(value = "是否是导出，导出就不页 1=是")
	private Byte isExport;
	
	@ApiModelProperty(value = "关键字")
	private String keys;

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
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

	public Byte getCallSource() {
		return callSource;
	}

	public void setCallSource(Byte callSource) {
		this.callSource = callSource;
	}

	public Byte getCallType() {
		return callType;
	}

	public void setCallType(Byte callType) {
		this.callType = callType;
	}

	public Byte getIsExport() {
		return isExport;
	}

	public void setIsExport(Byte isExport) {
		this.isExport = isExport;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}
	
}
