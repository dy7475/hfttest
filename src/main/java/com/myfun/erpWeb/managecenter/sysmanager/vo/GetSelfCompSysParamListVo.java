package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApiModel(description = "获取自己公司的系统参数Vo")
public class GetSelfCompSysParamListVo implements Serializable {

    @ApiModelProperty("普通管控默认值 key=paramId value=defaultValue")
    private List<Map<String,Object>> defaultValueList = new ArrayList<>();
    @ApiModelProperty("中级管控默认值 key=paramId value=mediumValue")
    private List<Map<String,Object>> mediumValueList = new ArrayList<>();
    @ApiModelProperty("强管控默认值 key=paramId value=seniorValue")
    private List<Map<String,Object>> seniorValueList = new ArrayList<>();

    public List<Map<String, Object>> getDefaultValueList() {
        return defaultValueList;
    }

    public void setDefaultValueList(List<Map<String, Object>> defaultValueList) {
        this.defaultValueList = defaultValueList;
    }

    public List<Map<String, Object>> getMediumValueList() {
        return mediumValueList;
    }

    public void setMediumValueList(List<Map<String, Object>> mediumValueList) {
        this.mediumValueList = mediumValueList;
    }

    public List<Map<String, Object>> getSeniorValueList() {
        return seniorValueList;
    }

    public void setSeniorValueList(List<Map<String, Object>> seniorValueList) {
        this.seniorValueList = seniorValueList;
    }
}
