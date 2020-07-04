package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2018/12/20
 */
public class BuildRoofListVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "栋ID栋名称Vo列表")
    private List<ErpBuildingSetRoofNameVo> RoofNameListVo;

    @ApiModelProperty(value = "是否有模板信息(0没有模板,1有模板)")
    private Integer haveBuildTemplate;

    public List<ErpBuildingSetRoofNameVo> getRoofNameListVo() {
        return RoofNameListVo;
    }

    public void setRoofNameListVo(List<ErpBuildingSetRoofNameVo> roofNameListVo) {
        RoofNameListVo = roofNameListVo;
    }

    public Integer getHaveBuildTemplate() {
        return haveBuildTemplate;
    }

    public void setHaveBuildTemplate(Integer haveBuildTemplate) {
        this.haveBuildTemplate = haveBuildTemplate;
    }
}