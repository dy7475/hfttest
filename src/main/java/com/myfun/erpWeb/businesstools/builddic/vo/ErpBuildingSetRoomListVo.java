package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2018/12/13
 */
public class ErpBuildingSetRoomListVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "楼层列表")
    private List<ErpBuildingSetFloorVo> floorList;

    @ApiModelProperty(value = "房间列表")
    private List<ErpBuildingSetRoomShowInTableVo> roomList;

    public List<ErpBuildingSetFloorVo> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<ErpBuildingSetFloorVo> floorList) {
        this.floorList = floorList;
    }

    public List<ErpBuildingSetRoomShowInTableVo> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<ErpBuildingSetRoomShowInTableVo> roomList) {
        this.roomList = roomList;
    }
}