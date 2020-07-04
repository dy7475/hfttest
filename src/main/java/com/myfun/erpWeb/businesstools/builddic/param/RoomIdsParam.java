package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangchun
 * @since 2018/12/19
 */
@ApiModel
public class RoomIdsParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘id")
    private Integer buildId;
    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;
    @ApiModelProperty("单元id")
    private Integer buildingSetUnitId;
    @ApiModelProperty(value = "房间id字符串(用逗号分隔开 例如1,2,3)")
    private String buildingSetRoomIds;

    @ApiModelProperty(hidden = true)
    private Integer cityId;
    @ApiModelProperty(hidden = true)
    private Integer compId;
    @ApiModelProperty(hidden = true)
    private Integer selfUserId;

    public Integer getBuildingSetUnitId() {
        return buildingSetUnitId;
    }

    public void setBuildingSetUnitId(Integer buildingSetUnitId) {
        this.buildingSetUnitId = buildingSetUnitId;
    }

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

    public String getBuildingSetRoomIds() {
        return buildingSetRoomIds;
    }

    public void setBuildingSetRoomIds(String buildingSetRoomIds) {
        this.buildingSetRoomIds = buildingSetRoomIds;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getSelfUserId() {
        return selfUserId;
    }

    public void setSelfUserId(Integer selfUserId) {
        this.selfUserId = selfUserId;
    }
}