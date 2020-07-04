package com.myfun.erpWeb.managecenter.userOpers.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateRolePermissionTemplateParam implements EncryParamIfc {

	@ApiModelProperty(value = "权限模板id，修改权限模板名称的时候传，其他时候不传")
	@NotNull
	private Integer permissionTemplateId;
	
	@ApiModelProperty(value = "是否公司角色")
	private Integer isCompRole;
	
	@ApiModelProperty(value = "应用范围 保留员工配置=1，不保留=0")
	private Integer effectRange;
	
	@ApiModelProperty(value = "角色id")
	@NotNull
	private String roleId;
	
	@ApiModelProperty(value = "当前用户门店id", hidden = true)
	private Integer curDeptId;
	
	@ApiModelProperty(value = "当前用户id", hidden = true)
	private Integer curUserId;
	
	public Integer getCurDeptId() {
		return curDeptId;
	}

	public void setCurDeptId(Integer curDeptId) {
		this.curDeptId = curDeptId;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	@ApiModelProperty(value = "是否参与统计")
	private Byte partStatistCount;

	public Integer getPermissionTemplateId() {
		return permissionTemplateId;
	}

	public void setPermissionTemplateId(Integer permissionTemplateId) {
		this.permissionTemplateId = permissionTemplateId;
	}

	public Integer getIsCompRole() {
		return isCompRole;
	}

	public void setIsCompRole(Integer isCompRole) {
		this.isCompRole = isCompRole;
	}

	public Integer getEffectRange() {
		return effectRange;
	}

	public void setEffectRange(Integer effectRange) {
		this.effectRange = effectRange;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Byte getPartStatistCount() {
		return partStatistCount;
	}

	public void setPartStatistCount(Byte partStatistCount) {
		this.partStatistCount = partStatistCount;
	}
}
