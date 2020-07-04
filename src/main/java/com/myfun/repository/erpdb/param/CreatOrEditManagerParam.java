package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreatOrEditManagerParam implements EncryParamIfc {
    @ApiModelProperty("楼盘ID")
    private Integer buildId;
    @ApiModelProperty("栋座id 逗号隔开  栋座为空时设置楼盘总负责人")
    private String buildingSetRoofId;
    @ApiModelProperty("维护人id")
    private Integer userId;

    @ApiModelProperty(hidden = true)
    private Integer cityId;
    @ApiModelProperty(hidden = true)
    private Integer compId;

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

    @ApiModelProperty(hidden = true)

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(String buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
