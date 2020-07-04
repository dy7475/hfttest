package com.myfun.erpWeb.businesstools.builddic.param;

/**
 * @author czq
 * @since 2018/12/28
 */
public class BatchUpdateRoomMd5 {

    private Integer buildId;
    private Integer buildingSetRoomId;
    // 需要更新的MD5
    private String addMd5;
    // 更新前的MD5
    private String oldAddMd5;

    // 销控表需要更新的buildRoof
    private String buildRoof;

    // 销控表需要更新的buildUnit
    private String buildUnit;

    // 销控表需要更新的buildFloor
    private String buildFloor;

    // 销控表需要更新的roomId
    private String roomId;

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

    public String getAddMd5() {
        return addMd5;
    }

    public void setAddMd5(String addMd5) {
        this.addMd5 = addMd5;
    }

    public String getOldAddMd5() {
        return oldAddMd5;
    }

    public void setOldAddMd5(String oldAddMd5) {
        this.oldAddMd5 = oldAddMd5;
    }

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

    public String getBuildFloor() {
        return buildFloor;
    }

    public void setBuildFloor(String buildFloor) {
        this.buildFloor = buildFloor;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}