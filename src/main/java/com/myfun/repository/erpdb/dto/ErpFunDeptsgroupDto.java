package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunDeptsgroupDto extends ErpFunDeptsgroup{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("组内成员姓名以,隔开")
	private String grMemberName;
	@ApiModelProperty("组内成员的userId以,隔开")
	private String grMember;
	@ApiModelProperty("总人数")
	private  Integer countUser;

	public Integer getCountUser() {
		return countUser;
	}

	public void setCountUser(Integer countUser) {
		this.countUser = countUser;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getGrMemberName() {
		return grMemberName;
	}

	public void setGrMemberName(String grMemberName) {
		this.grMemberName = grMemberName;
	}

	public String getGrMember() {
		return grMember;
	}

	public void setGrMember(String grMember) {
		this.grMember = grMember;
	}
}
