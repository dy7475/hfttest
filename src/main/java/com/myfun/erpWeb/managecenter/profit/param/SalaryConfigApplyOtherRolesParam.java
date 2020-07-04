package com.myfun.erpWeb.managecenter.profit.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 薪资配置模板应用到其它角色
 * 请求参数参数封装
 * create by 程二狗 on 2018/11/13 0013
 */
@ApiModel(description = "薪资配置模板应用到其它角色-请求参数")
public class SalaryConfigApplyOtherRolesParam implements Serializable {
    @ApiModelProperty("应用角色ids")
    private String roleIds;
    @ApiModelProperty("配置类型 0=业务配置 1=管理配置")
    private Integer configType;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getConfigType() {
        return configType;
    }

    public void setConfigType(Integer configType) {
        this.configType = configType;
    }
}
