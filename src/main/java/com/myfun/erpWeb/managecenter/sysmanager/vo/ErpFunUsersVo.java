package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dto.ErpFunUserResumeDto;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunUsersVo {

	@ApiModelProperty(value = "用户信息列表")
	private PageInfo<ErpFunUsersDto> list;
	
	@ApiModelProperty(value = "员工历程集合，key=archiveId，value=历程列表")
	private Map<String, List<ErpFunUserResumeDto>> resumeMap;
	@ApiModelProperty(value = "在职员工数量")
	private Integer numberOfEmployees;
	@ApiModelProperty(value = "离职员工数量")
	private Integer numberOfEmployeesLeft;

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployeesLeft() {
		return numberOfEmployeesLeft;
	}

	public void setNumberOfEmployeesLeft(Integer numberOfEmployeesLeft) {
		this.numberOfEmployeesLeft = numberOfEmployeesLeft;
	}
	public PageInfo<ErpFunUsersDto> getList() {
		return list;
	}

	public void setList(PageInfo<ErpFunUsersDto> list) {
		this.list = list;
	}

	public Map<String, List<ErpFunUserResumeDto>> getResumeMap() {
		return resumeMap;
	}

	public void setResumeMap(Map<String, List<ErpFunUserResumeDto>> resumeMap) {
		this.resumeMap = resumeMap;
	}
}
