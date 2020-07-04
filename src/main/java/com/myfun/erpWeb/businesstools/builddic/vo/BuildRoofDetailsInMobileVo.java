package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2019/4/3
 */
public class BuildRoofDetailsInMobileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "栋座名称")
    private String buildRoof;

    @ApiModelProperty(value = "栋别名(单位)")
    private String buildRoofName;

    @ApiModelProperty("责任人用户ID(栋座管理人)")
    private Integer buildingManagerId;

    @ApiModelProperty(value = "栋座出售数量")
    private Integer saleCount;

    @ApiModelProperty(value = "栋座出租数量")
    private Integer leaseCount;

    @ApiModelProperty(value = "栋座租售数量")
    private Integer saleAndLeaseCount;

    @ApiModelProperty(value = "单元名称列表")
    private List<BuildUnitNameInMobileVo> units;

    public Integer getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(Integer buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
    }

    public String getBuildRoofName() {
        return buildRoofName;
    }

    public void setBuildRoofName(String buildRoofName) {
        this.buildRoofName = buildRoofName;
    }

    public Integer getBuildingManagerId() {
        return buildingManagerId;
    }

    public void setBuildingManagerId(Integer buildingManagerId) {
        this.buildingManagerId = buildingManagerId;
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

    public List<BuildUnitNameInMobileVo> getUnits() {
        return units;
    }

    public void setUnits(List<BuildUnitNameInMobileVo> units) {
        this.units = units;
    }
}