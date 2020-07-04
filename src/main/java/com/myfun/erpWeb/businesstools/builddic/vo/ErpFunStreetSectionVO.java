package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author czq
 * @since 2020/2/7
 */
public class ErpFunStreetSectionVO implements Serializable {

    @ApiModelProperty(value = "主键自增")
    private Integer id;

    @ApiModelProperty(value = "公司ID")
    private Integer compId;

    @ApiModelProperty(value = "对应的街道地区表ID")
    private Integer streetTerritoryId;

    @ApiModelProperty(value = "对应的街道省份表ID")
    private Integer streetProvinceId;

    @ApiModelProperty(value = "对应的街道城市表ID")
    private Integer streetCityId;

    @ApiModelProperty(value= "城市名称")
    private String cityName;

    @ApiModelProperty(value = "对应的街道行政区表ID")
    private Integer streetRegId;

    @ApiModelProperty(value= "行政区名称")
    private String regName;

    @ApiModelProperty(value = "商圈名称")
    private String sectionName;

    @ApiModelProperty(value = "唯一编码")
    private String code;

    @ApiModelProperty(value = "排序")
    private Integer seqNo;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getStreetTerritoryId() {
        return streetTerritoryId;
    }

    public void setStreetTerritoryId(Integer streetTerritoryId) {
        this.streetTerritoryId = streetTerritoryId;
    }

    public Integer getStreetProvinceId() {
        return streetProvinceId;
    }

    public void setStreetProvinceId(Integer streetProvinceId) {
        this.streetProvinceId = streetProvinceId;
    }

    public Integer getStreetCityId() {
        return streetCityId;
    }

    public void setStreetCityId(Integer streetCityId) {
        this.streetCityId = streetCityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getStreetRegId() {
        return streetRegId;
    }

    public void setStreetRegId(Integer streetRegId) {
        this.streetRegId = streetRegId;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}