package com.myfun.erpWeb.managecenter.userOpers.vo;
 /**
 * @author lzg
 * @since 2019年12月25日
 */


import io.swagger.annotations.ApiModelProperty;

public class GetCrossCompOperVO {

	@ApiModelProperty("权限类型")
	private Integer operType;
	@ApiModelProperty("权限id")
	private String operId;
	@ApiModelProperty("权限名")
	private String operName;
	
	public Integer getOperType() {
	
		return operType;
	}
	public void setOperType(Integer operType) {
	
		this.operType = operType;
	}
	public String getOperId() {
	
		return operId;
	}
	public void setOperId(String operId) {
	
		this.operId = operId;
	}
	public String getOperName() {
	
		return operName;
	}
	public void setOperName(String operName) {
	
		this.operName = operName;
	}
	
}

