package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel
public class MessageRichInfoListParam extends AbstractEncryParam {

	@NotBlank
	@ApiModelProperty(value = "模块")
	private Integer msgModule;

	public Integer getMsgModule() {
		return msgModule;
	}

	public void setMsgModule(Integer msgModule) {
		this.msgModule = msgModule;
	}
}