package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AuditConfigParam implements EncryParamIfc {
	@ApiModelProperty(value = "审核资源，1=跟进类审核 2=请假 3=外出审核 4=权证合同类的审批", required = true)
	private Integer auditResource;

	public Integer getAuditResource() {
		return auditResource;
	}

	public void setAuditResource(Integer auditResource) {
		this.auditResource = auditResource;
	}
}
