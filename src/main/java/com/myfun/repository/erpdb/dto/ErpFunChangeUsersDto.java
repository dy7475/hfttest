package com.myfun.repository.erpdb.dto;
/**
 * 员工异动类
 * @author Administrator
 *
 */
public class ErpFunChangeUsersDto {
	
	private Integer userId;
	private Integer deptId;
	private String userDeptId;//deptId_userId
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getUserDeptId() {
		return userDeptId;
	}
	public void setUserDeptId(String userDeptId) {
		this.userDeptId = userDeptId;
	}
	
}
