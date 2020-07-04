package com.myfun.erpWeb.managecenter.transaction.vo;

import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class DisablePerformanceTypeJudgmentVO {
    @ApiModelProperty(value = "列表")
    private List<ErpFunPerformanceType> list;

    public List<ErpFunPerformanceType> getList() {
        return list;
    }

    public void setList(List<ErpFunPerformanceType> list) {
        this.list = list;
    }
}
