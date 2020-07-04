package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyFunSaleCtrl extends AgencyFunSaleCtrlKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String roof;

    /**
     *
     * @mbggenerated
     */
    private String unit;

    /**
     *
     * @mbggenerated
     */
    private Integer num;

    /**
     *
     * @mbggenerated
     */
    private String house;

    /**
     *
     * @mbggenerated
     */
    private String area;

    /**
     *
     * @mbggenerated
     */
    private String price;

    /**
     *
     * @mbggenerated
     */
    private Integer saleStatus;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private Integer updateUid;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getRoof() {
        return roof;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRoof(String roof) {
        this.roof = roof == null ? null : roof.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUnit() {
        return unit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getNum() {
        return num;
    }

    /**
     *
     * @mbggenerated
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     *
     * @mbggenerated
     */
    public String getHouse() {
        return house;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouse(String house) {
        this.house = house == null ? null : house.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSaleStatus() {
        return saleStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getUpdateUid() {
        return updateUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }
}