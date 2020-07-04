package com.myfun.erpWeb.common.vo;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpCompRoles;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("公司角色VO")
public class ErpCompRolesVo {

	@ApiModelProperty("主键ID")
	private Integer autoId;
	@ApiModelProperty("角色ID")
	private String roleId;
	@ApiModelProperty("公司ID")
	private Integer compId;
	@ApiModelProperty("角色名")
	private String roleName;
	@ApiModelProperty("序号")
	private Byte seqNo;
	@ApiModelProperty("管理标记，1=管理层")
	private Byte manageFlag;
	@ApiModelProperty("是否是公司自定义角色")
	private Byte isCompRole;
	@ApiModelProperty("是否删除 0=未删除 1=删除")
	private Byte isDel;
	@ApiModelProperty("管理层级 0=没有 1=公司 2=大区 3=片区 4=门店 5=分组")
	private Byte manageLevel;
	
	private List<ErpCompRoles> compRolesList;
	
	public List<ErpCompRoles> getCompRolesList() {
		return compRolesList;
	}

	public void setCompRolesList(List<ErpCompRoles> compRolesList) {
		this.compRolesList = compRolesList;
	}

	public Integer getAutoId() {
		return autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Byte getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Byte seqNo) {
		this.seqNo = seqNo;
	}

	public Byte getManageFlag() {
		return manageFlag;
	}

	public void setManageFlag(Byte manageFlag) {
		this.manageFlag = manageFlag;
	}

	public Byte getIsCompRole() {
		return isCompRole;
	}

	public void setIsCompRole(Byte isCompRole) {
		this.isCompRole = isCompRole;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public Byte getManageLevel() {
		return manageLevel;
	}

	public void setManageLevel(Byte manageLevel) {
		this.manageLevel = manageLevel;
	}
}
