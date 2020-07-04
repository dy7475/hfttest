package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/4/3
 */
public class BuildingInfoInMobileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("楼盘ID")
    private Integer buildId;

    @ApiModelProperty("楼盘名字")
    private String buildName;

    @ApiModelProperty(value="楼盘推广名-美联")
    private String promotionName;

    @ApiModelProperty("楼盘锁定")
    private Integer buildLock = 0;

    @ApiModelProperty("片区ID")
    private Integer sectionId;

    @ApiModelProperty("片区名称")
    private String sectionName;

    @ApiModelProperty("首图地址")
    private String firstPicAddr;

    @ApiModelProperty("图片数量")
    private Integer picCount = 0;

    @ApiModelProperty("出售数量")
    private Integer saleCount = 0;

    @ApiModelProperty("出租数量")
    private Integer leaseCount = 0;

    @ApiModelProperty("栋数")
    private Integer roofs = 0;

    @ApiModelProperty("单元数")
    private Integer units = 0;

    @ApiModelProperty("户数")
    private Integer doors = 0;

    @ApiModelProperty("检索码")
    private String buildCode;

    @ApiModelProperty("楼盘位置")
    private String buildAddr;

    @ApiModelProperty("行政区域")
    private Integer buildRegion;

    @ApiModelProperty("环域 DD:HOUSE_ROUND")
    private Byte buildRound;

    @ApiModelProperty("建筑类型 DD:BUILD_TYPE")
    private String buildType;

    @ApiModelProperty("建成日期")
    private String buildDate;

    @ApiModelProperty("建筑年代")
    private String finishDate;

    @ApiModelProperty("创建时间")
    private String createTime;

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Integer getBuildLock() {
        return buildLock;
    }

    public void setBuildLock(Integer buildLock) {
        this.buildLock = buildLock;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getFirstPicAddr() {
        return firstPicAddr;
    }

    public void setFirstPicAddr(String firstPicAddr) {
        this.firstPicAddr = firstPicAddr;
    }

    public Integer getPicCount() {
        return picCount;
    }

    public void setPicCount(Integer picCount) {
        this.picCount = picCount;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getLeaseCount() {
        return leaseCount;
    }

    public void setLeaseCount(Integer leaseCount) {
        this.leaseCount = leaseCount;
    }

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

    public String getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode;
    }

    public String getBuildAddr() {
        return buildAddr;
    }

    public void setBuildAddr(String buildAddr) {
        this.buildAddr = buildAddr;
    }

    public Integer getBuildRegion() {
        return buildRegion;
    }

    public void setBuildRegion(Integer buildRegion) {
        this.buildRegion = buildRegion;
    }

    public Byte getBuildRound() {
        return buildRound;
    }

    public void setBuildRound(Byte buildRound) {
        this.buildRound = buildRound;
    }

    public String getBuildType() {
        return buildType;
    }

    public void setBuildType(String buildType) {
        this.buildType = buildType;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }
}