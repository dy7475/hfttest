package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunCountwage;
import com.myfun.repository.erpdb.po.ErpFunWageType;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @create by 程二狗 on 2019/1/19 0019
 **/
@ApiModel
public class ErpFunWageTypeNewDto extends ErpFunWageTypeNew {
    @ApiModelProperty(value = "方案提成区间的数据",hidden = true)
    private String countWageJson;
    @ApiModelProperty("方案下的提成区间的数据")
    private List<ErpFunCountwage> erpFunCountwageList;

    public List<ErpFunCountwage> getErpFunCountwageList() {
        return erpFunCountwageList;
    }

    public void setErpFunCountwageList(List<ErpFunCountwage> erpFunCountwageList) {
        this.erpFunCountwageList = erpFunCountwageList;
    }

    public String getCountWageJson() {
        return countWageJson;
    }

    public void setCountWageJson(String countWageJson) {
        this.countWageJson = countWageJson;
    }
}
