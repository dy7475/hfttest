package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2019/4/3
 */
public class RoomConInfoListVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "房态表列表")
    private List<RoomConInfoVo> roomConInfoVos;

    public List<RoomConInfoVo> getRoomConInfoVos() {
        return roomConInfoVos;
    }

    public void setRoomConInfoVos(List<RoomConInfoVo> roomConInfoVos) {
        this.roomConInfoVos = roomConInfoVos;
    }
}