package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 展开基本工资下拉列表、
 * 请求参数封装
 * create by 程二狗 on 2018/11/17 0017
 */
@ApiModel(description = "展开基本工资下拉列表")
public class PerformanceAssessmentCountListParam implements EncryParamIfc {
    @ApiModelProperty(value = "公司ID",hidden = true)
    private Integer compId;
    @ApiModelProperty("大区Id")
    private Integer areaId;
    @ApiModelProperty("片区ID")
    private Integer regId;
    @ApiModelProperty("门店ID")
    private Integer deptId;
    @ApiModelProperty("分组ID")
    private Integer grId;
    @ApiModelProperty("结算月")
    private String assessmentMonth;
    @ApiModelProperty("用户ID")
    private Integer userId;
    @ApiModelProperty("考核类型 1=本人 2=管理")
    private Byte checkType;
    @ApiModelProperty("角色ID")
    private String roleId;
    @ApiModelProperty(value = "组织机构ID")
    private Integer organizationId;
    @ApiModelProperty(value = "是否新组织机构",hidden = true)
    private boolean newOrganization = false;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }



    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getCheckType() {
        return checkType;
    }

    public void setCheckType(Byte checkType) {
        this.checkType = checkType;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public boolean isNewOrganization() {
        return newOrganization;
    }

    public void setNewOrganization(boolean newOrganization) {
        this.newOrganization = newOrganization;
    }
}
