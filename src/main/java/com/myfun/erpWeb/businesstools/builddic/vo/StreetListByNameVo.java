package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2020/2/14
 */
public class StreetListByNameVo implements Serializable {

    @ApiModelProperty(value = "街道ID")
    private Integer id;

    @ApiModelProperty(value = "街道名称")
    private String streetName;

    @ApiModelProperty(value = "行政区以及商圈信息")
    private List<SectionVO> sections;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public List<SectionVO> getSections() {
        return sections;
    }

    public void setSections(List<SectionVO> sections) {
        this.sections = sections;
    }
}