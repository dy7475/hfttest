package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2020/2/7
 */
public class SectionVO implements Serializable {

    @ApiModelProperty(value = "对应的街道行政区表ID")
    private Integer streetRegId;

    @ApiModelProperty(value= "行政区名称")
    private String regName;

    @ApiModelProperty(value = "单个商圈ID")
    private Integer streetSectionId;

    @ApiModelProperty(value = "商圈名称")
    private String sectionName;

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

    public Integer getStreetSectionId() {
        return streetSectionId;
    }

    public void setStreetSectionId(Integer streetSectionId) {
        this.streetSectionId = streetSectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}