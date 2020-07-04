package com.myfun.erpWeb.usercenter.param;


import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DelFunInvoiceEnclosureParam implements EncryParamIfc {

	@ApiModelProperty(value = "主键id")
	@NotNull
	private Integer esId;

	public Integer getEsId() {
		return esId;
	}

	public void setEsId(Integer esId) {
		this.esId = esId;
	}
}