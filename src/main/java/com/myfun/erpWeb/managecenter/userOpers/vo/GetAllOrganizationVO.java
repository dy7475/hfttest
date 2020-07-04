package com.myfun.erpWeb.managecenter.userOpers.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月23日
 */
public class GetAllOrganizationVO {

	@ApiModelProperty("公司id")
	private Integer compId;
	@ApiModelProperty("公司名")
	private String compName;
	@ApiModelProperty("组织id")
	private Integer organizationId;
	@ApiModelProperty("组织名")
	private String organizationName;
	@ApiModelProperty("父级id")
	private Integer pid;
	
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public String getCompName() {
	
		return compName;
	}
	public void setCompName(String compName) {
	
		this.compName = compName;
	}
	public Integer getOrganizationId() {
	
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
	
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
	
		this.organizationName = organizationName;
	}
	public Integer getPid() {
	
		return pid;
	}
	public void setPid(Integer pid) {
	
		this.pid = pid;
	}
	
	
}

