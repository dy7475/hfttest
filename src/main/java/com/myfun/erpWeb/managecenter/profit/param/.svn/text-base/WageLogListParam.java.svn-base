package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * create by 程二狗 on 2018/10/29 0029
 */
@ApiModel
public class WageLogListParam extends AbstractEncryParam {
    @ApiModelProperty("薪资ID")
    private Integer wageId;
    @ApiModelProperty("日志类型 1=调整 2=代扣代缴 3=奖金  4=扣款 5=审核")
    private Integer logType;
    @ApiModelProperty("日期起 格式 yyyy-MM-dd")
    private String startTime;
    @ApiModelProperty("日期止 格式 yyyy-MM-dd")
    private String endTime;
    @ApiModelProperty(value = "公司ID", hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "薪资所属人")
    private Integer wageUserId;
    @ApiModelProperty(value = "大区")
    private Integer areaId;
    @ApiModelProperty(value = "片区")
    private Integer regId;
    @ApiModelProperty(value = "门店")
    private Integer deptId;
    @ApiModelProperty(value = "分组")
    private Integer grId;
    @ApiModelProperty(value = "仅调整")
    private Integer justAdjustment = 0;
    @ApiModelProperty(value = "组织机构ID")
    private Integer organizationId;
    @ApiModelProperty(value = "是否新组织机构",hidden = true)
    private boolean newOrganization = false;


    public Integer getJustAdjustment() {
        return justAdjustment;
    }

    public void setJustAdjustment(Integer justAdjustment) {
        this.justAdjustment = justAdjustment;
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

    public Integer getWageUserId() {
        return wageUserId;
    }

    public void setWageUserId(Integer wageUserId) {
        this.wageUserId = wageUserId;
    }

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

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
