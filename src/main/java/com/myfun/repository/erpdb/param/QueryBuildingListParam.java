package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 王淳
 * @since 2018年12月12日
 */
@ApiModel
public class QueryBuildingListParam extends AbstractEncryParam implements DaoBaseParam {

    @ApiModelProperty("楼盘搜索综合字段（全拼，简拼，楼盘名，别名，别名全拼，别名简拼） 顺序相同|分割")
    private String buildName;

    @ApiModelProperty("是否锁定，0=未锁定 1=锁定")
    private Byte buildStatus;

    @ApiModelProperty("楼盘id  逗号隔开")
    private String buildIds;

    @ApiModelProperty("区域id")
    private Integer regionId;

    @ApiModelProperty("片区ID 逗号隔开")
    private String sectionIds;

    @ApiModelProperty("用户ID，由我维护与选人时传该值，由我店维护传deptId")
    private Integer userId;

    @ApiModelProperty("门店ID，由我店维护传该值，由我维护与选人时传userId")
    private Integer deptId;

    @ApiModelProperty(hidden = true)
    private Integer cityId;

    @ApiModelProperty(hidden = true)
    private Integer buildingFlag;

    @ApiModelProperty(hidden = true)
    private String buildCode;

    @ApiModelProperty(hidden = true)
    private String orderBy;

    @ApiModelProperty(hidden = true)
    private String[] sectionIdList;

    @ApiModelProperty(hidden = true)
    private String[] buildIdList;

    @ApiModelProperty("组织机构ID")
    private Integer organizationId;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Byte getBuildStatus() {
        return buildStatus;
    }

    public void setBuildStatus(Byte buildStatus) {
        this.buildStatus = buildStatus;
    }

    public String getBuildIds() {
        return buildIds;
    }

    public void setBuildIds(String buildIds) {
        this.buildIds = buildIds;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getSectionIds() {
        return sectionIds;
    }

    public void setSectionIds(String sectionIds) {
        this.sectionIds = sectionIds;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getBuildingFlag() {
        return buildingFlag;
    }

    public void setBuildingFlag(Integer buildingFlag) {
        this.buildingFlag = buildingFlag;
    }

    public String getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String[] getSectionIdList() {
        return sectionIdList;
    }

    public void setSectionIdList(String[] sectionIdList) {
        this.sectionIdList = sectionIdList;
    }

    public String[] getBuildIdList() {
        return buildIdList;
    }

    public void setBuildIdList(String[] buildIdList) {
        this.buildIdList = buildIdList;
    }
}
