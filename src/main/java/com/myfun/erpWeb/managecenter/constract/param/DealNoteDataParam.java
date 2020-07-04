package com.myfun.erpWeb.managecenter.constract.param;

import com.google.gson.JsonObject;
import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class DealNoteDataParam extends AbstractEncryParam {
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "合同日志ID")
	private Integer recordId;

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getDealId() {

		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
}
