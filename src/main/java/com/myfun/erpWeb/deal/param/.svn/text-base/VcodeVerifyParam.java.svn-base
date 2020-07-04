package com.myfun.erpWeb.deal.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class VcodeVerifyParam implements EncryParamIfc {

	@NotNull
    @ApiModelProperty(value = "token", required = true)
	private String personalIdentity3Key;
	
	@NotNull
    @ApiModelProperty(value = "验证码", required = true)
	private String vcode;

	public String getPersonalIdentity3Key() {
		return personalIdentity3Key;
	}

	public void setPersonalIdentity3Key(String personalIdentity3Key) {
		this.personalIdentity3Key = personalIdentity3Key;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
}
