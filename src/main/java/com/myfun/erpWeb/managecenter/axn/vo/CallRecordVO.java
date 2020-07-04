package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CallRecordVO implements Serializable{

	@ApiModelProperty(value = "隐号")
	private String bindX;
	
	@ApiModelProperty(value = "客户业主号码")
	private String calledPhone;
	
	@ApiModelProperty(value = "员工id")
	private Integer callUserId;
	
	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "通话开始")
	private String startTime;
	
	@ApiModelProperty(value = "通话结束")
	private String endTime;
	
	@ApiModelProperty(value = "通话时长")
	private Integer callLength;
	
	@ApiModelProperty(value = "来源")
	private String callSource;
	
	@ApiModelProperty(value = "类型")
	private String callType;
	
	@ApiModelProperty(value = "语音地址")
	private String callRecordUrl;

	public String getBindX() {
		return bindX;
	}

	public void setBindX(String bindX) {
		this.bindX = bindX;
	}

	public String getCalledPhone() {
		return calledPhone;
	}

	public void setCalledPhone(String calledPhone) {
		this.calledPhone = calledPhone;
	}

	public Integer getCallUserId() {
		return callUserId;
	}

	public void setCallUserId(Integer callUserId) {
		this.callUserId = callUserId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
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

	public Integer getCallLength() {
		return callLength;
	}

	public void setCallLength(Integer callLength) {
		this.callLength = callLength;
	}

	public String getCallSource() {
		return callSource;
	}

	public void setCallSource(String callSource) {
		this.callSource = callSource;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getCallRecordUrl() {
		return callRecordUrl;
	}

	public void setCallRecordUrl(String callRecordUrl) {
		this.callRecordUrl = callRecordUrl;
	}
	
}
