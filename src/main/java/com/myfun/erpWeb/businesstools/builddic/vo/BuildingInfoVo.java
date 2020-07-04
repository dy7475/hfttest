package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel
public class BuildingInfoVo {

    @ApiModelProperty("片区id")
    private Integer sectionId;
    @ApiModelProperty("楼盘锁定")
    private Integer buildLock = 0;
    @ApiModelProperty("首图地址")
    private String firstPicAddr;
    @ApiModelProperty("图片数量")
    private Integer picCount = 0;
    @ApiModelProperty("栋数")
    private Integer roofs = 0;
    @ApiModelProperty("单元数")
    private Integer units = 0;
    @ApiModelProperty("户数")
    private Integer doors = 0;


    @ApiModelProperty("栋维护人id 逗号隔开")
    private String roofManagers;
    @ApiModelProperty("楼盘维护人id")
    private Integer buildManager;
    @ApiModelProperty("在售数量")
    private Integer saleCount = 0;
    @ApiModelProperty("在租数量")
    private Integer leaseCount = 0;
    @ApiModelProperty("内成交数量")
    private Integer innerDealCount = 0;
    @ApiModelProperty("外成交数量")
    private Integer outerDealCount = 0;

    @ApiModelProperty("楼盘ID")
    private Integer buildId;
    @ApiModelProperty("楼盘名字")
    private String buildName;
    @ApiModelProperty("检索码")
    private String buildCode;
    @ApiModelProperty("开发商")
    private String buildDevloper;
    @ApiModelProperty("楼盘位置")
    private String buildAddr;
    @ApiModelProperty("行政区域")
    private Integer buildRegion;
    @ApiModelProperty("环域，DD:HOUSE_ROUND")
    private Byte buildRound;
    @ApiModelProperty("建筑类型")
    private String buildType;
    @ApiModelProperty("建筑日期")
    private String buildDate;
    @ApiModelProperty("物管公司")
    private String propertyComp;

    @ApiModelProperty(value = "是否有模板信息(0没有模板, 1有模板)")
    private Integer haveBuildTemplate;
    @ApiModelProperty(value = "推广名 --美联用")
    private String promotionName;
    @ApiModelProperty("建筑年代")
    private String finishDate;


    @ApiModelProperty("提交时间")
    private String createTime;

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(final String createTime) {
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
    
    public Integer getPicCount() {
        return picCount;
    }

    public void setPicCount(Integer picCount) {
        this.picCount = picCount == null ? 0 : picCount;
    }

    public String getRoofManagers() {
        return roofManagers;
    }

    public void setRoofManagers(String roofManagers) {
        this.roofManagers = roofManagers;
    }

    public Integer getBuildManager() {
        return buildManager;
    }

    public void setBuildManager(Integer buildManager) {
        this.buildManager = buildManager;
    }

    public String getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode;
    }

    public Integer getBuildLock() {
        return buildLock;
    }

    public void setBuildLock(Integer buildLock) {
        this.buildLock = buildLock == null ? 0 : buildLock;
    }

    public String getFirstPicAddr() {
        return firstPicAddr;
    }

    public void setFirstPicAddr(String firstPicAddr) {
        this.firstPicAddr = firstPicAddr;
    }

    public Integer getRoofs() {
        return roofs;
    }

    public void setRoofs(Integer roofs) {
        this.roofs = roofs == null ? 0: roofs;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units == null ? 0: units;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors == null ? 0: doors;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount == null ? 0: saleCount;
    }

    public Integer getLeaseCount() {
        return leaseCount;
    }

    public void setLeaseCount(Integer leaseCount) {
        this.leaseCount = leaseCount == null ? 0: leaseCount;
    }

    public Integer getInnerDealCount() {
        return innerDealCount;
    }

    public void setInnerDealCount(Integer innerDealCount) {
        this.innerDealCount = innerDealCount == null ? 0 : innerDealCount;
    }

    public Integer getOuterDealCount() {
        return outerDealCount;
    }

    public void setOuterDealCount(Integer outerDealCount) {
        this.outerDealCount = outerDealCount == null ? 0 : outerDealCount;
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

    public String getBuildDevloper() {
        return buildDevloper;
    }

    public void setBuildDevloper(String buildDevloper) {
        this.buildDevloper = buildDevloper;
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

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
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

    public String getPropertyComp() {
        return propertyComp;
    }

    public void setPropertyComp(String propertyComp) {
        this.propertyComp = propertyComp;
    }

    public Integer getHaveBuildTemplate() {
        return haveBuildTemplate;
    }

    public void setHaveBuildTemplate(Integer haveBuildTemplate) {
        this.haveBuildTemplate = haveBuildTemplate;
    }
}
