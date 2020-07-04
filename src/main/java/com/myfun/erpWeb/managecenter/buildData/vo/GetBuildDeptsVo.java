package com.myfun.erpWeb.managecenter.buildData.vo;

import com.myfun.repository.erpdb.po.ErpBuildAllot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @create by 程二狗 on 2019/2/23 0023
 **/
@ApiModel
public class GetBuildDeptsVo implements Serializable {
    @ApiModelProperty("楼盘分配门店")
    private List<ErpBuildAllot> allotList;

    public List<ErpBuildAllot> getAllotList() {
        return allotList;
    }

    public void setAllotList(List<ErpBuildAllot> allotList) {
        this.allotList = allotList;
    }
}
