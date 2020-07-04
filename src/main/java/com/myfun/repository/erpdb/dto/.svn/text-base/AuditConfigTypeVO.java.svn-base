package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AuditConfigTypeVO {
	@ApiModelProperty(value = "审核类型")
	private Integer auditType;
	@ApiModelProperty(value = "是否配置 0=未配置 1=已配置")
	private Integer configured = 0;
	@ApiModelProperty(value = "审核类型描述（作用按钮）")
	private String auditTypeDes;

	public String getAuditTypeDes() {
		return auditTypeDes;
	}

	public void setAuditTypeDes(String auditTypeDes) {
		this.auditTypeDes = auditTypeDes;
	}

	public Integer getAuditType() {
		return auditType;
	}

	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

	public Integer getConfigured() {
		return configured;
	}

	public void setConfigured(Integer configured) {
		this.configured = configured;
	}
}
