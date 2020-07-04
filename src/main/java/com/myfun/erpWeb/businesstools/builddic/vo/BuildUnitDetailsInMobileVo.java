package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/4/3
 */
public class BuildUnitDetailsInMobileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单元ID(号位ID)")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "号位名")
    private String buildUnit;

    @ApiModelProperty(value = "号位别名(单位)")
    private String buildUnitName;

    @ApiModelProperty(value = "号位出售数量")
    private Integer saleCount;

    @ApiModelProperty(value = "号位出租数量")
    private Integer leaseCount;

    @ApiModelProperty(value = "号位租售数量")
    private Integer saleAndLeaseCount;

    public Integer getBuildingSetUnitId() {
        return buildingSetUnitId;
    }

    public void setBuildingSetUnitId(Integer buildingSetUnitId) {
        this.buildingSetUnitId = buildingSetUnitId;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getLeaseCount() {
        return leaseCount;
    }

    public void setLeaseCount(Integer leaseCount) {
        this.leaseCount = leaseCount;
    }

    public Integer getSaleAndLeaseCount() {
        return saleAndLeaseCount;
    }

    public void setSaleAndLeaseCount(Integer saleAndLeaseCount) {
        this.saleAndLeaseCount = saleAndLeaseCount;
    }

}