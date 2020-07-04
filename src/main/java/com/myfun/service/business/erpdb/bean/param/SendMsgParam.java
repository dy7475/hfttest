package com.myfun.service.business.erpdb.bean.param;

import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel
public class SendMsgParam {
	@NotEmpty
	private String action;
	@NotEmpty
	private String content;
	/** 短信通道 sms4zfd 找房东特有的嘉信通通道 sms4ddhf 滴滴好房通道 **/
	private String smsSource;
	@NotEmpty
	private String phone;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSmsSource() {
		return smsSource;
	}

	public void setSmsSource(String smsSource) {
		this.smsSource = smsSource;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
