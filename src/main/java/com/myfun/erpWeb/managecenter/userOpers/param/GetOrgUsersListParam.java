package com.myfun.erpWeb.managecenter.userOpers.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月23日
 */
public class GetOrgUsersListParam implements EncryParamIfc  {

	@ApiModelProperty("公司id")
	private Integer compId;
	@ApiModelProperty("组织id")
	private Integer organizationId;
	@ApiModelProperty("用户姓名")
	private String userName;
	
	public Integer getCompId() {
	
		return compId;
	}
	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}
	public Integer getOrganizationId() {
	
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}
	public String getUserName() {
	
		return userName;
	}
	public void setUserName(String userName) {
	
		this.userName = userName;
	}

}

