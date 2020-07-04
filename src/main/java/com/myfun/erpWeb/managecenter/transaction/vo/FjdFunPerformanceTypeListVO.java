package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class FjdFunPerformanceTypeListVO {
    @ApiModelProperty(value = "业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融")
    private Integer collectionType;
    @ApiModelProperty(value = "业绩类别中文")
    private String collectionTypeCn;
    @ApiModelProperty(value = "列表")
    private List<FjdFunPerformanceTypeVO> list;

    public String getCollectionTypeCn() {
        return collectionTypeCn;
    }

    public void setCollectionTypeCn(String collectionTypeCn) {
        this.collectionTypeCn = collectionTypeCn;
    }

    public Integer getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(Integer collectionType) {
        this.collectionType = collectionType;
    }

    public List<FjdFunPerformanceTypeVO> getList() {
        return list;
    }

    public void setList(List<FjdFunPerformanceTypeVO> list) {
        this.list = list;
    }
}
