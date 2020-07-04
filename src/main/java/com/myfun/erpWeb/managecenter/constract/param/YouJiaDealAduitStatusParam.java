package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel

public class YouJiaDealAduitStatusParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同Id")
	private Integer dealId;
	@ApiModelProperty(value = "类型")
	private Byte contentType;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Byte getContentType() {
		return contentType;
	}

	public void setContentType(Byte contentType) {
		this.contentType = contentType;
	}
}
