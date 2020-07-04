package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpCompRoleLevelsVO {

	@ApiModelProperty(value = "职级ID")
	private Integer roleLevelId;
	
	@ApiModelProperty(value = "角色ID-字符串类型")
	private String roleId;
	
	@ApiModelProperty(value = "职级名称-角色范围内不能重复")
	private String roleLevelName;
	
	@ApiModelProperty(value = "数据库排序：序号越大，则职级越高")
	private Integer seqNo;
	
	@ApiModelProperty(value = "职级的薪资配置ID，只在薪资配置中使用")
	private Integer wageConfigId;
	
	public Integer getRoleLevelId() {
		return roleLevelId;
	}
	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleLevelName() {
		return roleLevelName;
	}
	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public Integer getWageConfigId() {
		return wageConfigId;
	}
	public void setWageConfigId(Integer wageConfigId) {
		this.wageConfigId = wageConfigId;
	}
}