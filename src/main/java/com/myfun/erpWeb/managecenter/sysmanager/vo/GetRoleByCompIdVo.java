package com.myfun.erpWeb.managecenter.sysmanager.vo;
 /**
 * @author LI XIAO TONG
 * @since 2019年8月28日 上午11:17:24
 * Modified XXX Li Xiao Tong 2019年8月28日
 */

import io.swagger.annotations.ApiModelProperty;

public class GetRoleByCompIdVo {

	@ApiModelProperty(value = "主键ID")
	private Integer autoId;
	@ApiModelProperty(value = "角色ID")
	private String roleId;
	@ApiModelProperty(value = "角色名")
	private String roleName;
	@ApiModelProperty(value = "序号")
	private Byte seqNo;

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
	
	
	
}

