package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/4/4
 */
public class RoomConInfoByCaseInMobileParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID(需要筛选出栋的销控信息时传值;号位时此ID不传)")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元或者号位ID(需要筛选出单元或者号位的销控信息时传值)")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "类型 1=出售 2=出租 3=租售")
    private Byte caseType;

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

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Integer getBuildTemplate() {
        return buildTemplate;
    }

    public void setBuildTemplate(Integer buildTemplate) {
        this.buildTemplate = buildTemplate;
    }
}