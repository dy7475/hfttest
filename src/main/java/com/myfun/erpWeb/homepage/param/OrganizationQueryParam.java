package com.myfun.erpWeb.homepage.param;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationQueryParam {

    @ApiModelProperty(value = "考核类型，1=日考核2=周考核3=月考核")
    private Integer dateType;
    @ApiModelProperty(value = "查看类型,产值参考数据字典类型DIC_TYPE = 'STATISTICS_TYPE'的DIC_VALUE值", required = true)
    private Integer lookRankType;
    @ApiModelProperty(value = "用于区分房客源跟进，登记 1=房源，2=客源")
    private Integer funCust;
    @ApiModelProperty(value = "层级主键ID   (员工:-2)")
    private Integer defId;
    @ApiModelProperty(value = "查看层级ID(员工:-2)")
    private Integer lookDefId;
    @ApiModelProperty(value = "本组织机构ID")
    private Integer organizationId;
    @ApiModelProperty(value = "管理范围Ids")
    private String organizationIds;
    @ApiModelProperty(value = "开始时间", required = true)
    private String startDate;
    @ApiModelProperty(value = "结束时间,如:2018-12-11", required = true)
    private String endDate;


    public Integer getLookRankType() {
        return lookRankType;
    }

    public void setLookRankType(Integer lookRankType) {
        this.lookRankType = lookRankType;
    }

    public Integer getDefId() {
        return defId;
    }

    public void setDefId(Integer defId) {
        this.defId = defId;
    }

    public Integer getLookDefId() {
        return lookDefId;
    }

    public void setLookDefId(Integer lookDefId) {
        this.lookDefId = lookDefId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationIds() {
        return organizationIds;
    }

    public void setOrganizationIds(String organizationIds) {
        this.organizationIds = organizationIds;
    }

    public Integer getDateType() {
        return dateType;
    }

    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }

    public Integer getFunCust() {
        return funCust;
    }

    public void setFunCust(Integer funCust) {
        this.funCust = funCust;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
