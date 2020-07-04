package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *由用户id和结算月获取薪资详情
 * 或  由薪资id和结算月获取薪资详情
 * 请求参数封装
 * create by 程二狗 on 2018/11/17 0017
 */
@ApiModel(description = "获取薪资详情")
public class FunWageDetailParam implements EncryParamIfc {
    @ApiModelProperty(value = "公司ID",hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "薪资ID(app)")
    private Integer wageId;
    @ApiModelProperty("用户ID(app)")
    private Integer userId;
    @ApiModelProperty("门店ID")
    private Integer deptId;
    @ApiModelProperty("分组ID")
    private Integer grId;
    @ApiModelProperty("结算月(app)")
    private String assessmentMonth;
    @ApiModelProperty("角色Id")
    private String roleId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getWageId() {
        return wageId;
    }

    public void setWageId(Integer wageId) {
        this.wageId = wageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
