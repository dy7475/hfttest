package com.myfun.erpWeb.managecenter.buildData.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @create by 程二狗 on 2019/2/21 0021
 **/
@ApiModel
public class updateFunBuildlimitStatus implements Serializable{
    @ApiModelProperty("楼盘分配Id")
    private Integer limitId;
    @ApiModelProperty("已暂停0  进行中1")
    private Byte status;

    public Integer getLimitId() {
        return limitId;
    }

    public void setLimitId(Integer limitId) {
        this.limitId = limitId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
