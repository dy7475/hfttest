package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2019/4/3
 */
public class BuildRoomListInMobileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "楼层列表")
    private List<ErpBuildingSetFloorVo> floorList;

    @ApiModelProperty(value = "房间列表")
    private List<RoomConInfoVo> roomConInfos;

    public List<ErpBuildingSetFloorVo> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<ErpBuildingSetFloorVo> floorList) {
        this.floorList = floorList;
    }

    public List<RoomConInfoVo> getRoomConInfos() {
        return roomConInfos;
    }

    public void setRoomConInfos(List<RoomConInfoVo> roomConInfos) {
        this.roomConInfos = roomConInfos;
    }
}