package com.myfun.erpWeb.managecenter.userOpers.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author guohao
 * @date 2019-03-08 17:57
 */
public class UpdateRoleOperaParam implements EncryParamIfc {
	@ApiModelProperty("增加的权限")
	private String addOpers;
	@ApiModelProperty("删除的权限")
	private String delOpers;
	@ApiModelProperty("NEW_SET_OPER = 1 表示这次是第一次添加， 0：编辑以往有的角色权限配置")
	private Integer isNewSetOper;

	@ApiModelProperty("是否公司角色")
	private Integer isCompRole;
	@ApiModelProperty("应用范围 保留员工配置1否则0")
	private Integer effectRange;
	@NotNull
	@ApiModelProperty("角色id")
	private String roleId;
	@ApiModelProperty("")
	private Integer areaId;
	@ApiModelProperty("")
	private Integer regId;
	@ApiModelProperty("")
	private Integer deptId;
	@ApiModelProperty("")
	private Integer grId;
	@ApiModelProperty("是否参与统计")
	private Byte partStatistCount;

	@ApiModelProperty("新版组织机构的新增或者更新的权限 格式json格式[{'operId':'xxxx','organizationDefinitionId':12001}]")
	private String updateOpers;
	@ApiModelProperty("应用范围ID")
	private Integer organizationId;

	public String getUpdateOpers() {
		return updateOpers;
	}

	public void setUpdateOpers(String updateOpers) {
		this.updateOpers = updateOpers;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getAddOpers() {
		return addOpers;
	}

	public void setAddOpers(String addOpers) {
		this.addOpers = addOpers;
	}

	public String getDelOpers() {
		return delOpers;
	}

	public void setDelOpers(String delOpers) {
		this.delOpers = delOpers;
	}

	public Integer getIsNewSetOper() {
		return isNewSetOper;
	}

	public void setIsNewSetOper(Integer isNewSetOper) {
		this.isNewSetOper = isNewSetOper;
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

	public Byte getPartStatistCount() {
		return partStatistCount;
	}

	public void setPartStatistCount(Byte partStatistCount) {
		this.partStatistCount = partStatistCount;
	}
	
}
