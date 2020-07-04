package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DealFunEarbestMoneyDetailParam extends AbstractEncryParam {
	@ApiModelProperty(value = "诚意金主键")
	private Integer earbestId;

	public Integer getEarbestId() {
		return earbestId;
	}

	public void setEarbestId(Integer earbestId) {
		this.earbestId = earbestId;
	}
}
