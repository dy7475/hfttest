package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetBuildBaseInfoVo {

    @ApiModelProperty("总栋数")
    private Integer roofs = 0;

    @ApiModelProperty("总单元数")
    private Integer units = 0;

    @ApiModelProperty("总户数")
    private Integer rooms = 0;

    @ApiModelProperty("在售量")
    private Integer onSaleCount = 0;

    @ApiModelProperty("在租量")
    private Integer onLeaseCount = 0;

    @ApiModelProperty("租售数量")
    private Integer saleAndLeaseCount = 0;

    @ApiModelProperty("楼盘责任人")
    private Integer buildManager;

    @ApiModelProperty("是否锁定，0=未锁定 1=锁定")
    private Byte buildLock = 0;

    public Integer getRoofs() {
        return roofs;
    }

    public void setRoofs(Integer roofs) {
        this.roofs = roofs;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getOnSaleCount() {
        return onSaleCount;
    }

    public void setOnSaleCount(Integer onSaleCount) {
        this.onSaleCount = onSaleCount;
    }

    public Integer getOnLeaseCount() {
        return onLeaseCount;
    }

    public void setOnLeaseCount(Integer onLeaseCount) {
        this.onLeaseCount = onLeaseCount;
    }

    public Integer getSaleAndLeaseCount() {
        return saleAndLeaseCount;
    }

    public void setSaleAndLeaseCount(Integer saleAndLeaseCount) {
        this.saleAndLeaseCount = saleAndLeaseCount;
    }

    public Integer getBuildManager() {
        return buildManager;
    }

    public void setBuildManager(Integer buildManager) {
        this.buildManager = buildManager;
    }

    public Byte getBuildLock() {
        return buildLock;
    }

    public void setBuildLock(Byte buildLock) {
        this.buildLock = buildLock;
    }
}
