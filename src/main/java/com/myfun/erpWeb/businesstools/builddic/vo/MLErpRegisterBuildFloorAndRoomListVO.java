package com.myfun.erpWeb.businesstools.builddic.vo;


import io.swagger.annotations.ApiModelProperty;

public class MLErpRegisterBuildFloorAndRoomListVO extends ErpRegisterBuildFloorAndRoomListVO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "整层是否被注册过 1：是，0：否")
    private Byte mlWholeLayer = Byte.valueOf("0");

    @ApiModelProperty(value = "栋")
    private String buildRoof ;

    @ApiModelProperty(value = "单元")
    private String buildUnit ;

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public Byte getMlWholeLayer() {
        return mlWholeLayer;
    }

    public void setMlWholeLayer(Byte mlWholeLayer) {
        this.mlWholeLayer = mlWholeLayer;
    }
}
