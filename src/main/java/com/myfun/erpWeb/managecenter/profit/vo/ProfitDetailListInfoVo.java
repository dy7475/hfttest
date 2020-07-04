package com.myfun.erpWeb.managecenter.profit.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * create by 程二狗 on 2018/11/7 0007
 */
@ApiModel
public class ProfitDetailListInfoVo implements Serializable {
    @ApiModelProperty(value = "返回列表")
    private  List<ProfitDetailVo> list = new ArrayList<>();

    public List<ProfitDetailVo> getList() {
        return list;
    }

    public void setList(List<ProfitDetailVo> list) {
        this.list = list;
    }
}
