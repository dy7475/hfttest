package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

@ApiModel
public class GetFjdFunPerformanceTypeListVO {
    @ApiModelProperty(value = "列表")
    private List<FjdFunPerformanceTypeListVO> typeList;
    @ApiModelProperty(value = "抽取总业绩")
    private String paramValue;

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public List<FjdFunPerformanceTypeListVO> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<FjdFunPerformanceTypeListVO> typeList) {
        this.typeList = typeList;
    }
}
