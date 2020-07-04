package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpBuildingSetRoom;
import com.myfun.repository.param.EncryParamIfc;

/**
 * 栋座规则房间的参数
 *
 * @author 张宏利
 * @since 2017年8月21日
 */
public class ErpBuildingSetRoomParam extends ErpBuildingSetRoom implements EncryParamIfc {
    private static final long serialVersionUID = 1L;
    private String sysRoomIds;// 所有需要修改的房间ID，多个以英文逗号分隔
    private String roomIds;// 用户填的的房间ID，多个以英文逗号分隔
    private String roomFloors;// 房间所在楼层，多个以英文逗号分隔
    private Integer selfUserId;// 当前用户ID
    private Integer sync;      // 房间信息同步到本单元同房号户型(1同步)

    public String getSysRoomIds() {
        return sysRoomIds;
    }

    public void setSysRoomIds(String sysRoomIds) {
        this.sysRoomIds = sysRoomIds;
    }

    public String getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(String roomIds) {
        this.roomIds = roomIds;
    }

    public String getRoomFloors() {
        return roomFloors;
    }

    public void setRoomFloors(String roomFloors) {
        this.roomFloors = roomFloors;
    }

    public Integer getSelfUserId() {
        return selfUserId;
    }

    public void setSelfUserId(Integer selfUserId) {
        this.selfUserId = selfUserId;
    }

    public Integer getSync() {
        return sync;
    }

    public void setSync(Integer sync) {
        this.sync = sync;
    }
}
