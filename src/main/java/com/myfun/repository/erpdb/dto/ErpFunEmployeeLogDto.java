package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunEmployeeLog;

public class ErpFunEmployeeLogDto extends ErpFunEmployeeLog {

	private static final long serialVersionUID = 1L;

	private String userName; // 用户名
	private Integer userWriteoff; // 1=已注销
	private Integer userId; // DOC useId
	private Integer areaId; // 大区Id
	private Integer regId; // 片区Id
	private Integer grId; // 分组Id
	private Integer deptId; // 门店Id
	private String createUserName; //创建人的名字+公司名字
	private String beforeOrganizationName;
	private String afterOrganizationName;
	private String compName;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getUserWriteoff() {
		return userWriteoff;
	}

	public void setUserWriteoff(Integer userWriteoff) {
		this.userWriteoff = userWriteoff;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateUserName() {
		
		return createUserName;
		
	}

	public void setCreateUserName(String createUserName) {
		
		this.createUserName = createUserName;
		
	}

	public String getBeforeOrganizationName() {
		return beforeOrganizationName;
	}

	public void setBeforeOrganizationName(String beforeOrganizationName) {
		this.beforeOrganizationName = beforeOrganizationName;
	}

	public String getAfterOrganizationName() {
		return afterOrganizationName;
	}

	public void setAfterOrganizationName(String afterOrganizationName) {
		this.afterOrganizationName = afterOrganizationName;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
}
