package com.myfun.erpWeb.managecenter.sysmanager.vo;
 /**
 * @author LI XIAO TONG
 * @since 2019年8月30日 下午5:11:52
 * Modified XXX Li Xiao Tong 2019年8月30日
 */

import io.swagger.annotations.ApiModelProperty;

public class ShareRegisterUrlVo {

	@ApiModelProperty(value = "分享注册链接地址")
	private String shareRegisterUrl;

	public String getShareRegisterUrl() {
	
		return shareRegisterUrl;
	}

	public void setShareRegisterUrl(String shareRegisterUrl) {
	
		this.shareRegisterUrl = shareRegisterUrl;
	}
	
	
}

