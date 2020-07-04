package com.myfun.repository.searchdb.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class SearchHezuDetail extends SearchHezuDetailKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String property;

    /**
     *
     * @mbggenerated
     */
    private Boolean isSeperator;

    /**
     *
     * @mbggenerated
     */
    private String officeLevel;

    /**
     *
     * @mbggenerated
     */
    private String shopUsage;

    /**
     *
     * @mbggenerated
     */
    private String hallStructure;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal ugArea;

    /**
     *
     * @mbggenerated
     */
    private String ugType;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal gardenArea;

    /**
     *
     * @mbggenerated
     */
    private Byte garageAmount;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getProperty() {
        return property;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getIsSeperator() {
        return isSeperator;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsSeperator(Boolean isSeperator) {
        this.isSeperator = isSeperator;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOfficeLevel() {
        return officeLevel;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOfficeLevel(String officeLevel) {
        this.officeLevel = officeLevel == null ? null : officeLevel.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getShopUsage() {
        return shopUsage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShopUsage(String shopUsage) {
        this.shopUsage = shopUsage == null ? null : shopUsage.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getHallStructure() {
        return hallStructure;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHallStructure(String hallStructure) {
        this.hallStructure = hallStructure == null ? null : hallStructure.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getUgArea() {
        return ugArea;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUgArea(BigDecimal ugArea) {
        this.ugArea = ugArea;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUgType() {
        return ugType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUgType(String ugType) {
        this.ugType = ugType == null ? null : ugType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getGardenArea() {
        return gardenArea;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGardenArea(BigDecimal gardenArea) {
        this.gardenArea = gardenArea;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getGarageAmount() {
        return garageAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGarageAmount(Byte garageAmount) {
        this.garageAmount = garageAmount;
    }
}