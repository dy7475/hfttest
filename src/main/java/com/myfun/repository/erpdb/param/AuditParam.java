package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class AuditParam implements EncryParamIfc {
	@ApiModelProperty(value = "审核任务id", required = true)
	@NotNull(message = "请指定审核任务")
	private Integer id;

	@ApiModelProperty(value = "审核状态，0=不通过 1=通过", required = true)
	@NotNull
	private Byte auditStatus;

	@ApiModelProperty("审核理由（不通过时必填）")
	private String trackContent;

	@ApiModelProperty("审核类型")
	private Integer auditType;

	public Integer getAuditType() {
		return auditType;
	}

	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getTrackContent() {
		return trackContent;
	}

	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}
}
