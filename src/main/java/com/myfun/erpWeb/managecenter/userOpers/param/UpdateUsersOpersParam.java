package com.myfun.erpWeb.managecenter.userOpers.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class UpdateUsersOpersParam implements EncryParamIfc{

	@ApiModelProperty(value = "用户userId")
	private Integer userId;
	@ApiModelProperty(value = "角色Id")
	private String roleId;
	@ApiModelProperty(value = "管理范围Id,逗号隔开")
	private String rangeIds;
	@ApiModelProperty(value = "管理范围类型,1公司2大区3片区4门店5分组")
	private Integer rangeType;
	@ApiModelProperty(value = "用户角色是否改变，1是0否")
	private Integer userRoleChange;
	@ApiModelProperty(value = "删除的权限Id,逗号隔开")
	private String delOpers;
	@ApiModelProperty(value = "增加的权限Id,逗号隔开")
	private String addOpers;

	@ApiModelProperty("新版组织机构修改和新增的的权限 格式json格式[{'operId':'xxxx','organizationDefinitionId':12001}]")
	private String updateOpers;

	public String getUpdateOpers() {
		return updateOpers;
	}

	public void setUpdateOpers(String updateOpers) {
		this.updateOpers = updateOpers;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRangeIds() {
		return rangeIds;
	}
	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}
	public Integer getRangeType() {
		return rangeType;
	}
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
	public Integer getUserRoleChange() {
		return userRoleChange;
	}
	public void setUserRoleChange(Integer userRoleChange) {
		this.userRoleChange = userRoleChange;
	}
	public String getDelOpers() {
		return delOpers;
	}
	public void setDelOpers(String delOpers) {
		this.delOpers = delOpers;
	}
	public String getAddOpers() {
		return addOpers;
	}
	public void setAddOpers(String addOpers) {
		this.addOpers = addOpers;
	}
}
