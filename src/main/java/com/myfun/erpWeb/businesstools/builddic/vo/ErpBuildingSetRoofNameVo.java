package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2018/12/13
 */
public class ErpBuildingSetRoofNameVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "栋座名称")
    private String buildRoof;

    @ApiModelProperty(value = "栋别名(单位)")
    private String buildRoofName;

    @ApiModelProperty(value = "销控表中的数量")
    private Integer count;

    @ApiModelProperty(value = "单元别名(默认:单元)", hidden = true)
    private String buildUnitName;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }
}