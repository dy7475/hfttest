package com.myfun.erpWeb.managecenter.userOpers.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzg
 * @since 2019年12月23日
 */
public class GetOrgUsersListVO {


	@ApiModelProperty("用户信息列表")
	private List<GetOrgUsersVO> list;

	public List<GetOrgUsersVO> getList() {
	
		return list;
	}

	public void setList(List<GetOrgUsersVO> list) {
	
		this.list = list;
	}
	
}

