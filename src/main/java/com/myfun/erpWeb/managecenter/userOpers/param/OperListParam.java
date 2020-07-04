package com.myfun.erpWeb.managecenter.userOpers.param;
 /**
 * @author lzg
 * @since 2019年12月24日
 */

import io.swagger.annotations.ApiModelProperty;

public class OperListParam {

	@ApiModelProperty("公司id")
	private Integer compId;
	@ApiModelProperty("新增的跨城权限组")
	private String addOpers;
	@ApiModelProperty("移除的跨城权限组")
	private String delOpers;
	
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public String getAddOpers() {
	
		return addOpers;
	}
	public void setAddOpers(String addOpers) {
	
		this.addOpers = addOpers;
	}
	public String getDelOpers() {
	
		return delOpers;
	}
	public void setDelOpers(String delOpers) {
	
		this.delOpers = delOpers;
	}
	
}

