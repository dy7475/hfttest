package com.myfun.erpWeb.build.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class PermissionTrackListParam extends AbstractEncryParam {
    //授权组织、员工、楼盘、操作日期
    @ApiModelProperty(value = "授权组织ID")
    private Integer organizationId;
    @ApiModelProperty(value = "员工ID")
    private Integer userId;
    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;
    @ApiModelProperty(value = "操作日期 - 开始")
    private String creationTimeStr;
    @ApiModelProperty(value = "操作日期 - 结束")
    private String creationTimeEnd;
    @ApiModelProperty(value = "操作日期 - 开始",hidden = true)
    private Date creationTimeStrD;
    @ApiModelProperty(value = "操作日期 - 结束",hidden = true)
    private Date creationTimeEndD;

    @ApiModelProperty(value = "城市Id",hidden = true)
    private Integer cityId;

    @ApiModelProperty(value = "城市Id",hidden = true)
    private Integer compId;

    public Date getCreationTimeStrD() {
        return creationTimeStrD;
    }

    public void setCreationTimeStrD(Date creationTimeStrD) {
        this.creationTimeStrD = creationTimeStrD;
    }

    public Date getCreationTimeEndD() {
        return creationTimeEndD;
    }

    public void setCreationTimeEndD(Date creationTimeEndD) {
        this.creationTimeEndD = creationTimeEndD;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getCreationTimeStr() {
        return creationTimeStr;
    }

    public void setCreationTimeStr(String creationTimeStr) {
        this.creationTimeStr = creationTimeStr;
    }

    public String getCreationTimeEnd() {
        return creationTimeEnd;
    }

    public void setCreationTimeEnd(String creationTimeEnd) {
        this.creationTimeEnd = creationTimeEnd;
    }
}
