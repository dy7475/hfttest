package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ApiModel
public class PersonnalPortentialPerformanceVO {
    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型")
    private Byte caseType;
    @ApiModelProperty(value = "排序字段",hidden = true)
    private Integer sortNum;
    @ApiModelProperty(value = "标题图")
    private List<String> funPhotoList;
    @ApiModelProperty(value = "房源编号")
    private String funNum;
    @ApiModelProperty(value = "户型")
    private String houseType;
    @ApiModelProperty(value = "面积")
    private BigDecimal area;
    @ApiModelProperty(value = "总价(带单位)")
    private String totalPrice;
    @ApiModelProperty(value = "带看次数")
    private Integer takeLookTimeCount;
    @ApiModelProperty(value = "业绩详情：{position:角色，inputTime:录入时间，money:对应钱}")
    private List<Map<String,Object>> performanceDetail;

    @ApiModelProperty(value = "房源创建时间")
    private Date funCreationTime;

    public Date getFunCreationTime() {
        return funCreationTime;
    }

    public void setFunCreationTime(Date funCreationTime) {
        this.funCreationTime = funCreationTime;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public List<String> getFunPhotoList() {
        return funPhotoList;
    }

    public void setFunPhotoList(List<String> funPhotoList) {
        this.funPhotoList = funPhotoList;
    }

    public String getFunNum() {
        return funNum;
    }

    public void setFunNum(String funNum) {
        this.funNum = funNum;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTakeLookTimeCount() {
        return takeLookTimeCount;
    }

    public void setTakeLookTimeCount(Integer takeLookTimeCount) {
        this.takeLookTimeCount = takeLookTimeCount;
    }

    public List<Map<String, Object>> getPerformanceDetail() {
        return performanceDetail;
    }

    public void setPerformanceDetail(List<Map<String, Object>> performanceDetail) {
        this.performanceDetail = performanceDetail;
    }
}
