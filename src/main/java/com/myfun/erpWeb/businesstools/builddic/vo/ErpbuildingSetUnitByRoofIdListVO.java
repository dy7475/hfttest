package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ErpbuildingSetUnitByRoofIdListVO {
    @ApiModelProperty
    private List<ErpbuildingSetUnitByRoofIdVO> erpbuildingSetUnitByRoofIdVOList;

    public List<ErpbuildingSetUnitByRoofIdVO> getErpbuildingSetUnitByRoofIdVOList() {
        return erpbuildingSetUnitByRoofIdVOList;
    }

    public void setErpbuildingSetUnitByRoofIdVOList(List<ErpbuildingSetUnitByRoofIdVO> erpbuildingSetUnitByRoofIdVOList) {
        this.erpbuildingSetUnitByRoofIdVOList = erpbuildingSetUnitByRoofIdVOList;
    }
}
