package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class DeleteCompDefineTemplateParam extends AbstractEncryParam {

	@ApiModelProperty(value = "tId", example = "1111")
	private Integer tId;

	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}
}
