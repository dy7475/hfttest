package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class ErpBuildingLockDataVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("1=成功  2=失败")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
