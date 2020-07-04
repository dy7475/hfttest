package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2019-03-08 17:50
 */
public class AddRoleParam implements EncryParamIfc {
	@ApiModelProperty("角色名")
	private String roleName;
	@ApiModelProperty("管理级别 0=没有 1=公司 2=大区 3=片区 4=门店 5=分组")
	private Integer manageLevel;
	@ApiModelProperty("顺序在哪个角色后面")
	private String beforRoleId;
	@ApiModelProperty(value = "1:参与统计   0不参与统计")
	private Byte partStatistCount;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getManageLevel() {
		return manageLevel;
	}

	public void setManageLevel(Integer manageLevel) {
		this.manageLevel = manageLevel;
	}

	public String getBeforRoleId() {
		return beforRoleId;
	}

	public void setBeforRoleId(String beforRoleId) {
		this.beforRoleId = beforRoleId;
	}

	public Byte getPartStatistCount() {
		return partStatistCount;
	}

	public void setPartStatistCount(Byte partStatistCount) {
		this.partStatistCount = partStatistCount;
	}
	
}
