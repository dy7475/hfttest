package com.myfun.erpWeb.businesstools.builddic.vo;

import java.io.Serializable;

/**
 * @author czq
 * @since 2018/12/13
 */
public class ErpFunBuildRoofUnitDoorsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roofs;   // 栋数
    private Integer units;   // 单元数
    private Integer doors;   // 户数

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

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }
}