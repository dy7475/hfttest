package com.myfun.erpWeb.businesstools.builddic.vo;

import com.myfun.repository.erpdb.po.ErpBuildingSetRoomLayout;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class ErpRegisterBuildingSetRoomLaYouTVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private Integer buildingSetRoomLayoutId;

    @ApiModelProperty("楼盘id")
    private Integer buildId;

    @ApiModelProperty("房间id")
    private Integer buildingSetRoomId;

    @ApiModelProperty("户型图地址")
    private String laYouTUrl;

    public Integer getBuildingSetRoomLayoutId() {
        return buildingSetRoomLayoutId;
    }

    public void setBuildingSetRoomLayoutId(Integer buildingSetRoomLayoutId) {
        this.buildingSetRoomLayoutId = buildingSetRoomLayoutId;
    }
    
    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getBuildingSetRoomId() {
        return buildingSetRoomId;
    }

    public void setBuildingSetRoomId(Integer buildingSetRoomId) {
        this.buildingSetRoomId = buildingSetRoomId;
    }

    public String getLaYouTUrl() {
        return laYouTUrl;
    }

    public void setLaYouTUrl(String laYouTUrl) {
        this.laYouTUrl = laYouTUrl;
    }
}
