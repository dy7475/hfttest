package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class OnlinePayCustInfoVO {

	@ApiModelProperty("客户")
	private String buyCustName;
	@ApiModelProperty("客户")
	private String rentCustName;

	public String getBuyCustName() {
		return buyCustName;
	}

	public void setBuyCustName(String buyCustName) {
		this.buyCustName = buyCustName;
	}

	public String getRentCustName() {
		return rentCustName;
	}

	public void setRentCustName(String rentCustName) {
		this.rentCustName = rentCustName;
	}
}
