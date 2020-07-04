package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2019/4/3
 */
public class FloorListVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "楼层信息(包含每层楼房间信息)")
    private List<FloorInfoVo> floors;

    @ApiModelProperty(value = "房间是否生成完毕(1完毕）")
    private Byte roomGenerated;

    public List<FloorInfoVo> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorInfoVo> floors) {
        this.floors = floors;
    }

    public Byte getRoomGenerated() {
        return roomGenerated;
    }

    public void setRoomGenerated(Byte roomGenerated) {
        this.roomGenerated = roomGenerated;
    }
}