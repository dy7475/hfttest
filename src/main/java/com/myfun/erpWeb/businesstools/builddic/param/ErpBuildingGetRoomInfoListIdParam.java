package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2018/12/13
 */
public class ErpBuildingGetRoomInfoListIdParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID(号位时不传)")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元ID")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "是否是模板 0=不是模板 1=模板")
    private Integer buildTemplate;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(Integer buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public Integer getBuildingSetUnitId() {
        return buildingSetUnitId;
    }

    public void setBuildingSetUnitId(Integer buildingSetUnitId) {
        this.buildingSetUnitId = buildingSetUnitId;
    }

    public Integer getBuildTemplate() {
        return buildTemplate;
    }

    public void setBuildTemplate(Integer buildTemplate) {
        this.buildTemplate = buildTemplate;
    }
}