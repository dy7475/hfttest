package com.myfun.erpWeb.managecenter.buildData.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class DeleteViewBuildRuleParam implements EncryParamIfc {

	@ApiModelProperty(value = "要暂停的记录ID")
	private Integer ids;
	@ApiModelProperty(value = "0 已暂停 1 进行中")
	private Byte status;

	public Integer getIds() {
		return ids;
	}

	public void setIds(Integer ids) {
		this.ids = ids;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
}
