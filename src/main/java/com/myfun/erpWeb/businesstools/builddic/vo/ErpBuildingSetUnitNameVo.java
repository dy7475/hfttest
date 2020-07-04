package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author czq
 * @since 2018/12/20
 */
public class ErpBuildingSetUnitNameVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单元ID单元名称Vo列表")
    private List<ErpBuildingSetUnitVo> unitNameListVo;

    @ApiModelProperty(value = "是否有模板信息(0没有模板,1有模板)")
    private Integer haveBuildTemplate;

    @ApiModelProperty(value = "房间是否生成完毕(1完毕）")
    private Byte roomGenerated;

    public List<ErpBuildingSetUnitVo> getUnitNameListVo() {
        return unitNameListVo;
    }

    public void setUnitNameListVo(List<ErpBuildingSetUnitVo> unitNameListVo) {
        this.unitNameListVo = unitNameListVo;
    }

    public Integer getHaveBuildTemplate() {
        return haveBuildTemplate;
    }

    public void setHaveBuildTemplate(Integer haveBuildTemplate) {
        this.haveBuildTemplate = haveBuildTemplate;
    }

    public Byte getRoomGenerated() {
        return roomGenerated;
    }

    public void setRoomGenerated(Byte roomGenerated) {
        this.roomGenerated = roomGenerated;
    }

}