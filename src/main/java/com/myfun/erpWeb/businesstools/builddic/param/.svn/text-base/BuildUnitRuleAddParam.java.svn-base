package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author czq
 * @since 2019/4/3
 */
public class BuildUnitRuleAddParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty("责任人用户ID")
    private Integer buildingManagerId;

    @ApiModelProperty(value = "号位别名(默认:号)")
    private String buildUnitName;

    @ApiModelProperty(value = "号位列表")
    private List<UnitAddParam> units;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getBuildingManagerId() {
        return buildingManagerId;
    }

    public void setBuildingManagerId(Integer buildingManagerId) {
        this.buildingManagerId = buildingManagerId;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public List<UnitAddParam> getUnits() {
        return units;
    }

    public void setUnits(List<UnitAddParam> units) {
        this.units = units;
    }
}