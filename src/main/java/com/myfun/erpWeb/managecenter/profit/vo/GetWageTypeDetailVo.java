package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.po.ErpFunCountwage;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取提成方案详情VO")
public class GetWageTypeDetailVo implements Serializable {
    @ApiModelProperty("提成方案详情")
    private List<ErpFunWageTypeNew> wageType;
    @ApiModelProperty("提成方案详情")
    private List<ErpFunCountwage> countList;

    public List<ErpFunWageTypeNew> getWageType() {
        return wageType;
    }

    public void setWageType(List<ErpFunWageTypeNew> wageType) {
        this.wageType = wageType;
    }

    public List<ErpFunCountwage> getCountList() {
        return countList;
    }

    public void setCountList(List<ErpFunCountwage> countList) {
        this.countList = countList;
    }
}
