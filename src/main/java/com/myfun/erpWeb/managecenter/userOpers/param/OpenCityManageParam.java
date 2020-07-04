package com.myfun.erpWeb.managecenter.userOpers.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月24日
 */
public class OpenCityManageParam {

	@ApiModelProperty("公司id")
	private Integer compId;
	@ApiModelProperty("跨城权限开启标记：0=关、1=开")
	private Byte isOpen;
	
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public Byte getIsOpen() {
	
		return isOpen;
	}
	public void setIsOpen(Byte isOpen) {
	
		this.isOpen = isOpen;
	}
	
}

