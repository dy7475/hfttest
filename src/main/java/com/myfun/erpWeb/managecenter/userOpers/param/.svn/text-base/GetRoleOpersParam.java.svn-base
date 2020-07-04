package com.myfun.erpWeb.managecenter.userOpers.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetRoleOpersParam implements EncryParamIfc {
	
	@ApiModelProperty("大区Id")
	private Integer areaId;
	
	@ApiModelProperty("片区Id")
	private Integer regId;
	
	@ApiModelProperty("门店Id")
	private Integer deptId;
	
	@ApiModelProperty("分组Id")
	private Integer grId;
	
	@ApiModelProperty("是否是公司角色,1是0否")
	private Integer isCompRole;
	
	@ApiModelProperty("角色编号,备注:不是角色名字")
	private String roleId;

	@ApiModelProperty("应用组织ID，后端去找层级, 如果是公司不传或者传0，其他具体组织就传选到最后一级的组织")
	private Integer organizationId = 0;
	
	@ApiModelProperty("修改员工的角色时，被修改人的id")
	private Integer userId;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

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

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public Integer getIsCompRole() {
		return isCompRole;
	}

	public void setIsCompRole(Integer isCompRole) {
		this.isCompRole = isCompRole;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
