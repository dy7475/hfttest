package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取角色薪资配置方案
 * 请求参数封装
 * create by 程二狗 on 2018/11/27 0027
 */
@ApiModel
public class WageConfigParam implements EncryParamIfc {
	
    @ApiModelProperty("角色ID")
    private String roleId;
    
    @ApiModelProperty("职级ID-标准配置时不需要上传")
    private Integer roleLevelId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}
}
