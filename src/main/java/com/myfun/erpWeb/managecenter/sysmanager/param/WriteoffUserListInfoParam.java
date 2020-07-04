package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModelProperty;

public class WriteoffUserListInfoParam extends AbstractEncryParam {

    @ApiModelProperty(value = "查询往前多少月，默认12月")
    private Integer month = 12;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
